import java.util.*;

class Solution {
    boolean[] visit; 
    int cnt1;
    ArrayList<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++){
            int u= wires[i][0];
            int v = wires[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i=0; i<wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            visit = new boolean[n+1];
            cnt1 = 0;
            
            dfs(1, v1, v2);
            
            int cnt2 = n-cnt1;
            int diff = Math.abs(cnt1-cnt2);
            answer = Math.min(diff, answer);
            
        }
        
        return answer;
    }
    public void dfs(int x, int v1, int v2){
        visit[x] = true; 
        cnt1++;

        for(int next : graph[x]){
            //끊는 간선 무시
            if((x==v1 && next==v2)||(x==v2 && next==v1)) continue;
            if(visit[next]==true) continue;
            dfs(next, v1, v2);
        }  
    }
}