import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] n = new int[9];
        int[] max = { 0, 0 };
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(br.readLine());
            if (n[i] > max[0]) {
                max[0] = n[i];
                max[1] = i + 1;
            }
        }
        System.out.println(max[0] + "\n" + max[1]);
    }
}