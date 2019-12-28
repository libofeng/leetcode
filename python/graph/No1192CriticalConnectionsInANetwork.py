from collections import defaultdict

class Solution(object):
    def criticalConnections(self, n, connections):
        """
        :type n: int
        :type connections: List[List[int]]
        :rtype: List[List[int]]
        """
        graph = defaultdict(list)
        for v in connections:
            a, b = v[0], v[1]
            graph[a].append(b)
            graph[b].append(a)

        time, low = [-1 for i in range(n)], [-1 for i in range(n)]
        t, ans = 0, []

        def dfs(parent, cur, t):
            t += 1
            time[cur] = low[cur] = t
            for w in graph[cur]:
                if time[w] == -1:
                    dfs(cur, w, t)
                    low[cur] = min(low[cur], low[w])
                    if low[w] == time[w]:
                        ans.append((cur, w))
                elif w != parent:
                    low[cur] = min(low[cur], time[w])

        dfs(0, 0, 0)

        return ans
