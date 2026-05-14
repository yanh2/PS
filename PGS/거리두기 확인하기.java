import java.util.*;
class Solution {
    int[] dx = {0,0,1, -1};
    int[] dy = {1,-1,0,0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int k=0; k<5; k++){
            char[][] place = new char[5][5];
            for(int j=0; j<5; j++){
                place[j] = places[k][j].toCharArray();
            }
            
            answer[k] = checkPlace(place) ? 1 : 0;
            
        }
       
        return answer;
    }
    public boolean checkPlace(char[][] place){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(place[i][j]=='P'){
                    if(!bfs(i, j, place)) return false;
                }
            }
        }
        return true;
    }
    
    
    public boolean bfs(int x, int y, char[][] place ){
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        
        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int a = current[0];
            int b = current[1];
            int dist = current[2];
            
            if(dist >= 2) continue; //거리 2이상 탐색 안함
            
            for(int i=0; i<4; i++){
                int nx = a+dx[i];
                int ny = b+dy[i];
                if(nx<0|| nx>=5|| ny<0 || ny>=5 ) continue;
                if(visited[nx][ny]) continue;
                if(place[nx][ny]=='X') continue;
                
                if(place[nx][ny]=='P'){ //거리 2 이내에 다른 사람 발견
                    return false;
                }
                visited[nx][ny] = true;
                q.offer(new int[]{nx,ny, dist+1});
                
            }
        }
        
        return true;
    }
}