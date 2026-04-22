import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> total_cnt = new HashMap<>(); //장르별 총 개수
        HashMap<String, HashMap<Integer,Integer>> music = new HashMap<>(); //장르 - 노래번호, 플레이 수
        
        for(int i=0; i<plays.length; i++){
            if(!total_cnt.containsKey(genres[i])){ //해당 장르 없으면 새로 추가
                total_cnt.put(genres[i], plays[i]);
                music.put(genres[i], new HashMap<>());
            }else{ //장르 이미 있으면 총 합 추가
                total_cnt.put(genres[i], total_cnt.get(genres[i])+plays[i]);
            }
            music.get(genres[i]).put(i, plays[i]); //공통 작업 
        }
        
        //총 합 높은거 찾기 
        List<String> keySet = new ArrayList<>(total_cnt.keySet());
        Collections.sort(keySet, (s1, s2)-> total_cnt.get(s2) - total_cnt.get(s1));
        
        // 총 합 높은 장르부터 2개 뽑기
        for(String key : keySet){
            //현재 장르에 속한 곡들의 정보(ID, 재생수)가 담긴 안쪽 Map을 통째로 가져옴
            HashMap<Integer, Integer> map = music.get(key);
            //해당 장르의 ID 값만 저장하는 List 만듦 (map은 정렬이 안됨. list 필요)
            List<Integer> music_id = new ArrayList(map.keySet());
            //재생 수를 기준으로 내림차순 정렬 -> id 순서 바뀜
            Collections.sort(music_id, (s1,s2)-> map.get(s2)-map.get(s1));
            
            answer.add(music_id.get(0));
            if(music_id.size() > 1){
                answer.add(music_id.get(1));
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}