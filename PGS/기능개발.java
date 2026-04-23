import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] day = new int[progresses.length];
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            
            if((100-progresses[i])%speeds[i]==0){
                day[i] = (100-progresses[i])/speeds[i];
            }else{
                day[i] = (100-progresses[i])/speeds[i]+1;
            }
        }
        
        int first=0;
        for(int i=0; i<day.length; i++){
            if(dq.isEmpty()){
                dq.addLast(day[i]);
            }else{ //있으면 
                if(dq.peekFirst() < day[i]){
                    answer.add(dq.size());
                    dq.clear();
                }
                dq.addLast(day[i]);
            }
        }
        if(!dq.isEmpty()){
            answer.add(dq.size());
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}