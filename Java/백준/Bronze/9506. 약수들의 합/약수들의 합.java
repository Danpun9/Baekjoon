import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n != -1) {
            int sum = 0;
            String res = n + " = ";
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    sum += i;
                    res = res + i + " + ";
                }
            }
            res = res.substring(0, res.length() - 3);

            if (n == sum) {
                bw.write(res + "\n");
                bw.flush();
            } else {
                bw.write(String.valueOf(n) + " is NOT perfect.\n");
                bw.flush();
            }
            n = Integer.parseInt(br.readLine());
        }
    }
}
