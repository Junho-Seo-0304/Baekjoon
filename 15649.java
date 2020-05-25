import java.io.*;
import java.util.*;
 
public class Main {
	static int n;
	static int m;
	static int[] used;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	used = new int[m];
    	for(int i=1;i<=n;i++) {
    		check(i,0);
    	}
    }
    
   static void check(int x,int count) {
	   used[count]=x;
	   if(count==m-1) {
		   for(int i=0;i<m;i++) {
			   System.out.print(used[i]+" ");
		   }
		   System.out.println();
		   return;
	   }
	   for(int i=1;i<=n;i++) {
		   boolean isUsed = false;
		   for(int j=0;j<=count;j++) {
			   if(used[j]==i) {
				   isUsed=true;
				   break;
			   }
		   }
		   if(isUsed)
			   continue;
		   check(i,count+1);
	   }
   }
}