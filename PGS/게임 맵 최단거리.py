from collections import deque
def solution(maps):
    answer = 0
    
    n = len(maps)
    m = len(maps[0])
    dist = [[0]*m for _ in range(n)]
    
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0 ]
    
    q=deque()
    q.append((0,0))
    dist[0][0] = 1
    while q:
        a, b =q.popleft()
        
        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]
            if nx<0 or nx >=n or ny<0 or ny >=m : continue
            if maps[nx][ny] == 0: continue
            if dist[nx][ny] != 0: continue
            dist[nx][ny] = dist[a][b] + 1
            q.append((nx, ny))
        
    if dist[n-1][m-1]==0: 
        answer = -1
    else:
        answer = dist[n-1][m-1]
    
    return answer