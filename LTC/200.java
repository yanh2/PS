class Solution {
    boolean[][] visit;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int n, m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visit = new boolean[n][m];
        int cnt =0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visit[i][j] && grid[i][j]=='1'){
                    dfs(i,j, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(int x, int y, char[][] grid){
        visit[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
            if(!visit[nx][ny] && grid[nx][ny]=='1'){
                dfs(nx,ny, grid);
            }
        }
    }
}