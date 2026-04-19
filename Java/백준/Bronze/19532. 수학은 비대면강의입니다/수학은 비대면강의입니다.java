import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[6];

        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if (num[0] * i + num[1] * j == num[2] && num[3] * i + num[4] * j == num[5]) {
                    sb.append(i).append(" ").append(j);
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}