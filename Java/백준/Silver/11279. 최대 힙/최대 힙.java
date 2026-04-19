import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                maxHeap.add(x);
            } else {
                Integer res = maxHeap.poll();
                if (res == null) {
                    res = 0;
                }
                sb.append(res).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}