import java.io.*;
 
public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int count = 0;
    	int length = 1;
    	int limit = 10;
    	for(int i=1;i<=n;i++) {
    		if(i==limit) {
    			length++;
    			limit*=10;
    		}
    		count+=length;
    	}
    	System.out.println(count);
    }
}