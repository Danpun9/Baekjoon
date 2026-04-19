import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] isBroken = new boolean[10];

        if (m != 0) {
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            int brokenBtn = Integer.parseInt(st.nextToken());
            isBroken[brokenBtn] = true;
        }

        if (n == 100) {
            System.out.println(0);
            return;
        }

        int ans = Math.abs(n - 100);
        for (int i = 0; i <= 1000000; i++) {
            String strChan = String.valueOf(i);

            boolean isPossible = true;
            for (int j = 0; j < strChan.length(); j++) {
                int btn = strChan.charAt(j) - '0';
                if (isBroken[btn]) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                int cnt = strChan.length() + Math.abs(i - n);
                ans = Math.min(ans, cnt);
            }
        }
        System.out.println(ans);
    }
}