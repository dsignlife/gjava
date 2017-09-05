%%% File    : seq_erlang.erl
%%% Author  : Hans Svensson <hanssv@hanssv-ituniv>
%%% Description : Solutions to first part of exercises
%%% Created : 14 Sep 2009 by Hans Svensson <hanssv@hanssv-ituniv>

-module(seq_erlang).

%%-include_lib("erlangshit/include/eqc.hrl").
-compile(export_all).
-export([sum/1, mul/1, take_snd/1, fib/1,
         %% eff_fib/1,
         digitize/1, is_happy/1, all_happy/2,
         expr_parse/1, expr_print/1, expr_eval/1
         %%, expr_parse_2/1, expr_print_2/1, expr_eval_2/1
        ]).
%% sum
sum(N) -> 
	sum(N,0).
sum(1,Sum)->
	Sum+1;
sum(N,Sum)->
	sum(N-1,Sum+N).

%% mul
mul(N) ->
	mul(N,0).

mul(1,Result)->
	Result;
mul(N,Result)->
	mul(N-1, Result * N).

%% take_snd
take_snd(List) -> take_snd(List,[]).

take_snd([],Result)->
	Result;
take_snd([{_One,Two}|T],Result)->
	take_snd(T,[Two|Result]).	

%% Fibonacci
fib(0) -> 1;
fib(1) -> 1;
fib(N) -> fib(N-2) + fib(N-1). 	

%% Efficient fib.
%% eff_fib(_N) -> ok.

%% Digitify a number
digitize(N) -> 
    digitize(N,[]).
digitize(0,List)->
    List;
digitize(N,List) ->
    digitize(N div 10, [N rem 10|List]).

%% is_happy
is_happy(N) ->
    Num = add(divide(digitize(N),[]),0),
    case  add(divide(digitize(N),[]),0) of
	4 -> false;
	16 -> false;
	37 -> false;
	58 -> false;
	89 -> false;
	145 -> false;
	42 -> false;
	20 -> false;
	1 ->
	    true;
	_ ->
	    is_happy(Num)
    end.
    

divide([],List)->
    List;
divide([H|T],List) ->
    divide(T,[H*H|List]).

add([],Sum)->Sum;
add([H|T],Sum)->
    add(T,Sum+H).

%% all_happy
all_happy(N, M) -> 
    all_happy_check(generate_numbers(N,M,[]),[]).

all_happy_check([],List)->
    List;
all_happy_check([H|T],List)->
    case is_happy(H) of
	true ->
	    all_happy_check(T,[H|List]);
	false ->
	    all_happy_check(T,List)
    end.

generate_numbers(M,M,List)->
    [M|List];
generate_numbers(N,M,List) ->
    generate_numbers(N+1,M,[N|List]).



%% Expressions

%% A. Evaluate expressions
expr_eval(_Expr) -> ok.

%% B. Pretty print expressions
expr_print(_Expr) -> ok.

%% C. Parse expressions
expr_parse(_Str) -> ok.

%% Advanced versions of expr
%% expr_eval_2(_Expr) -> ok.

%% expr_print_2(_Expr) -> ok.

%% expr_parse_2(_Str) -> ok.


%% reverse_list(List)->
%%     reverse_list(List,[]).
%% reverse_list([],Result)->
%%     Result;
%% reverse_list([H|T],Result) ->
%%     reverse_list(T,[H|Result]).
