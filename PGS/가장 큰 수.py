def solution(numbers):
    answer = ''
    num = []
    
    for x in numbers:
        num.append(str(x))
    
    num.sort(key=lambda x:x*3, reverse=True)
    
    for x in num:
        answer += x
    
    if num[0]=='0':
        answer = '0'
    
    return answer