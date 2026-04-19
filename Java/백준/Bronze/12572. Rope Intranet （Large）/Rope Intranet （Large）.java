import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] wireA = new int[n];
            int[] wireB = new int[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                wireA[i] = Integer.parseInt(st.nextToken());
                wireB[i] = Integer.parseInt(st.nextToken());
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (wireA[i] > wireA[j] && wireB[i] < wireB[j] || wireA[i] < wireA[j] && wireB[i] > wireB[j]) {
                        res++;
                    }
                }
            }

            sb.append("Case #").append(t).append(": ").append(res).append("\n");
        }

        System.out.println(sb);
    }
}