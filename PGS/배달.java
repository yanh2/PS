import java.util.*;

class Solution {
    class Node{
        int to, cost;
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[0]-b[0]); //<거리, 정점> 
        
        int[] dist = new int[N+1]; //최단거리 테이블 (1~n)
        Arrays.fill(dist, Integer.MAX_VALUE);

        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a,c));
        }
        
        dist[1] = 0;

        pq.offer(new int[]{dist[1], 1});
        while(!pq.isEmpty()){
            int[] cur = pq.poll(); //거리 제일 짧은거 고름
            int d = cur[0]; //거리
            int v = cur[1]; //정점
            if(d > dist[v]) continue;
            for(Node nxt :graph[v]){
                if(dist[nxt.to] <= dist[v]+nxt.cost) continue;
                dist[nxt.to] = dist[v]+nxt.cost;
                pq.offer(new int[] {dist[nxt.to], nxt.to});
            }
        }
        for(int i=1; i<=N; i++){
            if(dist[i]<=K) answer++;
        } 

        return answer;
    }
}