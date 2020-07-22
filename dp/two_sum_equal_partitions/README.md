## Problem Statement
Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both the subsets is equal.

## Runtime Analysis

- **Space optimization matters for speed!**
- **Constant runtime coeficient matters for speed!**

For input size of 1000:
- Memoization speed=O(N*4S) space=O(N*4S):
    1. 1,993,315,880 ns Failed with `java.lang.OutOfMemoryError: Java heap space`

- SmartMemoization speed=O(NS) space=O(NS):
    1. 1,046,987,491 ns
    1. 966,375,675 ns
    1. 823,724,136 ns
    1. 844,127,930 ns
    1. 749,354,220 ns
- Tabulation speed=O(NS) space=O(NS):
    1. 990,820,499 ns
    1. 851,502,435 ns
    1. 924,321,422 ns
    1. 865,977,103 ns
    1. 915,116,175 ns
- SmartTabulation speed=O(NS) space=O(2N):
    1. 681,133,400 ns
    1. 633,593,160 ns
    1. 666,300,588 ns
    1. 694,939,841 ns
    1. 677,789,631 ns