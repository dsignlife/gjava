%%% @author Francesco Cesarini 
%%% @copyright (C) 2012, Francesco Cesarini
%%% @doc
%%%
%%% @end
%%% Created:4 Oct 2012 by Francesco Cesarini

-module(ituring).
-compile(export_all).

start(ProcNum, MsgNum) ->
    spawn(?MODULE, master, [ProcNum, MsgNum]).

master(ProcNum, MsgNum) ->
    Pid = start_children(ProcNum-1, self()),
    io:format("ProcNum:~w Self:~w Neighbour:~p~n",[ProcNum, self(), Pid]),
    master_loop(MsgNum, Pid).

master_loop(0, Pid) ->
    Pid ! stop,
    receive stop -> stop end,
    io:format("Master stopping~n");

master_loop(MsgNum, Pid) ->
    Pid ! hello,
    receive 
	hello -> 
	    io:format("Master got msg~n"),
	    master_loop(MsgNum-1, Pid) 
    end.


start_children(0, Pid) ->
    Pid;
start_children(ProcNum, Pid) ->
    NPid = spawn(?MODULE, loop, [ProcNum,Pid]),
    start_children(ProcNum-1, NPid).

loop(ProcNum, Pid) ->
    receive 
	stop ->     
	    io:format("ProcNum:~w stop~n",[ProcNum]),
	    Pid ! stop;
	Msg -> 
	    io:format("ProcNum:~w msg~n",[ProcNum]),
	    Pid ! Msg, 
	    loop(ProcNum, Pid)
    end.


