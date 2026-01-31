def solution(participant, completion):
    answer = ''
    p = {}
    c = {}
    
    for x in participant:
        p[x] = p.get(x,0) + 1
    for x in completion:
        c[x] = c.get(x,0) + 1
    for x in p:
        if p[x] != c.get(x,0):
            answer = x
    
    return answer