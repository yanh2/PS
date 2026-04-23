import java.util.*;

class Solution {
    boolean[] visit;
    ArrayList<String> path;
    String[] answer;
    boolean found = false;
    public String[] solution(String[][] tickets) {
        //방문여부 공항 아니라, 티켓!
        visit = new boolean[tickets.length];
        path = new ArrayList<>();
        
        //경로 2개 이상이면 알파벳 순서 -> 정렬
        Arrays.sort(tickets, (a, b)->{
           if(a[0].equals(b[0])){ //출발지 같으면 도착지 비교
               return a[1].compareTo(b[1]);
           }
            return a[0].compareTo(b[0]);
        });
        
        path.add("ICN");
        dfs("ICN", tickets, 0);
        
        return answer;
    }
    public void dfs(String now,String[][] tickets, int depth){
        //종료조건 : 티켓 모두 사용했을 때
        if(depth==tickets.length){
            answer = path.toArray(new String[0]);
            found = true; 
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(now.equals(tickets[i][0]) && !visit[i]){
                visit[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, depth+1);
                
                if(found) return; //가장 빠른 정답 찾았으면 종료
                
                visit[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}