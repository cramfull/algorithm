
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;





	
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] nums = br.readLine().split(" ");
		String tmp = "";
		for(int i=0; i<2; i++) {
			for(int j=i+1; j<3; j++) {
				if(Integer.parseInt(nums[i])>Integer.parseInt(nums[j])){
					tmp = nums[i];
					nums[i] = nums[j];
					nums[j]= tmp;
				}

			}
		}
		System.out.println(nums[0]+" "+nums[1]+" "+nums[2]);
	}
}















