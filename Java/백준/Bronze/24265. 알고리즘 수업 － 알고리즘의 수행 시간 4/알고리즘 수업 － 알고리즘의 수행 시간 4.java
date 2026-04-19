import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long n = Integer.parseInt(br.readLine());

        sb.append(n * (n - 1) / 2).append("\n2");
        System.out.println(sb);
    }
}
