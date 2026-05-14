class Solution {
    int[] dx = {-1, -1, -1, 0, 0,1, 1, 1};
    int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};
    int[][] dist;
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        dist = new int[n][n];

        Queue<int[]> q = new LinkedList<>();

        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int a = current[0];
            int b = current[1];

            for(int i=0; i<8; i++){
                int nx = a+dx[i];
                int ny = b+dy[i];
                if(nx<0 || nx>=n || ny<0 || ny >=n) continue;
                if(dist[nx][ny]==0 && grid[nx][ny]==0){
                    q.offer(new int[]{nx, ny});
                    dist[nx][ny] = dist[a][b] +1;
                }
            }
        }
        if(dist[n-1][n-1]==0) return -1;
        return dist[n-1][n-1]; 
    }
}