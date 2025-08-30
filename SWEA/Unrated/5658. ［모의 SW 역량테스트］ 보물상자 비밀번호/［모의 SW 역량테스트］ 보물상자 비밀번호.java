import java.io.*;
import java.util.*;

/* 인덱스로 조지면 조금 귀찮긴 할 듯
 * list에 rotate 메서드를 사용해보자
 * 회전 -> 3개의 단어묶음으로 생성해서 TreeSet에 넣고 array로 변환하기
 * K번째 수 찾기 
 */
public class Solution {

	static int N,K;
	static List<Character> nums;
	static TreeSet<Integer> treeSet;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			nums = new ArrayList<>();
			treeSet = new TreeSet<>((o1,o2)->(o2-o1)); 
			
			N = Integer.parseInt(str.nextToken());
			K = Integer.parseInt(str.nextToken());
			
			String line = br.readLine();
			for(int i=0;i<N;i++) {
				nums.add(line.charAt(i));
			}
			
			for(int i=0;i<N/4;i++) {
				collectNums();
				Collections.rotate(nums,1);
			}
			Iterator<Integer> it = treeSet.iterator();
			int num =0;
			for(int i=0;i<K;i++) {
				num = it.next();
			}
			
			sb.append("#").append(tc).append(" ").append(num).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void collectNums() {
		StringBuilder sb;
		for(int i=0;i<4;i++) {
			sb = new StringBuilder();
			for(int j=i*N/4;j<(i+1)*N/4;j++) {
				sb.append(nums.get(j));
			}
			String num = sb.toString();
			treeSet.add(Integer.parseInt(num,16));
		}
	}
}
