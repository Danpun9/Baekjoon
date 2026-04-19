import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                minHeap.add(x);
            } else {
                Integer res = minHeap.poll();
                if (res == null) {
                    res = 0;
                }
                sb.append(res).append("\n");
            }
        }

        System.out.println(sb);
    }
}