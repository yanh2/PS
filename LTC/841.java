import java.util.*;

class Solution {
    static boolean[] visit;
    static ArrayList<Integer>[] room;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visit = new boolean[n];
       
	    //BFS
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        visit[0] = true;
        while(!q.isEmpty()){
            int a = q.poll();
            for(int i=0; i<rooms.get(a).size(); i++){
                int next = rooms.get(a).get(i);
                if(!visit[next]){
                    q.add(next);
                    visit[next] = true;
                }
            }
        }
				
		//DFS
        //dfs(0, rooms);
        for(int i=0; i<n; i++){
            if(visit[i]==false) return false;
        }
        return true;
    }
    public void dfs(int st, List<List<Integer>> rooms){
        visit[st] = true;

        for(int i=0; i<rooms.get(st).size(); i++){
            int next = rooms.get(st).get(i);
            System.out.println(next);
            if(!visit[next]) dfs(next, rooms);
        }
    }
}