import heapq
import sys

n, m, x = map(int, input().split())
INF = sys.maxsize

graph = [[] for _ in range(n+1)] 

def dijkstra(st):
    pq = []
    dist = [INF]*(n+1)

    dist[st] = 0
    # 거리, 정점
    heapq.heappush(pq, (0, st))
    while pq:
        d, v = heapq.heappop(pq)
        if dist[v] < d:
           continue
        for next, cost in graph[v]: 
            if dist[next] < dist[v]+cost:
                continue
            dist[next] = dist[v]+cost
            heapq.heappush(pq, (dist[next], next))

    return dist

for i in range(m):
    s, e, t = map(int, input().split())
    graph[s].append((e, t))

one_way = [0] * (n+1)
# 1~N에서 시작하는 최단경로
for i in range(1, n+1):
    tmp = dijkstra(i)
    one_way[i] = tmp[x] #st에서 시작, x까지의 최단경로

# x에서 시작하는 최단경로
return_dist = dijkstra(x)

round_sum =[0] * (n+1)
for i in range(1, n+1):
    round_sum[i] = one_way[i]+return_dist[i];

print(max(round_sum))