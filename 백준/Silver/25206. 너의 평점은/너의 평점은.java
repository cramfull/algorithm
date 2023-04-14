
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



	
public class Main {
	double score;
	public double changeScore(String gp) {
		switch(gp) {
		case "A+" :  score = 4.5;
			break;
		case "A0" :  score = 4.0;
		break;
		case "B+" :  score = 3.5;
		break;
		case "B0" :  score = 3.0;
		break;
		case "C+" :  score = 2.5;
		break;
		case "C0" :  score = 2.0;
		break;
		case "D+" :  score = 1.5;
		break;
		case "D0" :  score = 1.0;
		break;
		case "F" :  score = 0.0;
		break;
		case "P" :  score = -1;
		break;
		}
		return score;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		float sum = 0;
		Main myMain = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		float CreditSum =0;
		
		for(int i = 0; i<20; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			str.nextToken();
			float Credit = Float.parseFloat(str.nextToken());
			String GP = str.nextToken();
			double CS = myMain.changeScore(GP);
			if(CS == -1) {
				Credit =0;
			}
			CreditSum +=Credit;
			sum+= Credit*CS;
			
		}
		
		System.out.printf("%6f",sum/CreditSum);

	}
}











