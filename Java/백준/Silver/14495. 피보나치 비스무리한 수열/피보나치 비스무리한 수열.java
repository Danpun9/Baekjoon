import java.io.*;
import java.util.*;

public class Main{

    static long[] memo; // 메모이제이션

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        memo = new long[n + 1];

        if (n > 3) { // n이 3 이하면 ArrayIndexOutOfBoundsException 발생
            memo[1] = memo[2] = memo[3] = 1;
            bw.write(may_fibonacci(n) + "");
        } else {
            bw.write(1 + "");
        }

        bw.close();
        br.close();
    }

    static long may_fibonacci(int n) {
        if (memo[n] != 0) // 메모가 되어있으면 값 리턴
            return memo[n];
        else {
            memo[n] = (may_fibonacci(n - 1) + may_fibonacci(n - 3)); // 메모 되어있지 않으면 재귀
            return memo[n];
        }
    }
}
