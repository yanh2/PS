import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answerList = new ArrayList<>();
        HashMap<String, Integer> termMap = new HashMap<>();
        
        int todayFullDays = getFullDays(today);
        
        for(String term: terms){
            String[] t = term.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1])*28);
        }
        
        for(int i=0; i<privacies.length; i++){
            String[] p = privacies[i].split(" "); 
            int startDays = getFullDays(p[0]);
            int duration = termMap.get(p[1]);
            
            if(startDays+duration <= todayFullDays){
                answerList.add(i+1);
            }           
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    public int getFullDays(String date){
        String[] d = date.split("\\."); 
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        return (year*12*28)+(month*28)+day;
    }
}