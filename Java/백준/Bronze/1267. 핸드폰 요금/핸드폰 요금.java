import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int Y = 0, M = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());
            Y += ((time / 30) + 1) * 10;
            M += ((time / 60) + 1) * 15;
        }

        if (Y == M) {
            sb.append("Y M ").append(Y);
        } else if (Y < M) {
            sb.append("Y ").append(Y);
        } else {
            sb.append("M ").append(M);
        }

        System.out.println(sb);
    }
}