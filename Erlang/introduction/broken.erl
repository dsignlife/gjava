%%% File    : broken.erl
%%% Author  :  <Hans@HANS-LAPTOP>
%%% Description : A little read-edit-compile exercise
%%% Created :  6 Sep 2010 by  <Hans@HANS-LAPTOP>

-module(broken).

-export([add/2, sum/1]).

%% Function that adds two numbers
%% HINT: This function is seriously broken!
add(a, b) ->
    a + b.

%% Function that sums a list of numbers
%% HINT: There is a small mistake here
sum([H | T]) -> H + sum(T);
sum([]) -> 1.



