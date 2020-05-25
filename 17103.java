import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[1000001];
		int[] ans = new int[t];
		Arrays.fill(arr, true);
		arr[0]=false;
		arr[1]=false;
		for(int i=2;i<1000001;i++) {
			if(!arr[i]) {
				continue;
			} else {
				for(int j=i+i;j<1000001;j+=i) {
					arr[j]=false;
				}
			}
		}
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			
			for(int j=2;j<=n/2;j++) {
				if(arr[j]&&arr[n-j]) {
					ans[i]++;
				}
			}
		}
		for(int i=0;i<t;i++) {
			System.out.println(ans[i]);
		}
	}

}
