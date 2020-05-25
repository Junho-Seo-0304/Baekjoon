import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] num;
	static boolean[] used;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		used = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			num[i]=Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i=0;i<n;i++) {
			Arrays.sort(num);
			int temp = num[i];
			num[i]=num[0];
			num[0]=temp;
			int max=0;
			change(0);
			for(int j=0;j<n-1;j++)
				max+=Math.abs(num[j]-num[j+1]);
			ans=Math.max(ans, max);
		}
		System.out.println(ans);
	}
	
	static void change(int x) {
		if(x==n-1)
			return;
		int index=-1;
		int max=-1;
		for(int i=x+1;i<n;i++) {
			if(max<Math.abs(num[x]-num[i])) {
				max=Math.abs(num[x]-num[i]);
				index=i;
			}
		}
		int temp = num[x+1];
		num[x+1]=num[index];
		num[index]=temp;
		change(x+1);
	}
}