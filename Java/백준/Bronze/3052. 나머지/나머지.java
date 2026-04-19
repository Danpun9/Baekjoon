import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] remain = new int[10];

        for (int i = 0; i < remain.length; i++) {
            remain[i] = Integer.parseInt(br.readLine());
            remain[i] %= 42;
        }

        Arrays.sort(remain);

        int result = 0;
        for (int i = 0; i < (remain.length - 1); i++) {
            if (remain[i] != remain[(i + 1)])
                result++;
        }
        if (remain[9] != remain[0] || result == 0)
            result++;
        System.out.println(result);

    }
}