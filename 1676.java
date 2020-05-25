import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 1;
		int two = 0;
		int five = 0;
		for(int i=n;i>0;i--) {
			ans = i*ans;
			if(i%2==0) {
				int temp = i;
				while(temp%2==0) {
					two++;
					temp=temp/2;
				}
			}
			if(i%5==0) {
				int temp = i;
				while(temp%5==0) {
					five++;
					temp=temp/5;
				}
			}
		}
		System.out.println(Math.min(two, five));
	}

}
