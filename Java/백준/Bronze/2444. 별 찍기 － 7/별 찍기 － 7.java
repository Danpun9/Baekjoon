import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                bw.write(" ");
            }
            for (int j = (i * 2 - 1); j > 0; j--) {
                bw.write("*");
            }
            bw.write("\n");
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = n - i; j > 0; j--) {
                bw.write(" ");
            }
            for (int j = (i * 2 - 1); j > 0; j--) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.close();

    }
}
