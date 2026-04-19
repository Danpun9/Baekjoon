import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String Kaprekar = br.readLine();
            int res = 0;

            while (!Kaprekar.equals("6174")) {
                int[] n = new int[4];
                for (int i = 0; i < 4; i++) {
                    n[i] = Kaprekar.charAt(i) - '0';
                }

                Arrays.sort(n);

                int min = n[0] * 1000 + n[1] * 100 + n[2] * 10 + n[3];
                int max = n[3] * 1000 + n[2] * 100 + n[1] * 10 + n[0];
                max -= min;

                Kaprekar = String.format("%04d", max);
                res++;
            }
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}