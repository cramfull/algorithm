import java.util.*;
import java.util.stream.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(stack.peek() == arr[i]){
                stack.pop();
            }
            stack.push(arr[i]);
        }

        answer = stack.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}