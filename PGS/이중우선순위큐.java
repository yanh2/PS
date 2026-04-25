// 1. remove 사용
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minq = new PriorityQueue<>(); //디폴트
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String o : operations){
            String[] operation = o.split(" ");
            if(operation[0].equals("I")){
                int t = Integer.parseInt(operation[1]);
                minq.offer(t);
                maxq.offer(t);
            }else if(operation[0].equals("D")){
                if(minq.isEmpty() || maxq.isEmpty()) continue;
                if(operation[1].equals("1")){ //최댓값 삭제
                    int tmp = maxq.poll(); //맨앞 삭제 
                    minq.remove(tmp);
                }else{ //최솟값 삭제
                    int tmp = minq.poll();
                    maxq.remove(tmp);                    
                }
            }
        }
        if(minq.isEmpty() && maxq.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = maxq.poll();
            answer[1] = minq.poll();
        }
        
        return answer;
    }
}

// 2. 데이터 많아질 때 대비
import java.util.*;

class Solution {
    Map<Integer, Integer> count = new HashMap<>();
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minq = new PriorityQueue<>(); //디폴트
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String o : operations){
            String[] operation = o.split(" ");
            if(operation[0].equals("I")){
                int t = Integer.parseInt(operation[1]);
                minq.offer(t);
                maxq.offer(t);
                count.put(t, count.getOrDefault(t, 0)+1);
            }else if(operation[0].equals("D")){
                if(operation[1].equals("1")){ //최댓값 삭제
                    clearQ(maxq);
                    if(maxq.isEmpty()) continue;
                    int tmp = maxq.poll(); //맨앞 삭제
                    count.put(tmp, count.get(tmp)-1);
                }else if(operation[1].equals("-1") && !minq.isEmpty()){ //최솟값 삭제
                    clearQ(minq);
                    if(minq.isEmpty()) continue;
                    int tmp = minq.poll();
                    count.put(tmp, count.get(tmp)-1);                    
                }
            }
        }
        clearQ(maxq);
        clearQ(minq);
        if(minq.isEmpty() && maxq.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = maxq.poll();
            answer[1] = minq.poll();
        }
        return answer;
    }
    public void clearQ(PriorityQueue<Integer> q){
        while(!q.isEmpty() && count.getOrDefault(q.peek(), 0)==0){
            q.poll();
        }
    }
}