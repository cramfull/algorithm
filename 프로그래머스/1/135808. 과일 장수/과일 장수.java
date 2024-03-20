import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        // k는 최대 점수
        // m은 상자의 사과 개수
        // 상자 개수
        // 3322, 111
        // 444, 444, 222, 112
        Integer [] score1 = new Integer[score.length];
        for(int i=0;i<score.length;i++){
            score1[i]=score[i];
        }
        Arrays.sort(score1, Collections.reverseOrder());
        
        for(int i=0; i<score1.length/m;i++){
            answer+=score1[(i+1)*m-1]*m;
        }
        
        
        return answer;
    }
}