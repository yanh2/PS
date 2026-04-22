//직접 푼 코드
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int n = brown/2 - 2;
        
        int w=0, h=0;
        int limit = (int)Math.sqrt(yellow);
        for(int i=1; i<=limit; i++){
            int a = i;
            if(yellow%i==0){
                int b = yellow/i;
                if(a+b==n){
                    w = b;
                    h = a;
                    break;
                }
            }
        }
        answer[0] = w+2;
        answer[1] = h+2;
        return answer;
    }
}

//리팩토링
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown+yellow;

        int limit = (int)Math.sqrt(total);
        for(int h=3; h<=limit; h++){ //가로, 세로는 최소 3이어야 함
            if(total%h==0){
                int w = total/h;
                
                if((w-2)*(h-2)==yellow){
                    answer[0] = w;
                    answer[1] = h; 
                    break;
                }
            }
        }
       
        return answer;
    }
}