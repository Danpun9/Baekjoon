import java.io.*;
import java.util.*;

public class Main {

    static Integer[] memo;

    static int to1(int N) {
        if (memo[N] == null) {
            if (N % 6 == 0) {
                memo[N] = Math.min(Math.min(to1(N / 3), to1(N / 2)), to1(N - 1)) + 1;
            } else if (N % 3 == 0) {
                memo[N] = Math.min(to1(N / 3), to1(N - 1)) + 1;
            } else if (N % 2 == 0) {
                memo[N] = Math.min(to1(N / 2), to1(N - 1)) + 1;
            } else {
                memo[N] = to1(N - 1) + 1;
            }
        }
        return memo[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        memo = new Integer[N + 1];

        memo[0] = memo[1] = 0;

        System.out.println(to1(N));
    }
}