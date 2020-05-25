import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		for(int i=0;i<n+1;i++) {
			arr[i]=i;
		}
		arr[1]=0;
		for(int i=2;i<n+1;i++) {
			if(arr[i]==0) {
				continue;
			} else {
				for(int j=i+i;j<n+1;j+=i) {
					arr[j]=0;
				}
			}
		}
		int count = 0;
		for(int i=m;i<n+1;i++) {
			if(arr[i]!=0) {
				System.out.println(arr[i]);
				count++;
			}
		}
		System.out.println(count);
	}

}
