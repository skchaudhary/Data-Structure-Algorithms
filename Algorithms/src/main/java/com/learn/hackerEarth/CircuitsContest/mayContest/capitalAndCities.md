Capitals and cities
Max. Marks: 100

Suppose we have  cities with integer coordinate on a line. First, we have to select a city to be the capital. Then in each operation, we have to choose a non-capital city and change it's coordinate by  ( or ). We have to pick the capital and do the operations exactly  time so that the sum of distances from cities to the capital is minimized. Print the index of the selected capital and the desired sum after exactly  operations. If there are multiple such choices, output the smallest index of an optimal capital.

You are required to print the index of the selected capital and required sum after  operations. If there are multiple such choices, print the smallest index of an optimal capital.

Input format

First line: Two integers  and
Second line:  integers where the  integer that contains the coordinate of the  city
Output format

Print two integers that represent the index of the capital and the minimized required sum respectively.

Constraints



Sample input #2

5 47019
19912129 5 7138912 913 200134
Sample output #2

5 27003104

SAMPLE INPUT
2 4
9 5
SAMPLE OUTPUT
1 0
Explanation
In the first sample we should choose the first city as the capital and move the other one four times.

Note that two or more cities may coincide before or after the operations.

In the second sample it's optimal to choose the last city as the capital.

Time Limit:	1.0 sec(s) for each input file.
Memory Limit:	256 MB
Source Limit:	1024 KB
Marking Scheme:	Marks are awarded if any testcase passes.