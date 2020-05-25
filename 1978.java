import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[1001];
		for(int i=0;i<1001;i++) {
			arr[i]=i;
		}
		arr[1]=0;
		for(int i=2;i<1001;i++) {
			if(arr[i]==0) {
				continue;
			} else {
				for(int j=i+i;j<1001;j+=i) {
					arr[j]=0;
				}
			}
		}
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			if(arr[Integer.parseInt(st.nextToken())]!=0) {
				count++;
			}
		}
		System.out.println(count);
	}
}
