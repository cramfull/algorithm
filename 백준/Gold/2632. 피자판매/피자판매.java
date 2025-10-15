import java.io.*;
import java.util.*;

public class Main {
	
	static int size, n, m, result;
	static int [] pizzaA, pizzaB, prefixSumA, prefixSumB;
	static ArrayList<Integer> sumListA, sumListB;
	static HashMap<Integer, Integer> sumMapA, sumMapB;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		n = Integer.parseInt(str.nextToken());
		m = Integer.parseInt(str.nextToken());
		pizzaA = new int[n];
		pizzaB = new int[m];
		
		for(int i=0;i<n;i++) {
			pizzaA[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0;i<m;i++) {
			pizzaB[i]=Integer.parseInt(br.readLine());
		}
		
		prefixSumA = new int[n+1];
		prefixSumB = new int[m+1];
		
		buildPrefixSum(pizzaA, prefixSumA);
		buildPrefixSum(pizzaB, prefixSumB);
		
//		sumListA = new ArrayList<>();
//		sumListB = new ArrayList<>();
		
		sumMapA = new HashMap<>();
		sumMapB = new HashMap<>();
		
//		makePizzaSum(sumListA, pizzaA, prefixSumA);
//		makePizzaSum(sumListB, pizzaB, prefixSumB);
		
		makePizzaSum(sumMapA, pizzaA, prefixSumA);
		makePizzaSum(sumMapB, pizzaB, prefixSumB);

		result = 0;
//		countPizzaSum();
		countPizzaSum2();
		System.out.println(result);
	}
	
	static void buildPrefixSum(int [] pizza, int [] prefixSum) {
		for(int i=0;i<pizza.length;i++) {
			prefixSum[i+1]=prefixSum[i]+pizza[i];
		}
	}
	
	static void makePizzaSum(ArrayList<Integer> sumList, int [] pizza, int [] prefixSum) {
		sumList.add(0);
		if(prefixSum[pizza.length]<=size) sumList.add(prefixSum[pizza.length]);
		for(int gap=0;gap<pizza.length-1;gap++) {
			for(int start=1;start<=pizza.length;start++) {
				int end = start+gap;
				int sumValue = 0;
				if(end<=pizza.length) {
					sumValue = prefixSum[end]-prefixSum[start-1];
				}else {
					sumValue = prefixSum[pizza.length]-prefixSum[start-1]+prefixSum[end-(pizza.length)];
				}
				
				if(sumValue<=size) sumList.add(sumValue);
				
			}
		}
	}
	
	static void makePizzaSum(HashMap<Integer,Integer> sumMap, int [] pizza, int [] prefixSum) {
		sumMap.put(0,1);
		int last = prefixSum[pizza.length];
		if(last<=size) sumMap.put(last, sumMap.getOrDefault(last, 0)+1);
		for(int gap=0;gap<pizza.length-1;gap++) {
			for(int start=1;start<=pizza.length;start++) {
				int end = start+gap;
				int sumValue = 0;
				if(end<=pizza.length) {
					sumValue = prefixSum[end]-prefixSum[start-1];
				}else {
					sumValue = prefixSum[pizza.length]-prefixSum[start-1]+prefixSum[end-(pizza.length)];
				}
				
//				if(sumValue<=size) sumList.add(sumValue);
				if(sumValue<=size) {
					sumMap.put(sumValue, sumMap.getOrDefault(sumValue, 0)+1);	
				}
			}
		}
	}
	
	static void countPizzaSum2() {
		for(int i=0;i<=size;i++) {
			if(sumMapA.containsKey(i)) {
				int countA = sumMapA.get(i);
				int otherSize = size-i;
				if(sumMapB.containsKey(otherSize)) {
					int countB = sumMapB.get(otherSize);
					result+=countA*countB;
				}
			}
		}
	}
	
	
	static void countPizzaSum() {
		for(int i=0;i<sumListA.size();i++) {
			int nowSize = sumListA.get(i);
			int otherSize = size - nowSize;
			
			if(otherSize==0) {
				result++;
			}else {
				for(int j=0;j<sumListB.size();j++) {
					if(sumListB.get(j)==otherSize) result++;
				}
			}
		}
	}
}
