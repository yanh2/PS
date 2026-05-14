import java.util.*;
class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int[][] dist;
    int n, m;
    
    public int solution(String[] maps) {
        int answer = 0; 
        
        n = maps.length;
        m = maps[0].length();
        dist = new int[n][m];
        
        char[][] map = new char[n][m];
        
        int ss=0, se=0;
        int ls=0, le=0;
        int es=0, ee=0;

        for(int i=0; i<n; i++){
            map[i] = maps[i].toCharArray();
            for(int j=0; j<m; j++){
                if(map[i][j]=='S'){
                    ss =i;
                    se =j;
                }
                else if(map[i][j]=='L'){
                    ls = i;
                    le = j;
                }
                else if(map[i][j]=='E'){
                    es = i;
                    ee = j;
                }
            }
        }
        
        bfs(ss, se, map);
        
        if(dist[ls][le]==-1) return -1;
        answer += dist[ls][le];
        
        bfs(ls, le, map);

        if(dist[es][ee]==-1) return -1;
        answer += dist[es][ee];
        
        return answer;
    }
    public void bfs(int x, int y, char[][] map){
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], -1);
        }
        
        q.offer(new int[]{x, y});
        dist[x][y] = 0;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            int a = current[0];
            int b = current[1];
            for(int i=0; i<4; i++){
                int nx = a+dx[i];
                int ny = b+dy[i];
                if(nx<0 || nx>=n||ny<0||ny>=m) continue;
                if(dist[nx][ny]!=-1) continue;
                if(map[nx][ny]!='X'){
                    q.offer(new int[]{nx,ny});
                    dist[nx][ny] = dist[a][b]+1;
                }
            }
        }
    }
}