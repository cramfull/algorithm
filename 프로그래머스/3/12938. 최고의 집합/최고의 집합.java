import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, int s) throws IOException{
        
        // 합과 곱
        // n개의 수의 합이 s인 경우 찾기
        // 찾은 수의 곱들 정렬
        // 가장 큰 경우, 배열에 삽입하여 리턴
        int [] answer;
        int tmp = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        if(s/n==0){
            answer = new int[]{-1};
        }else{
            answer = new int[n];
            for(int i=n;i>0;i--){
                tmp = s/i;
                s-=tmp;
                answer[n-i]=tmp;
            }
            answer[n-1]=tmp;

            Arrays.sort(answer);
        }
       

        
        return answer;
    }
}