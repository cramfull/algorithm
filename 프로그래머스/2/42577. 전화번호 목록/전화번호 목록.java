import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = solving(phone_book);
        return answer;
    }
    
    public boolean solving(String [] phone_book){
        String [] phones = phone_book.clone();
        Arrays.sort(phones);
        for(int i=0;i<phones.length-1;i++){
            if(phones[i+1].startsWith(phones[i])){
                return false;
            }
        }
        return true;
    }
}