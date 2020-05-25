import java.util.*;

class stack {
	int top;
	int[] stack;
	int size;
	
	public stack (int size) {
		top = -1;
		stack = new int[size];
		this.size = 0;
	}
	
	public void push (int x) {
		if(x<1||x>100000) {
			System.out.println("The number has to be between 1 and 100,000");
			return;
		}
		stack[++top] = x;
		size++;
	}
	
	public void pop() {
		if(top>-1) {
			System.out.println(stack[top--]);
			size--;
		} else {
			System.out.println(top);
		}
	}
	
	public void size() {
		System.out.println(size);
	}
	
	public void empty() {
		if(top>-1) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
	}
	
	public void top() {
		if(top>-1) {
			System.out.println(stack[top]);
		} else {
			System.out.println(top);
		}
	}
}

public class stackExample {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		stack stack = new stack(10000);
		String commend;
		int amount;
		amount = sc.nextInt();
		if (amount>10000||amount<1) {
			System.out.println("Commend's amount is too big.");
		} else {
			int i = 0;
			while(i<amount) {
				commend = sc.next();
				if(commend.equals("push")) {
					int x = sc.nextInt();
					stack.push(x);
				} else if(commend.equals("pop")) {
					stack.pop();
				} else if(commend.equals("size")) {
					stack.size();
				} else if(commend.equals("empty")) {
					stack.empty();
				} else if(commend.contentEquals("top")) {
					stack.top();
				}
				i++;
			}
		}
	}
}
