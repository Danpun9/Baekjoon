import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                q.add(Integer.parseInt(st.nextToken()));

            } else if (cmd.equals("pop")) {
                if (!q.isEmpty()) {
                    sb.append(q.remove()).append("\n");
                } else {
                    sb.append("-1\n");
                }

            } else if (cmd.equals("size")) {
                sb.append(q.size()).append("\n");

            } else if (cmd.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }

            } else {
                if (q.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    if (cmd.equals("front")) {
                        sb.append(q.peekFirst()).append("\n");
                    } else {
                        sb.append(q.peekLast()).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
