import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1000001];
		for(int i=0;i<1000001;i++) {
			arr[i]=i;
		}
		arr[1]=0;
		for(int i=2;i<1000001;i++) {
			if(arr[i]==0) {
				continue;
			} else {
				for(int j=i+i;j<1000001;j+=i) {
					arr[j]=0;
				}
			}
		}
		while(n!=0) {
			boolean isAble = false;
			for(int i=3;i<n+1;i+=2) {
				if(arr[i]!=0&&arr[n-i]!=0) {
					System.out.println(n+" = "+arr[i]+" + "+arr[n-i]);
					isAble=true;
					break;
				}
			}
			if(!isAble) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
			n = Integer.parseInt(br.readLine());
		}
	}

}
