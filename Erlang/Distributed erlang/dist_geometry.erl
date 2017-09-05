%%% @author Hans Svensson <>
%%% @copyright (C) 2012, Hans Svensson
%%% @doc
%%% Distributed Geometry
%%% @end
%%% Created : 17 Oct 2012 by Hans Svensson <>

-module(dist_geometry).

-import(geometry, [area/1]).

-export([area_rpc/1, start/0, init/0, stop/0]).

-spec start() -> pid().
start() ->
  case whereis(area_srv) of
    undefined ->
      Pid = spawn(?MODULE, init, []),
      %% Pid = spawn(fun init/0),
      %% Pid = spawn(fun() -> init() end),
      register(area_srv, Pid),
      Pid;
    Pid when is_pid(Pid) ->
      Pid
  end.

init() ->
  loop().

stop() ->
  case whereis(area_srv) of
    undefined ->
      already_stopped;
    Pid when is_pid(Pid) ->
      Pid ! {self(), stop},
      receive stopped ->
          stopped
      end
  end.

area_rpc(Shape) ->
  Ref = make_ref(),
  area_srv ! {self(), Ref, Shape},
  receive
    {result, Ref, Res} ->
      Res
  after 100 ->
      {error, area_server_not_responding}
  end.

loop() ->
  receive
    {From, Ref, Shape} ->
      From ! {result, Ref, area(Shape)},
      loop();
    {From, stop} ->
      From ! stopped
  end.

