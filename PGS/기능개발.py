def solution(progresses, speeds):
    answer = []
    day = []
    
    for i in range(len(progresses)):
        t = 100-progresses[i]
        if t%speeds[i]==0:
            day.append(t//speeds[i])
        else:
            day.append(t//speeds[i] + 1)
            
    
    d = day[0]
    cnt = 1
    for i in range(1, len(day)):
        if d >= day[i]:
            cnt += 1
        else:
            answer.append(cnt)
            cnt = 1
            d = day[i]
    answer.append(cnt)
    
    return answer