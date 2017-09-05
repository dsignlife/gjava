%%% File    : sorting.erl
%%% Author  :  <Hans@HANS-LAPTOP>
%%% Description : Some sorting examples
%%% Created : 21 Sep 2010 by  <Hans@HANS-LAPTOP>

-module(sorting).

-export([qsort/1,qsort1/1,gen_qsort/2,
	cmp_fun/2]).

%% Normal verbose quicksort
qsort([]) -> [];
qsort([Elem]) -> [Elem];
qsort([Pivot | List]) ->
    Larger  = larger_than(Pivot,List),
    Smaller = less_than_or_equal(Pivot,List),
    qsort(Smaller) ++ [Pivot] ++ qsort(Larger).

larger_than(_Pivot,[]) -> [];
larger_than(Pivot,[H | T]) when H > Pivot ->
    [H | larger_than(Pivot,T)];
larger_than(Pivot,[_ | T]) ->
    larger_than(Pivot,T).

less_than_or_equal(_Pivot,[]) -> [];
less_than_or_equal(Pivot,[H | T]) when H =< Pivot ->
    [H | less_than_or_equal(Pivot,T)];
less_than_or_equal(Pivot,[_ | T]) ->
    less_than_or_equal(Pivot,T).

%% A more compact version
qsort1([])     -> [];
qsort1([Elem]) -> [Elem];
qsort1([Pivot | List]) ->
    qsort1([E || E <- List, E =< Pivot]) ++
	[Pivot] ++
	qsort1([E || E <- List, E > Pivot]).
		     
%% A generic quicksort, that accepts the comparison function
%% as an argument		 
gen_qsort(_CmpFun,[])     -> [];
gen_qsort(_CmpFun,[Elem]) -> [Elem];
gen_qsort(CmpFun,[Pivot | List]) ->
    gen_qsort(CmpFun,[E || E <- List, CmpFun(Pivot,E)]) ++
	[Pivot] ++
	gen_qsort(CmpFun,[E || E <- List, not CmpFun(Pivot,E)]).
	
cmp_fun(A,B) -> A > B.
    
