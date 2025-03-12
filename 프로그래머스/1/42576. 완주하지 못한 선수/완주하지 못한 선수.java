import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
                
        String answer = solving(participant, completion);
        return answer;
    }
    
    
    public String solving(String[] participant, String[] completion){
        // 동명이인 존재가 가능하다. -> 모두 다른 사람으로 본다.
        // 참가자 수 = 완주자 수 +1
        // 둘 다 hashmap에 명수랑 추가
        // 검사 시 0인경우 return
        HashMap<String, Integer> participantsMap = new HashMap<>();
        for(int i=0;i<participant.length;i++){
            String name = participant[i];
            participantsMap.put(name, participantsMap.getOrDefault(name,0)+1);
        }
        for(String name : completion){
            participantsMap.put(name, participantsMap.get(name)-1);
        }
        for(String name : participant){
            if(participantsMap.get(name)!=0){
                return name;
            }
        }
        return null;
    }
}