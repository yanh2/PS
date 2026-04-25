import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> category = new HashMap<>();
        
        for(int i=0; i<survey.length; i++){
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            int score = Math.abs(choices[i]-4);
            
            if(choices[i] <4){ //왼쪽
                category.put(a, category.getOrDefault(a, 0)+score);
            }else{ //오른쪽
                category.put(b, category.getOrDefault(b, 0)+score);
            }
        }
        
        //점수 같으면 사전 순
        StringBuilder answer = new StringBuilder();
        String[] kind = {"RT", "CF", "JM", "AN"}; //이미 사전순
        for(String k : kind){
            char first = k.charAt(0);
            char second = k.charAt(1);
            
            int score1 = category.getOrDefault(first, 0);
            int score2 = category.getOrDefault(second, 0);
            
            if(score1 >= score2){
                answer.append(first);
            }else{
                answer.append(second);
            }
        }
        
        return answer.toString();
    }
}