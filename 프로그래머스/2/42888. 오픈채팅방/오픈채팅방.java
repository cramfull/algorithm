import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int cnt = 0;
        for(int i=0;i<record.length;i++){
            StringTokenizer str = new StringTokenizer(record[i]);
            String cmd = str.nextToken();
            
            if(cmd.equals("Enter")){
                cnt++;
                String u_id = str.nextToken();
                String name = str.nextToken();
                if(map.containsKey(u_id)){
                    map.replace(u_id, name);
                }else{
                    map.put(u_id, name);
                }
            }else if(cmd.equals("Change")){
                String u_id = str.nextToken();
                String name = str.nextToken();
                map.replace(u_id, name);
            }else{
                cnt++;
                String u_id = str.nextToken();
            }
            
        }
        int idx = 0;
        String[] answer = new String[cnt];

        for(int i=0;i<record.length;i++){
            StringTokenizer str = new StringTokenizer(record[i]);
            String tmp = str.nextToken();
            if(tmp.equals("Change")){
                continue;
            }else if(tmp.equals("Enter")){
                answer[idx] = map.get(str.nextToken())+"님이 들어왔습니다.";
                idx++;
            }else{
                answer[idx] = map.get(str.nextToken())+"님이 나갔습니다.";
                idx++;
            }
        }
        
        
        return answer;
    }
}