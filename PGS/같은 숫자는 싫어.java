import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i]!=arr[i-1]){
                dq.addLast(arr[i]);
            }
        }
        
        int[] answer = new int[dq.size()];
        int idx =0;
        for(int x:dq){
            answer[idx++] = x;
        }

        return answer;
    }
}