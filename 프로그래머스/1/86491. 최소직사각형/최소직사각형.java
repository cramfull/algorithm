class Solution {
    public int solution(int[][] sizes) {
        // arr[][0]        arr[][1]
        // 큰값을 0번으로
        // maxValueX, maxValueY 
        
        int answer = solving(sizes);
        return answer;
    }
    
    public int solving(int[][] sizes){
        int maxValueX = 0;
        int maxValueY = 0;
        
        for(int i=0;i<sizes.length; i++){
            int w = sizes[i][0];
            int h = sizes[i][1];
            if(w < h){
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = w;
            }
            maxValueX = Math.max(maxValueX, sizes[i][0]);
            maxValueY = Math.max(maxValueY, sizes[i][1]);
        }
        return maxValueX * maxValueY;
    }
    

}