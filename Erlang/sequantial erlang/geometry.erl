%%% @author  <Hans@SAMSUNG-NF310>
%%% @copyright (C) 2011, 
%%% @doc
%%% Playing with Geometry
%%% @end
%%% Created : 21 Sep 2011 by  <Hans@SAMSUNG-NF310>

-module(geometry).

-define(PI, 3.1415926536).

-type circle()    :: {circle, number()}.
-type square()    :: {square, number()}.
-type rectangle() :: {rectangle, number(), number()}.

-type shape()     :: circle() | square() | rectangle().

-export([area/1, circumference/1,
	 larger/2, sum_areas/1, largest/1]).

%%--------------------------------------------------------------------
%% @doc
%% area/1 - Computing the area of a shape
%% @end
%%--------------------------------------------------------------------
-spec area(Shape :: shape()) -> number().
area({circle, Radius}) ->
    Radius * Radius * ?PI;
area({square, Side})   ->
    Side * Side;
area({rectangle, Width, Height}) ->
    Width * Height.

%%--------------------------------------------------------------------
%% @doc
%% circumference/1 - Computing the circumference of a shape
%% @end
%%--------------------------------------------------------------------
-spec circumference(Shape :: shape()) -> number().
circumference({circle, Radius}) ->
    2 * Radius * ?PI;
circumference({square, Side})   ->
    4 * Side;
circumference({rectangle, Width, Height}) ->
    2 * Width + 2 * Height.


%%--------------------------------------------------------------------
%% @doc
%% larger/2 - Find the larger of two shapes
%% @end
%%--------------------------------------------------------------------
-spec larger(Shape1 :: shape(), Shape2 :: shape()) -> shape().
larger(Shape1, Shape2) ->
    case area(Shape1) > area(Shape2) of
	true  -> Shape1;
	false -> Shape2
    end.
	    
%%--------------------------------------------------------------------
%% @doc
%% sum_areas/1 - Compute the total area of all shapes in the list
%% @end
%%--------------------------------------------------------------------
-spec sum_areas(Shapes :: [shape()]) -> number().
sum_areas([]) ->
    0;
sum_areas([Shape | Shapes]) ->
    area(Shape) + sum_areas(Shapes).


%% alt_sum_areas(Shapes) ->
%%     alt_sum_areas(Shapes, 0).

%% alt_sum_areas([], Sum) ->
%%     Sum;
%% alt_sum_areas([Shape | Shapes], PartialSum) ->
%%     alt_sum_areas(Shapes, PartialSum + area(Shape)).

%%--------------------------------------------------------------------
%% @doc
%% largest/1 - Find the largest shape in a list of shapes
%% Note: Crashes for the empty list!
%% @end
%%--------------------------------------------------------------------
-spec largest(Shapes :: [shape(),...]) -> shape().
largest([Shape | Shapes]) ->
    %% Idea, keep as accumulator the largest shape seen so far!
    largest(Shape, Shapes).

%% @hidden
-spec largest(LargestSoFar :: shape(), Shapes :: [shape()]) -> shape().
largest(Largest, []) ->
    Largest;
largest(LargestSoFar, [Shape | Shapes]) ->
    largest(larger(LargestSoFar, Shape), Shapes).

