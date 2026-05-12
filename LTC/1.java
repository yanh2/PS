import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {        
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); //<idx, nums>
        ArrayList<Integer> arr = new ArrayList<>(); //map의 key값으로 활용할 index를 저장하는 리스트


        for(int i=0; i<nums.length; i++){
            map.put(i, nums[i]);
            arr.add(i);
        }

        arr.sort((a, b)-> map.get(a) - map.get(b)); //오름차순
        //정렬은 nums 기준으로 하고, index 의 위치를 바꿔줌
        //ex. [3,2,4] -> idx arr [0,1,2]
        //정렬 후 : [1, 0, 2] -> 2,3,4 의 정렬이 되는 것
        
        int l=0;
        int r = arr.size()-1;

        while(l<=r){
            int sum = map.get(arr.get(l))+map.get(arr.get(r));
            if(sum == target){
                answer.add(arr.get(l));
                answer.add(arr.get(r));
                break;
            }
            else if(sum > target){
                r--;
            }
            else{
                l++;
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}