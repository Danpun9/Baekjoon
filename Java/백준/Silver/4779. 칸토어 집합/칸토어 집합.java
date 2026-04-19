import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void cantor(int n) {
        if (n == 0) {
            sb.append("-");
            return;
        }

        int size = (int) Math.pow(3, n - 1);

        cantor(n - 1);
        for (int i = 0; i < Math.pow(3, n - 1); i++) {
            sb.append(" ");
        }
        cantor(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n;
            try {
                n = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                break;
            }
            cantor(n);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}