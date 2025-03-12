import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // nums.length/2 마리의 포켓몬을 고름
        // 최대한 중복이 발생하지 않게 고르는 경우의 해
        
        // HashMap에 (num, 개수)로 저장
        // HashMap.size() >= nums.length/2
            // nums.length/2
        // HashMap.size() < nums.length/2
            // HashMap.size()
        
        
        int answer = solve(nums);
        return answer;
    }
    
    public static int solve(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int size = set.size();
        int length = nums.length/2;
        if(size >= length){
            return length;
        }else{
            return size;
        }
    }
}