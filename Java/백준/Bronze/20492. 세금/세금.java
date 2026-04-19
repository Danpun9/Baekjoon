import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int a = n - (n * 22 / 100);

        int b = n * 80 / 100 + n * 20 / 100 - (n * 20 / 100) * 22 / 100;

        sb.append(a).append(" ").append(b);

        System.out.println(sb);
    }
}