-module(ituring2).
-compile(export_all).

start(ProcNum, MsgNum) ->
    spawn(?MODULE, master, [ProcNum, MsgNum]).

master(ProcNum, MsgNum) ->
    io:format("Master Started~n"),
    NPid = spawn(?MODULE,init_child,[ProcNum-1,self()]),
    receive done -> done end,
    io:format("Ring Complete~n"),
    master_loop(MsgNum, NPid).

master_loop(0, Pid) ->
    Pid ! stop,
    receive stop -> stop end,
    io:format("Master Stopping~n");

master_loop(MsgNum, Pid) ->
    Pid ! hello,
    receive 
	hello -> 
	    io:format("Master received hello~n")
    end,
    master_loop(MsgNum -1, Pid).

init_child(1, MasterPid) ->
    io:format("Child:~w started~n",[1]),
    MasterPid ! done,
    loop(1, MasterPid);

init_child(ProcNum, MasterPid) ->
    NPid = spawn(?MODULE,init_child,[ProcNum-1, MasterPid]),
    io:format("Child:~w started~n",[ProcNum]),
    loop(ProcNum, NPid).

loop(ProcNum, Pid) ->
    receive 
	stop ->
	    io:format("Child:~w stopping~n",[ProcNum]),
	    Pid ! stop;
	Msg ->
	    io:format("Child:~w received: ~w~n",[ProcNum,Msg]),
	    Pid ! Msg,
	    loop(ProcNum, Pid)
    end.

