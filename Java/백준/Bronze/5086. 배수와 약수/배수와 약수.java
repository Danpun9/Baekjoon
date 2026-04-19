import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0)
                break;
            bw.write(FMbranch(a, b));
            bw.flush();
        }

    }

    public static String FMbranch(int a, int b) {

        if (a >= b) {
            if (a % b == 0)
                return "multiple\n";
        } else {
            if (b % a == 0)
                return "factor\n";
        }
        return "neither\n";

    }
}
