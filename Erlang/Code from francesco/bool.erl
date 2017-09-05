-module(bool).
-export([b_not/1, b_or/2, b_and/2, b_nand/2]).

b_not(true) ->
   false;
b_not(false) ->
    true.

b_or(false, false)   -> false;
b_or(_bool1, _bool2) -> true.

b_and(true, true)     -> true;
b_and(_bool1, _bool2) -> false.

b_nand(Bool1, Bool2) ->
    b_not(b_and(Bool1, Bool2)).


 
