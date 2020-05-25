import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static long max=0,min=Long.MAX_VALUE;
	static char[] marker;
	static boolean[] num = new boolean[10];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		marker = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) 
			marker[i]=st.nextToken().charAt(0);
		for(int i=0;i<10;i++) {
			num[i]=true;
			check(0,i);
			num[i]=false;
		}
		String maxS = Long.toString(max);
		String minS = Long.toString(min);
		if(maxS.length()<k+1) {
			maxS="0"+maxS;
		}
		if(minS.length()<k+1) {
			minS="0"+minS;
		}
		System.out.println(maxS);
		System.out.println(minS);
	}
	static void check(int depth,long ans) {
		if(depth==k) {
			max=Math.max(max, ans);
			min=Math.min(min, ans);
			return;
		}
		for(int i=0;i<10;i++) {
			if(num[i])
				continue;
			
			if(marker[depth]=='<') {
				if(ans%10<i) {
					num[i]=true;
					check(depth+1,ans*10+i);
					num[i]=false;
				}
			}
			if(marker[depth]=='>') {
				if(ans%10>i) {
					num[i]=true;
					check(depth+1,ans*10+i);
					num[i]=false;
				}
			}
		}
	}
}
