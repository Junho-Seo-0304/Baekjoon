import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int num = 0;
			for(int i=1;i<=n;i++) {
				num=num*10+1;
				num%=n;
				if(num==0) {
					System.out.printf("%d\n", i);
					break;
				}
			}
		}
	}
}