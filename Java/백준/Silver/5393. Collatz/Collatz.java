import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int res = 0;
            int n = Integer.parseInt(br.readLine());

            if (n % 2 == 0) {
                res += n / 2;
            } else {
                res += n / 2 + 1;
            }

            if (n % 6 == 0 || n % 6 == 4) {
                res += n / 3;
            } else {
                res += n / 3 + 1;
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}