import java.util.*;

class Solution {
    
    static HashMap<String, Integer> map = new HashMap<>();

    public int solution(String[][] clothes) {
        // 부분 집합
        
        for(int i=0;i<clothes.length;i++){
                map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
        }
        int answer = solving()-1;
        
        
        return answer;
    }
    
    public int solving(){
        int result = 1;
        for(int cloth : map.values()){
            result *= (cloth+1);
        }
        return result;
    }

}