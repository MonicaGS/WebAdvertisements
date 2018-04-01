# Scheduling Web Advertisements(Offline)
Schedule ads to slots in a web page. Scheduling problem is NP-Hard. By enforcing certain constraints we can achieve polynomial time complexity. There are two approaches presented to solve the problem.

In the first approach, a single ad is scheduled to a slot. Width of the ad and slot is considered same. For simplicity purpose, payoff obtained by scheduling any ad is not less than 0. There are equal number of ads and slots. Payoff matrix is calculated for each assignment and problem is reduced to bipartite matching. Solution exists if there exists a perfect matching. Hungarian method for assignment is used to solve the problem along with DFS to match an ad to a slot.

In the second approach, many ads could be packed to a slot. A heuristic algorithm is used to pack ads to tighest spot available.
