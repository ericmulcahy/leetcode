# lc-solutions
Some solutions to leetcode problems

## Java

### TwoSum
Easy, not much to talk about. 
It's useful to remember you can pass or return 'tuples' as simple arrays.

### Add Two Numbers
This was pretty easy to formulate as a recursive problem. Numbers are always between 0 and 9 so there are some easy shortcuts to take. Most of the code is just dealing with boundary conditions like when one ListNode is longer than the other one. If I'd do anything different I would make a utility method to more easily construct the linked lists from input data.