import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (b > a && b > c) {
            int temp = a;
            a = b;
            b = temp;
        } else if (c > a && c > b) {
            int temp = a;
            a = c;
            c = temp;
        }
        if (c > b) {
            int temp = b;
            b = c;
            c = temp;
        }

        int res;

        if (a == c || a == b && b != c || c + b > a)
            res = a + b + c;
        else
            res = (b + c - 1) + b + c;

        System.out.println(res);
    }
}
