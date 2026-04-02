answer = 0

def dfs(numbers, target, sum, index):
    global answer
    if index == len(numbers):
        if sum == target:
            answer += 1
        return;
    dfs(numbers, target, sum+numbers[index], index+1)
    dfs(numbers, target, sum-numbers[index], index+1)

def solution(numbers, target):
    dfs(numbers, target, 0, 0)
    
    return answer