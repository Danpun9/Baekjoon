import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int time = 0;
        int[] divisor = new int[N];

        for (int i = 1; i <= N && time != K; i++) {
            if (N % i == 0) {
                divisor[time] = i;
                time++;
            }
        }
        bw.write(String.valueOf(divisor[K - 1]));
        bw.flush();
    }
}
