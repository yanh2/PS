import sys
import heapq

input = sys.stdin.readline
INF = sys.maxsize
V, E = map(int, input().split())
K = int(input())
graph = [[] for _ in range(V+1)]
d = [INF]*(V+1) #최단 거리 테이블
pq = []

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((w, v))

# 다익스트라
d[K] = 0
heapq.heappush(pq,(0, K))
while pq:
    cur_dist, cur_idx = heapq.heappop(pq) #비용(가중치), 정점
    # 우선순위큐 가장 작은 거리 d와 맞는지 확인(맞을때만 과정 이어감)
    if d[cur_idx] != cur_dist: 
        continue
    for w,nxt in graph[cur_idx]:
        # 기본이 더 작으면 넘어감
        if d[nxt] <= d[cur_idx]+w:
            continue
        # cur 거쳐가는 것이 더 작은 값을 가질 경우
        # d[nxt] 을 갱신하고 우선순위 큐에 (거리, nxt) 를 추가
        d[nxt] = d[cur_idx] + w;
        heapq.heappush(pq, (d[nxt], nxt))

for i in range(1, V+1):
    if d[i]==INF:
        print("INF")
    else:
        print(d[i])