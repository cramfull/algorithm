
import java.io.*;

import java.util.*;


public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		Person [] arr = new Person[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i]= new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
	
		Arrays.sort(arr);

		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].age+" "+arr[i].name);
		}
		
	}
	
	static class Person implements Comparable<Person>{
		public int age;
		public String name;
		
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}


		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return age - o.age;
		}
		
		
	}
	
}