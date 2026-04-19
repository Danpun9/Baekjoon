import java.io.*;
import java.util.*;

public class Main {

    static Long[] triangle = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        triangle[0] = 0L;
        triangle[1] = 1L;
        triangle[2] = 1L;
        triangle[3] = 1L;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(triWave(N)).append("\n");
        }

        System.out.println(sb);
    }

    static long triWave(int N) {
        if (triangle[N] == null) {
            triangle[N] = triWave(N - 2) + triWave(N - 3);
        }
        return triangle[N];
    }
}