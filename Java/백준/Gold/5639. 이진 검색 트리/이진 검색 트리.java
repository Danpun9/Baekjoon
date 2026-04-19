import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        int item;
        Node left, right;

        Node(int v) {
            item = v;
            left = right = null;
        }
    }

    static void Insert(Node parent, Node child) {
        if (parent.item > child.item) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                Insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                Insert(parent.right, child);
            }
        }
    }

    static void postOrder(Node node) throws IOException {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        bw.write(String.valueOf(node.item) + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            try {
                Node node = new Node(Integer.parseInt(br.readLine()));
                Insert(root, node);
            } catch (Exception e) {
                break;
            }
        }

        postOrder(root);

        bw.flush();
        bw.close();
    }
}