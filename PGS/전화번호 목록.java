import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        //정렬하고 내 뒤 하나만 확인 
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i].length() > phone_book[i+1].length()) continue;
            int len = phone_book[i].length();
            String tmp = phone_book[i+1].substring(0, len);
            if(phone_book[i].equals(tmp)) return false;
        }
        
        return answer;
    }
}