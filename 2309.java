import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = new int[9];
		int sum = 0;
		int f1 = 10;
		int f2 = 10;
		for(int i=0;i<9;i++) {
			n[i]=Integer.parseInt(br.readLine());
			sum+=n[i];
		}
		boolean found = false;
		for(int i=0;i<9;i++) {
			for(int j=i+1;j<9;j++) {
				if(sum-n[i]-n[j]==100) {
					n[i]=101;
					n[j]=101;
					found=true;
					break;
				}
			}
			if(found) {
				break;
			}
		}
		Arrays.sort(n);
		for(int i=0;i<7;i++) {
			System.out.println(n[i]);
		}
	}
}
