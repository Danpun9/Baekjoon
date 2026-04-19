import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        boolean snack = true;
        int next = 1;
        while (queue.size() != 0 || stack.size() != 0) {
            if (queue.size() != 0 && queue.peek() == next) {
                queue.remove();
                next++;
            } else if (stack.size() != 0 && stack.peek() == next) {
                stack.pop();
                next++;
            } else if (queue.size() != 0) {
                stack.push(queue.remove());
            } else {
                snack = false;
                break;
            }
        }

        if (snack) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}