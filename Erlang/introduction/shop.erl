%%% File    : shop.erl
%%% Author  :  <Hans@HANS-LAPTOP>
%%% Description : A little shop module, inspired
%%%               Joe Armstrong.
%%% Created :  6 Sep 2010 by  <Hans@HANS-LAPTOP>

-module(shop).

-export([cost/1, total/1]).

%% Cost of things
cost(apple)  -> 3;
cost(banana) -> 5;
cost(milk)   -> 2; 
cost(orange) -> 8;
cost(soda)   -> 6.

%% Total sum of purchase
%% A purchace is a list of tuples {<item>, <amount>}
total([{Item,N} | T]) ->
    cost(Item) * N + total(T);
%% The cost of no items is 0
total([]) ->
    0.

