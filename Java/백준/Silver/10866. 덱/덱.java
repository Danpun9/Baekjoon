import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> d = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push_front")) {
                d.addFirst(Integer.parseInt(st.nextToken()));

            } else if (cmd.equals("push_back")) {
                d.addLast(Integer.parseInt(st.nextToken()));

            } else if (cmd.equals("size")) {
                sb.append(d.size()).append("\n");

            } else if (cmd.equals("empty")) {
                sb.append(d.isEmpty() ? 1 : 0).append("\n");

            } else if (!d.isEmpty()) {
                if (cmd.equals("pop_front")) {
                    sb.append(d.removeFirst()).append("\n");

                } else if (cmd.equals("pop_back")) {
                    sb.append(d.removeLast()).append("\n");

                } else if (cmd.equals("front")) {
                    sb.append(d.peekFirst()).append("\n");

                } else {
                    sb.append(d.peekLast()).append("\n");
                }
            } else {
                sb.append(-1).append("\n");
            }

        }

        System.out.println(sb);
    }
}
