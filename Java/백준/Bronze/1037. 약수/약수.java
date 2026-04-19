import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long max = -1;
        long min = Long.MAX_VALUE;

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long a = Long.parseLong(st.nextToken());

            max = Math.max(max, a);
            min = Math.min(min, a);
        }

        System.out.println(max * min);
    }
}