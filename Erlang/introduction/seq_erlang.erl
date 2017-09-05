%%% Name            :
%%% Personal number :
%%% E-mail          :

-module(seq_erlang).

%% DO NOT CHANGE THE EXPORT STATEMENT OR THE RECORD DEFINITION!
-export([sum/1, reverse/1, seq/2,
         list_duplicate/1,
         compress/1,
         decompress/1,
         new/0, destroy/1, write/3, read/2, delete/2, match/2, merge/2
        ]).

-record(db_entry, {key = undefined, elem = undefined}).
%% DO NOT CHANGE THE EXPORT STATEMENT OR THE RECORD DEFINITION!

%%
%% Problem 1
%%

sum(_List) ->
  ok.

reverse(_List) ->
  ok.

seq(_N, _M) ->
  ok.

%%
%% Problem 2
%%

list_duplicate(_List) ->
  ok.

%%
%% Problem 3
%%

compress(_List) ->
  ok.

%%
%% Problem 4
%%

decompress(_List) ->
  ok.

%%
%% Problem 5
%%

new() ->
  ok.

%% Note: This function is actually complete,
%%       you don't need to change it!
destroy(_Db) ->
  ok.

write(_Key, _Elem, _Db) ->
  ok.

read(_Key, _Db) ->
  ok.

delete(_Key, _Db) ->
  ok.

match(_Elem, _Db) ->
  ok.

merge(_Db1, _Db2) ->
  ok.
