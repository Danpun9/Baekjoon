import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int Quarter = N / 25;
            N -= Quarter * 25;
            int Dime = N / 10;
            N -= Dime * 10;
            int Nickel = N / 5;
            N -= Nickel * 5;
            int Penny = N / 1;

            String res = Quarter + " " + Dime + " " + Nickel + " " + Penny + "\n";

            bw.write(res);
        }

        bw.flush();
        bw.close();
    }
}
