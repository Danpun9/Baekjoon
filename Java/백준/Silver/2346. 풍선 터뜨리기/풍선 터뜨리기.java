import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<int[]> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            deque.addLast(new int[] { i, Integer.parseInt(st.nextToken()) });
        }

        int nextNum[] = deque.removeFirst();
        sb.append(nextNum[0]).append(" ");

        while (!deque.isEmpty()) {
            if (nextNum[1] > 0) {
                for (int i = 0; i < nextNum[1] - 1; i++) {
                    deque.addLast(deque.removeFirst());
                }
                nextNum = deque.removeFirst();
            } else {
                for (int i = 0; i > nextNum[1] + 1; i--) {
                    deque.addFirst(deque.removeLast());
                }
                nextNum = deque.removeLast();
            }

            sb.append(nextNum[0]).append(" ");
        }

        System.out.println(sb);
    }
}