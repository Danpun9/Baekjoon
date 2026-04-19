import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean reverse = true;

        for (int j = 0; j < N - 1; j++) {
            if (j % M == 0) {
                reverse = !reverse;
            }

            for (int i = 0; i < K - 1; i++) {
                if (reverse) {
                    dq.offerFirst(dq.pollLast());
                } else {
                    dq.offerLast(dq.pollFirst());
                }
            }

            if (reverse) {
                sb.append(dq.pollLast()).append("\n");
            } else {
                sb.append(dq.pollFirst()).append("\n");
            }

        }

        sb.append(dq.poll());
        System.out.println(sb);
    }
}