import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void hanoi(int n, int t1, int t2, int t3) throws IOException {
        if (n == 1) {
            bw.write(t1 + " " + t3 + "\n");
            return;
        }

        hanoi(n - 1, t1, t3, t2);
        bw.write(t1 + " " + t3 + "\n");
        hanoi(n - 1, t2, t1, t3);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        bw.write((int) (Math.pow(2, n) - 1) + "\n");

        hanoi(n, 1, 2, 3);

        bw.flush();
        bw.close();
    }
}