import heapq

def solution(scoville, K):
    answer = 0
    pq = []
    
    for x in scoville:
        heapq.heappush(pq, x)
    
    while pq[0]<K:
        if len(pq) < 2:
            return -1
            
        a = heapq.heappop(pq)
        b = heapq.heappop(pq)
        sco = a+b*2
        heapq.heappush(pq, sco)
        answer += 1

    return answer