import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            if (!data.containsKey(card)) {
                data.put(card, 1);
            } else {
                data.put(card, data.get(card) + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!data.containsKey(num)) {
                sb.append("0 ");
            } else {
                sb.append(data.get(num)).append(" ");
            }
        }

        System.out.println(sb);
    }
}