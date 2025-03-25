import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // Pair
        // index, priority
        
        // priority max 찾기
        // peek().priority == max  
            // deq.pullFirst()
        // peek().priority != max
            // x = deq.pullFirst()
            // deq.addLast(x);
    
        int answer = solving(priorities, location);
        
        return answer;
    }
    
    static int solving(int[] priorities, int location){
        Deque<Pair> deq = new LinkedList<>();
        
        for(int i=0;i<priorities.length; i++){
            Pair pair = new Pair(i, priorities[i]);
            deq.addLast(pair);
        }
        int cnt = 0;
        while(!deq.isEmpty()){
            int max = findMaxPriority(deq);
            Pair peekedPair = deq.pollFirst();
            if(peekedPair.priority != max){
                deq.addLast(peekedPair);
            }else{
                cnt++;
                if(peekedPair.index == location){
                    return cnt;
                }
            }
            
        }
        return -1;
    }
    
    static int findMaxPriority(Deque<Pair> deq){
        int maxValue = 0;
        Iterator<Pair> it = deq.iterator();
        while(it.hasNext()){
            Pair pair = it.next();
            maxValue = Math.max(maxValue, pair.priority);
        }
        return maxValue;
    }
        
        
    static class Pair{
        int index;
        int priority;
        
        public Pair(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
        
        @Override
        public String toString(){
            return this.index+" "+this.priority;
        }
    }
}