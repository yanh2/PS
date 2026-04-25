import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {        
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new TreeMap<>();
        
        for(int i=0; i<records.length; i++){
            String[] r = records[i].split(" "); //시간, 번호, in/out
            String[] t = r[0].split("\\:"); //시간 시,분
            int time = Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
            String carNum = r[1];
            
            if(r[2].equals("IN")){ 
                inMap.put(carNum, inMap.getOrDefault(carNum, 0)+time);
            }else{ 
                int parkingTime = time-inMap.get(carNum); //주차한 시간
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0)+parkingTime); //누적시간
                inMap.remove(carNum);
            }
        }
        
        //out안한 것 처리
        for(String c : inMap.keySet()){
            int midNight = 23*60 + 59;
            int extra = midNight - inMap.get(c);
            totalTimeMap.put(c, totalTimeMap.getOrDefault(c,0) + extra);
        }
        
        int[] answer = new int[totalTimeMap.size()];
        int idx =0;
        for(int totalTime : totalTimeMap.values()){
            int price = fees[1]; //기본요금
            if(totalTime>fees[0]){ //기본 시간 넘으면
                int extra = (totalTime-fees[0])/fees[2];
                if((totalTime-fees[0])%fees[2]!=0){
                    extra+=1; //올림
                }
                extra = extra*fees[3];
                price += extra;
            }
             answer[idx++] = price;
        }
        
        return answer;
    }
}