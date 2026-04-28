def solution(people, limit):
    answer = 0
    
    i = 0
    j = len(people)-1
    
    people.sort()
    
    while i<=j:
        # 가장 가벼운 사람을 무거운 사람과 함께 태울 수 있는지
        if people[i] + people[j] <= limit: 
            i += 1
        # 무거운 사람은 항상 태움 
        j -= 1
        answer+=1
        
    return answer