import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cable = new int[K];

        long max = 0;

        for (int i = 0; i < cable.length; i++) {
            cable[i] = Integer.parseInt(br.readLine());
            max = Math.max(cable[i], max);
        }

        long res = max;
        long min = 1;
        long mid = (max + min) / 2;

        while (max - min >= 0) {
            long sum = 0;

            for (int i = 0; i < cable.length; i++) {
                sum += cable[i] / mid;
                if (sum > N)
                    break;
            }

            if (sum >= N) {
                min = mid + 1;
                res = mid;
            } else {
                max = mid - 1;
            }

            mid = (max + min) / 2;
        }

        System.out.println(res);
    }
}