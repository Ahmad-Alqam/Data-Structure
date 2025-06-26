package final_;
// Feature 4
public class ArrayStack {
	private String[] stack;
	private int top;
	private int size;
	
	public ArrayStack(int capacity) {
		stack = new String[capacity];
		top = -1;
		size = 0;
	}
	
	public void push(String data) { //O(1)
		if(top == stack.length - 1) { //validation
			return;
		}
		stack[++top] = data;
		size++;
	}
	
	public String pop() { //O(1)
		if(isEmpty()) { //validation
			return null;
		}
		size--;
		return stack[top--];
	}
	
	public String peek(){ //O(1)
		if(isEmpty()) { //validation
			return null;
		}
		return stack[top];
	}
	
	public boolean isEmpty() { //O(1)
		return size == 0;
	}
	
	public int size() { //O(1)
		return size;
	}
	
}
