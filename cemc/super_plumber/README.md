You are to write a program to play a video game in which Super Plumber (SP) navigates
an obstacle course collecting prizes on the way to rescuing The Princess (TP).
The obstacle course is an m by n grid. SP starts at the bottom-left corner and makes his
way to TP in the bottom-right corner. Some of the grid locations are occupied by
obstacles through which SP cannot pass. Others are occupied by gold coins valued
between $1.00 and $9.00.
The game is a traditional scroll game, which means that SP can move only to the right,
up, or down. SP moves one grid location at a time, always to an adjacent location with no
obstacle. He cannot occupy any location which he previously occupied - if he moves up,
he cannot move down until he moves right; if he moves down he cannot move up until he
moves right. SP collects the gold coins at locations he visits. You are to find the
maximum possible total value of coins that SP can collect while rescuing TP.
Input has several test cases. The first line of each test case contains m and n, both integers not less than 2 or greater than 100. The grid is then given as m lines with n characters each.
An obstacle is denoted by an asterisk ('*'); a coin is denoted by a digit ('1' through
'9'); an empty location is denoted by a period ('.').
It is always possible for SP to rescue TP. A line containing 0 0 follows the last test case.
Output one line for each test case giving the amount of money that SP can collect. The
sample input below contains two test cases. For the first case, SP can collect $27.00 with
the following sequence of moves: Up, Right, Down, Right, Right, Right, Right, Up,
Right, Right, Down, Right, Right. For the second case, SP can collect $34.00 with the
following sequence: Up, Right, Down.

Sample Input:
5 10
..3.......
..........
..7.**....
.9**...1..
..8..9....

2 2
99
88

Sample Output:
27
34

