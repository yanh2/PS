class Solution {
    boolean[] visit;
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        //words 안에 target 없으면 0 return
        boolean exist = false;
        for(String w : words){
            if(target.equals(w)){
                exist = true;
                break;
            }
        }
        if(exist==false) return 0;
        
        visit = new boolean[words.length];
        dfs(begin, target, words, 0);
        //target 이 words 안에 있더라도 갈 수 없는 경우 처리
        return answer == Integer.MAX_VALUE? 0 : answer;
    }
    public void dfs(String cur, String target, String[] words, int depth){
        //depth 넘었거나 target이랑 같은지 비교
        if(cur.equals(target)){
            answer = Math.min(answer, depth);
            return;
        }
        
        for(int i=0; i< words.length; i++){
            String next = words[i];
            if(diff(cur, next) && !visit[i]){
                visit[i] = true;
                dfs(next, target, words, depth+1);
                visit[i] = false;
            }
        }
        
    }
    public boolean diff(String cur, String word){
        int cnt =0;
        for(int i=0; i<cur.length(); i++){
            if(cur.charAt(i)!=word.charAt(i)){
                cnt++;
            }
        }
        if(cnt==1) return true;
        else return false;
    }
}