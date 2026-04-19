import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            int min = 99999;
            int max = -1;

            for (int i = 0; i < r; i++) {
                String str = br.readLine();
                if (str.contains("#")) {
                    min = Math.min(min, i);
                    max = Math.max(max, i);
                }
            }

            sb.append(max - min).append("\n");
        }

        System.out.println(sb);
    }
}