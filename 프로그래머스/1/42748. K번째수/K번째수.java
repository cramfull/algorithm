import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        ArrayList<Integer> results = new ArrayList<>();
        
        for(int i=0;i<commands.length;i++){
            results.add(getResult(array, commands[i][0]-1, commands[i][1], commands[i][2]-1));
            //System.out.println(Arrays.toString(Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1])));
        }
        answer = results.stream().mapToInt(a->a).toArray();
        return answer;
    }
    
    public int getResult(int[] array, int i, int j, int k){
        int [] copyArray = Arrays.copyOfRange(array, i, j);
        Arrays.sort(copyArray);
        return copyArray[k];
    }
}