import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int n = citations.length;
       
        for(int i=0; i< n; i++){
            int h = n-i; //현재 인용 횟수(citations[i]) 이상인 논문의 개수
            
            if(citations[i]>=h){
                answer = h;
                break;
            }
        }
        return answer;
    }
}