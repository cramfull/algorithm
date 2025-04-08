import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 0, 1, 3, 5, 6
        // 0, 7, 8, 9, 11
        // 
        
        // idx = 기준 수
            // length-1 부터 0까지
                // length - idx <= arr[idx]
        answer = solving(citations);

        return answer;
    }
    

    public int solving(int[] citations){
        int [] array = Arrays.copyOf(citations, citations.length);
        Arrays.sort(array);
        int hIndex = 0;
        for(int i=array.length-1; i>=0; i--){
            if(array.length-i <= array[i]){
                hIndex = Math.max(hIndex, array.length-i);
            }
        }
        return hIndex;
    }
}