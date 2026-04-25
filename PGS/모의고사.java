import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] type1 = {1,2,3,4,5};
        int[] type2 = {2,1,2,3,2,4,2,5};
        int[] type3 = {3,3,1,1,2,2,4,4,5,5};
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == type1[i%5]){
                map.put(1, map.getOrDefault(1, 0)+1);
            }
            if(answers[i] == type2[i%8]){
                map.put(2, map.getOrDefault(2, 0)+1);
            }
            if(answers[i] == type3[i%10]){
                map.put(3, map.getOrDefault(3, 0)+1);
            }
        }
        int maxVal = Collections.max(map.values());
        List<Integer> answerList = new ArrayList<>();
        
        for(int k : map.keySet()){
            if(map.get(k) == maxVal){
                answerList.add(k);
            }
        }
        Collections.sort(answerList);
        
        return answerList.stream().mapToInt(i->i).toArray();
    }
}