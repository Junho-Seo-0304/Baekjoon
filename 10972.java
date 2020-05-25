import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		makeString();
	}
	
	static void makeString() {
		int check = -1;
		for(int i=n-1;i>0;i--) {
			if(arr[i-1]<arr[i]) {
				check=i-1;
				break;
			}
		}
		if(check==-1) {
			System.out.println(check);
			return;
		}
		for(int i=n-1;i>check;i--) {
			if(arr[i]>arr[check]) {
				int temp = arr[i];
				arr[i]=arr[check];
				arr[check]=temp;
				break;
			}
		}
		for(int i=0;i<=check;i++) {
			System.out.print(arr[i]+" ");
		}
		for(int i=n-1;i>check;i--) {
			System.out.print(arr[i]+" ");
		}
	}
}