-module(rec).
-compile(export_all).

sum1(N) ->
    sum1(1, N).


sum1(N, N) -> N;
sum1(M, N) -> M + sum1(M+1, N).

sum2(0) -> 0;
sum2(N) ->
    N + sum2(N-1).

sum3(N) ->
    sum3(N, 0).

sum3(0, Buff) -> Buff;
sum3(N, Buff) -> sum3(N-1, Buff+N).

sum4(N, N) -> N;
sum4(M, N) ->
    M + sum4(M+1, N).

sum5(M, N) ->
    sum5(M, N, 0).
sum5(M, N, Buff) when M > N -> Buff;
sum5(M, N, Buff) when M < N->
    sum5(M+1, N, Buff+M).

sum6(M, N) ->
    sum3(N) - sum3(M-1).

reverse_create(0) ->
    [];
reverse_create(N) ->
    [N|reverse_create(N-1)].

create1(N) ->
    create1(1, N).

create1(N, N) -> [N];
create1(M, N) ->
    [M|create1(M+1, N)].

create2(N) ->
    create2(N, []).
create2(0, Buff) -> 
    Buff;
create2(N, Buff) ->
    create2(N-1, [N|Buff]).

print_all(N) ->
    print_all(1, N).
print_all(M, N) when M > N ->
    io:format("~n");
print_all(M, N) ->
    io:format("~w ",[M]),
    print_all(M+1, N).


print(0) -> 
    ok;
print(M) ->
    print(M-1),
    io:format("~w ",[M]).





