import java.io.*;
import java.util.*;
 
public class Main {
	static boolean[] brk;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	brk = new boolean[10];
    	if(m!=0) {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0;i<m;i++) {
    		int temp=Integer.parseInt(st.nextToken());
    		brk[temp]=true;
    	}
    	}
    	int min = Math.abs(n-100);
    	for(int i=0;i<=1000000;i++) {
    		if(check(i)!=0) {
    			min=Math.min(min, Math.abs(n-i)+check(i));
    		}
    	}
    	System.out.println(min);
    }
    static int check(int x) {
    	String s = Integer.toString(x);
    	for(int i=0;i<s.length();i++) {
    		int temp = s.charAt(i)-'0';
    		if(brk[temp])
    			return 0;
    	}
    	return s.length();
    }
}