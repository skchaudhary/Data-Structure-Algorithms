Minimize the delivery time
Max. Marks: 100

Problem updated (please see Output section)

A company aimed at becoming the first company that solved the MDT problem for factories and restaurants. The MDT problem is easy to explain in an undirected connected graph. Find  vertex-disjoint (excluding 1, n that will appear in every path) simple paths from 1 to . If the maximum length of these paths is denoted by , then minimize .

Input format

First line: Two space-separated integers   and
Next  lines: Contains the edges, one edge per line
Output format

First line: Print  () denoting the number of paths
Next line: Print  lines (one path per line)
For each path, print the number of edges on it and then print the edges in the order.
Verdict, scoring, and test generation plan

You can find all the information here.

SAMPLE INPUT
5 13
1 2 55204
1 3 82348
3 4 32610
5 2 41029
1 5 114074
1 4 37701
1 4 207032
1 4 143497
2 3 98514
1 5 7027
2 1 133622
2 4 46926
2 1 71601
SAMPLE OUTPUT
2
1 10
2 1 4
Explanation
.

Note that choosing  and  will obtain a less score () which is better.

Time Limit:	3.0 sec(s) for each input file.
Memory Limit:	256 MB
Source Limit:	1024 KB
Marking Scheme:	Marks are awarded when all the testcases pass.