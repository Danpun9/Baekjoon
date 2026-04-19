import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack aStack = new Stack();

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                aStack.push(num);
            } else {
                aStack.pop();
            }
        }

        int res = 0;
        int time = aStack.size();
        for (int i = 0; i < time; i++) {
            res += (Integer) aStack.pop();
        }
        System.out.println(res);
    }
}

class Node {
    public Object item;
    public Node nextNode;

    Node() {
        item = null;
        nextNode = null;
    }

    Node(Object item) {
        this.item = item;
        nextNode = null;
    }

    Node(Object item, Node nextNode) {
        this.item = item;
        this.nextNode = nextNode;
    }
}

class Stack {
    private Node top;
    private int size;

    Stack() {
        top = null;
        size = 0;
    }

    public void push(Object item) {
        Node newItem = new Node(item);

        if (top == null) {
            top = newItem;
        } else {
            newItem.nextNode = top;
            top = newItem;
        }
        size++;
    }

    public Object pop() {
        if (size == 0) {
            return null;
        } else {
            Object temp = top.item;
            top = top.nextNode;
            size--;
            return temp;
        }
    }

    public Object peek() {
        if (size == 0) {
            return null;
        } else {
            return top.item;
        }
    }

    public int size() {
        return size;
    }
}