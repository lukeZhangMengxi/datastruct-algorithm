## Problem statement
Given a list of weights and a list of costs, find the optimal subset of things that form the highest cumulative price bounded by the capacity of the knapsack.

## Runtime difference
Large input test case, sampled with weights of 100 values Random[0, 100],
profits of 100 values of Random[0, 100], and capacity of 150:
- Recursion:            11,096,764,229 ns
- Memoization:               9,547,670 ns
- Tabulation:                1,935,225 ns
- SpaceReducedTabulation:    2,176,224 ns
