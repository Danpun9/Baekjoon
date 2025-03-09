import java.io.*;
import java.util.*;

public class Main {

    static long[] minSide = new long[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int distance = Y - X;
            int max = (int) Math.sqrt(distance);

            if (max == Math.sqrt(distance)) {
                System.out.println(2 * max - 1);
            } else if (distance <= max * max + max) {
                System.out.println(2 * max);
            } else {
                System.out.println(2 * max + 1);
            }
        }
    }
}