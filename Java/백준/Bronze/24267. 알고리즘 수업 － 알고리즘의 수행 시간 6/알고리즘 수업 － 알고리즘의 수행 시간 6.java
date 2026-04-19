import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long n = Integer.parseInt(br.readLine());

        sb.append((n - 2) * (n - 1) * n / 6).append("\n3");
        System.out.println(sb);
    }
}