def solution(array, commands):
    answer = []
    
    for i in range(len(commands)):
        arr = []
        s = commands[i][0]
        e = commands[i][1]
        k = commands[i][2]
        for j in range(s-1,e):
            arr.append(array[j])
        arr.sort()
        answer.append(arr[k-1])
        
    return answer