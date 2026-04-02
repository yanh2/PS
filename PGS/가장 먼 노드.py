from collections import deque

def solution(n, edge):
    answer = 0
    graph = [[] for _ in range(n+1)]
    visited = [0]*(n+1)
    
    for i in range(len(edge)):
        a = edge[i][0]
        b = edge[i][1]
        graph[a].append(b)
        graph[b].append(a)
        
    for g in graph:
        g.sort()
        
    q = deque()
    q.append(1)
    visited[1]=1
    
    while q:
        a = q.popleft()
        for i in graph[a]:
            if visited[i] != 0: continue
            q.append(i)
            visited[i] = visited[a]+1
    
    mx = max(visited)
    answer = visited.count(mx)

    return answer