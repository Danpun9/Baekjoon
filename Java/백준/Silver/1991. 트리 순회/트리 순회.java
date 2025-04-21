import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        char item;
        Node left, right;

        Node(char item, Node left, Node right) {
            this.item = item;
            left = right = null;
        }

    }

    static StringBuilder sb = new StringBuilder();

    public static void preOrder(Node node) {
        if (node == null)
            return;

        sb.append(node.item);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        sb.append(node.item);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.item);
    }

    static Node head = new Node('A', null, null);

    public static void insertNode(Node temp, char root, char left, char right) {

        if (temp.item == root) {
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (temp.left != null)
                insertNode(temp.left, root, left, right);
            if (temp.right != null)
                insertNode(temp.right, root, left, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);
        }

        preOrder(head);
        sb.append("\n");
        inOrder(head);
        sb.append("\n");
        postOrder(head);

        System.out.println(sb);
    }
}