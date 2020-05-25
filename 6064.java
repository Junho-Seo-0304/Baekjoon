import java.io.*;
import java.util.*;
 
public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	int[] ans = new int[t];
    	for(int i=0;i<t;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int m = Integer.parseInt(st.nextToken());
    		int n = Integer.parseInt(st.nextToken());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		int year = x;
    		for(int j=0;j<=n;j++) {
    			int ty = year%n==0?n:year%n;
    			if(ty==y) {
    				break;
    			}
    			year+=m;
    		}
    		if(year>lcm(m,n)) {
    			ans[i]=-1;
    		} else {
    			ans[i]=year;
    		}
    	}
    	for(int i=0;i<t;i++) {
    		System.out.println(ans[i]);
    	}
    }
    
    static int lcm(int x, int y) {
    	int a=x;
    	int b=y;
    	if(b>a) {
    		int temp=b;
    		b=a;
    		a=temp;
    	}
    	while(b!=0) {
    		int temp=a%b;
    		a=b;
    		b=temp;
    	}
    	return x*y/a;
    }
}