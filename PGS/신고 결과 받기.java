import java.util.*;

class Solution {
    
    public int[] solution(String[] id_list, String[] report, int k) {
        ArrayList<Integer> answer = new ArrayList<>(); 
        HashMap<String, Integer> rep = new HashMap<>(); //신고당한 횟수
        HashMap<String, Integer> dup = new HashMap<>(); //중복 제거용 "a b", 1
        
        for(int i=0; i<report.length; i++){
            String[] tmp = report[i].split(" ");
            dup.put(report[i], dup.getOrDefault(report[i], 0)+1);
            if(dup.get(report[i])>1) continue;
            rep.put(tmp[1], rep.getOrDefault(tmp[1], 0)+1);
            
        }

        HashMap<String, Integer> id = new HashMap<>(); //유저별 신고 결과 알람 횟수 (내가 신고한 사람이 k 번 이상인 경우 카운트)
        
        dup.clear();
        for(int i=0; i<report.length; i++){
            dup.put(report[i], dup.getOrDefault(report[i], 0)+1);
            if(dup.get(report[i])>1) continue;
            
            String[] tmp = report[i].split(" ");
            if(rep.get(tmp[1])>=k){
                id.put(tmp[0], id.getOrDefault(tmp[0], 0)+1);
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            answer.add(id.getOrDefault(id_list[i], 0));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}