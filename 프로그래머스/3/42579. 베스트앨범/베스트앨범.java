import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // ** needs
        // genre => plays의 합이 큰 경우
            // plays => plays가 큰 경우
                // plays가 같은 경우
                    // index가 낮은 경우
      
        HashMap<String, Integer> genresPlaysTotalMap = new HashMap<>();
        for(int i=0;i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            genresPlaysTotalMap.put(genre, genresPlaysTotalMap.getOrDefault(genre,0)+play);
        }
        
        List<Entry<String, Integer>> genreCountList = new ArrayList<>(genresPlaysTotalMap.entrySet());
        Collections.sort(genreCountList, (o1,o2) -> o2.getValue()-o1.getValue());
        
        
        HashMap<String, TreeMap<Integer, Integer>> playMap = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            if(!playMap.containsKey(genres[i])){
                playMap.put(genres[i], new TreeMap<Integer,Integer>(new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    if(plays[o2] != plays[o1]){
                        return plays[o2]-plays[o1];
                    }
                    return o1-o2;
                }
                }));
            }
            playMap.get(genres[i]).put(i,plays[i]);
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for(int i=0;i<genreCountList.size();i++){
            TreeMap<Integer, Integer> map = playMap.get(genreCountList.get(i).getKey());
            List<Entry<Integer,Integer>> mapList = new ArrayList<>(map.entrySet());
            for(int j=0;j<mapList.size();j++){
                if(j>1){
                    break;
                }
                answerList.add(mapList.get(j).getKey());
            }
        }
        
        int [] answer = answerList.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}