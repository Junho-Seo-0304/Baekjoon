import java.io.*;
import java.util.*;
 
public class Main {
	static int n;
	static int m;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	check(0,"");
    }
    
   static void check(int x,String a) {
	   if(x==m) {
		   System.out.println(a);
		   return;
	   }
	   for(int i=1;i<=n;i++) {
		   check(x+1,a+i+" ");
	   }
   }
}