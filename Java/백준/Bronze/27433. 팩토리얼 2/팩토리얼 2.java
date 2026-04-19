import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long res = factorial(N);

        System.out.println(res);

    }

    static long factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}