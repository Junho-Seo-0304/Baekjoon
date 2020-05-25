import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		long s = Long.parseLong(st1.nextToken());
		long[] location = new long[n];
		long[] lo_gap = new long[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			location[i]=Long.parseLong(st2.nextToken());
			lo_gap[i] = (s-location[i])>0 ? s-location[i] : (s-location[i])*(-1);
		}
		long ans = lo_gap[0];
		for(int i=1;i<n;i++) {
			long temp1=ans;
			long temp2=lo_gap[i];
			if(temp2>temp1) {
				long temp3 = temp1;
				temp1=temp2;
				temp2=temp3;
			}
			while(temp2!=0) {
				long temp3=temp1%temp2;
				temp1=temp2;
				temp2=temp3;
			}
			ans=temp1;
		}
		System.out.println(ans);
	}

}
