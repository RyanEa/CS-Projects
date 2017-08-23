
public class StringStack {
    
    private static final int DEFAULT_STACK_CAPACITY = 64;

    private String[] stack; 
    private int top;        // top of the stack, -1 empty stack

    public StringStack (int capacity) {
        stack = new String[capacity];
        top = -1;
    }
    
    public StringStack () {
        this(DEFAULT_STACK_CAPACITY);
    }

    public void push (String e) {
        if (top + 1 == stack.length) {
            throw new RuntimeException("Stack full");
        }
        stack[++top] = e;
    }

    public String pop () {
        if (top == -1) {
            throw new RuntimeException("Stack empty");
        }
        return stack[top--];
    }
    
    public int length () {
        return top + 1;
    }

    public boolean empty () {
        return top == -1;
    }

    public String peek () {
        if (top == -1) {
            throw new RuntimeException("Stack empty");
        }
        return stack[top];
    }
    
    public String toString () {
        String s = "BOTTOM[ ";
        for (int i = 0; i <= top; i++) {
            s += stack[i] + " ";
        }
        return s + "]TOP";
    }
}
