import java.io.*;
import java.util.*;
 
public class Main {
	static int n;
	static int m;
	static int[] num;
	static boolean[] used;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	StringTokenizer st2 = new StringTokenizer(br.readLine());
    	num = new int[n];
    	used = new boolean[n];
    	for(int i=0;i<n;i++)
    		num[i]=Integer.parseInt(st2.nextToken());
    	Arrays.sort(num);
    	check(0,"");
    }
    
   static void check(int x,String a) {
	   if(x==m) {
		   System.out.println(a);
		   return;
	   }
	   for(int i=0;i<n;i++) {
		   if(used[i])
			   continue;
		   used[i]=true;
		   check(x+1,a+num[i]+" ");
		   used[i]=false;
	   }
   }
}