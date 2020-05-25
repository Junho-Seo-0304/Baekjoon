import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num_max = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		int top = 0;
		int[] arr = new int[num_max];
		boolean isAble = true;
		StringBuilder result = new StringBuilder();
		for(int i=0;i<num_max;i++) {
			arr[i] = sc.nextInt();		
		}
		for(int i=0;i<num_max;i++) {
			if(top<arr[i]) {
				for(int j=top+1;j<=arr[i];j++) {
					stack.push(j);
					result.append("+\n");
				}
				top=arr[i];
				stack.pop();
				result.append("-\n");
			} else {
				if(Integer.parseInt(stack.peek().toString())==arr[i]) {
					stack.pop();
					result.append("-\n");
				} else {
					isAble = false;
					break;
				}
			}	
		}
		if(isAble) {
			System.out.print(result);
		} else {
			System.out.println("NO");
		}
	}
}

