import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = solving(answers);
        
        return answer;
    }
    
    public int [] solving(int [] answers){
        int [] supo1 = {1,2,3,4,5};
        int [] supo2 = {2,1,2,3,2,4,2,5};
        int [] supo3 = {3,3,1,1,2,2,4,4,5,5};
        
        int result1 = 0;
        int result2 = 0;
        int result3 = 0;
        
        for(int i=0;i<answers.length; i++){
            if(supo1[i%supo1.length]==answers[i]){
                result1++;
            }
            if(supo2[i%supo2.length]==answers[i]){
                result2++;
            }
            if(supo3[i%supo3.length]==answers[i]){
                result3++;
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int maxResult = Math.max(result1, Math.max(result2, result3));    
                
        if(maxResult == result1){
            arr.add(1);
        }
        if(maxResult == result2){
            arr.add(2);
        }
        if(maxResult == result3){
            arr.add(3);
        }
        
        
        return arr.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}