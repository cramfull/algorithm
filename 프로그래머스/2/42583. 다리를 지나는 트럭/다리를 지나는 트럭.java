import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {        
        Queue<Truck> que = new LinkedList<>();
        
        int index = 0; 
        int totalWeight = 0;
        int cnt = 0;
        
        while(true){
            if(index == truck_weights.length && que.isEmpty()){
                break;
            }
            
            cnt++;
            // 다리에서 내리는 경우
            if(!que.isEmpty()){
                if(que.peek().len == 0){
                int outWeight = que.poll().weight;
                totalWeight -= outWeight;
                }    
            }
            
            // 다리에 오르는 경우
            if(index<truck_weights.length){
                if(totalWeight+truck_weights[index] <= weight){
                    int truckWeight = truck_weights[index++];
                    que.offer(new Truck(bridge_length, truckWeight));
                    totalWeight+=truckWeight;
                }
            }
            
            
            // 시간 증가
            Iterator<Truck> it = que.iterator();
            while(it.hasNext()){
                it.next().len-=1;
            }
        }
        
        
        return cnt;
    }
    
    static class Truck{
        int len;
        int weight;
        
        public Truck(int len, int weight){
            this.len = len;
            this.weight = weight;
        }
    }
}