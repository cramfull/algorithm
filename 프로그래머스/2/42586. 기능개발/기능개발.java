import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        
        // progress, speed, totalRelease
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(progresses[0], speeds[0]));
        for(int i=1;i<progresses.length; i++){
            Pair pair = new Pair(progresses[i], speeds[i]);
            if(stack.peek().day >= pair.day){
                stack.peek().increseTotalRelease();
            }else{
                stack.push(pair);
            }
        }
        answer = stack.stream().mapToInt(Pair::getTotalRelease).toArray();
        
        
        return answer;
    }
    
    static class Pair{
        int day, totalRelease;
        
        public Pair(int progress, int speed){
            this.day = getDay(progress, speed);
            this.totalRelease = 1;
        }
        
        public int getDay(int progress, int speed){
            int tmp = (int)((100-progress)/speed);
            if((100-progress)%speed!=0){
                tmp+=1;
            }
            return tmp;
        }
        
        public int getTotalRelease(){
            return this.totalRelease;
        }
        
        public void increseTotalRelease(){
            this.totalRelease++;
        }
    }
}