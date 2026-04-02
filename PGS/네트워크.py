from collections import defaultdict

def solution(n, computers):
    def dfs(x):
        visited[x] = True
        for i in range(n):
            if not visited[i] and computers[x][i]: 
                dfs(i)
    answer = 0 
    visited = [False] * n
    
    for i in range(n):
        if not visited[i]:
            answer += 1
            dfs(i)
    
    return answer