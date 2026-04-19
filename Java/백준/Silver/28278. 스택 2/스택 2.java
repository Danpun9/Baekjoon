import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack aStack = new Stack();

        for (int i = Integer.parseInt(br.readLine()); i > 0; i--) {
            st = new StringTokenizer(br.readLine(), " ");
            int select = Integer.parseInt(st.nextToken());

            switch (select) {
                case 1:
                    Object num = st.nextToken();
                    aStack.push(num);
                    break;

                case 2:
                    Object temp = aStack.pop();
                    if (temp != null) {
                        sb.append(temp).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case 3:
                    sb.append(aStack.size()).append("\n");
                    break;

                case 4:
                    if (aStack.size() == 0) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case 5:
                    Object temp2 = aStack.peek();
                    if (temp2 != null) {
                        sb.append(temp2).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                default:
                    break;
            }
        }
        System.out.println(sb);
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