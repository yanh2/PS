import sys
sys.setrecursionlimit(10**6)

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def dfs(x, y, board, visit):
    visit[x][y] = True
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if nx<0 or nx >=len(board) or ny<0 or ny >=len(board[0]): continue
        if not visit[nx][ny] and board[nx][ny]==1:
            dfs(nx, ny, board, visit)

t = int(input())
while t:
    m, n, k = map(int,input().split())
    cnt = 0
    board = [[0]*m for _ in range(n)]
    visit = [[False]*m for _ in range(n)]
    for _ in range(k):
        y, x =map(int, input().split())
        board[x][y]=1

    for i in range(n):
        for j in range(m):
            if not visit[i][j] and board[i][j]==1:
                cnt += 1
                dfs(i, j, board, visit)
    
    print(cnt)

    t-=1