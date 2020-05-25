import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] words = new String[s.length()];
		for(int i=0;i<s.length();i++) {
			words[i]=s.substring(i);
		}
		Arrays.sort(words);
		for(int i=0;i<s.length();i++) {
			System.out.println(words[i]);
		}
	}

}
