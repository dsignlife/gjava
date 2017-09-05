-module(db).
-export([new/0, destroy/1, write/3, read/2,
	delete/2, match/2]).

new() ->
    [].
destroy(_Db) ->
    ok.

write(Key, Value, Db) ->
    [{Key, Value}|Db].


read(Key, [{Key, Element}|_Tail]) ->
    {ok, Element};
read(Key, [_Head|Tail]) ->
    read(Key, Tail);
read(_Key, []) ->
    {error, instance}.

delete(Key, [{Key, _Element}|Tail]) ->
    Tail;
delete(Key, [Head|Tail]) ->
    [Head|delete(Key, Tail)];
delete(_Key, []) ->
    [].

match(Element, [{Key, Element}|Tail]) ->
    [Key|match(Element, Tail)];
match(Element, [_Head|Tail]) ->
    match(Element, Tail);
match(_Element, []) ->
    [].
