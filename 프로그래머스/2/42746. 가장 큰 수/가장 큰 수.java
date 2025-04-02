import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        // 정렬 조건
        // string으로 변환
        // 이어붙인 수, a+b, b+a 중 큰 수로 정렬
        
        String [] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        
        
        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        for(int i=0;i<arr.length; i++){
            answer+=arr[i];
        }
        
        return (arr[0].equals("0")) ? "0" : answer;
    }
}
