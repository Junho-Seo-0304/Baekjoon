import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			switch(s.charAt(i)) {
			case '0':
				sb.append("000");
				break;
			case '1':
				sb.append("001");
				break;
			case '2':
				sb.append("010");
				break;
			case '3':
				sb.append("011");
				break;
			case '4':
				sb.append("100");
				break;
			case '5':
				sb.append("101");
				break;
			case '6':
				sb.append("110");
				break;
			case '7':
				sb.append("111");
				break;
			}
		}
		while(sb.charAt(0)=='0'&&sb.length()>1) {
			sb.deleteCharAt(0);
		}
		System.out.println(sb);
	}

}
