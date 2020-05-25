import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long[] ans = new long[t];
		for(int i=0;i<t;i++) {
			ans[i]=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for(int j=0;j<n;j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			for(int j=0;j<n-1;j++) {
				for(int k=j+1;k<n;k++) {
					int temp1=arr[j];
					int temp2=arr[k];
					if(temp2>temp1) {
						int temp3 = temp1;
						temp1 = temp2;
						temp2 = temp3;
					}
					while(temp2!=0) {
						int temp3 = temp1%temp2;
						temp1=temp2;
						temp2=temp3;						
					}
					ans[i]+=temp1;
				}
			}
		}
		for(int i=0;i<t;i++) {
			System.out.println(ans[i]);
		}
	}

}
