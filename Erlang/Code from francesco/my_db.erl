-module(my_db).
-export([start/0, stop/0, write/2, read/1, match/1]).
-export([init/0]).


start() ->
    register(db, spawn(?MODULE, init, [])), ok.

stop() ->
    db ! stop, ok.

write(Key, Value) ->
    db ! {write, Key, Value}, ok.

read(Key) ->
    Ref = make_ref(),
    db ! {read, {Ref, self()}, Key},
    receive {reply, Ref, Msg} -> Msg end.

match(Element) ->
    db ! {match, self(), Element},
    receive Msg -> Msg end.

init() ->
    Db = db:new(),
    loop(Db).

loop(Db) ->
    io:format("Db: ~p~n",[Db]),
    receive
	{read, {Ref, Pid}, Key} ->
	    Pid ! {reply, Ref, db:read(Key, Db)},
	    loop(Db);
	{match, Pid, Element} ->
	    Pid ! db:match(Element, Db),
	    loop(Db);
	{write, Key, Value} ->
	    loop(db:write(Key, Value, Db));
	stop ->
	    io:format("Stopping~n")
    end.
