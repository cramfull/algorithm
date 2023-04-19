
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;



	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//배열 길이는 N
		//배열에 입력받은 원소 추가 
		//max선언 = 배열 첫번째 값,최소값
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		for(int i =0; i<arr.length; i++) {
			int item = Integer.parseInt(br.readLine());
			arr[i]= item;
		}
		int tmp=0;
		for(int j=0; j<arr.length-1;j++) {
			for (int k=j+1; k<arr.length; k++) {
				if(arr[j]>arr[k]) {
					tmp=arr[j];
					arr[j]=arr[k];
					arr[k]=tmp;
				
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
				
			
		
	}
}











