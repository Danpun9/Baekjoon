import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> queue = new LinkedList<>();

        boolean[] isQueue = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == 0)
                isQueue[i] = true;
            else
                isQueue[i] = false;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (isQueue[i])
                queue.addLast(Integer.parseInt(st.nextToken()));
            else
                st.nextToken();
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            queue.addFirst(Integer.parseInt(st.nextToken()));
            sb.append(queue.removeLast()).append(" ");
        }

        System.out.println(sb);
    }
}