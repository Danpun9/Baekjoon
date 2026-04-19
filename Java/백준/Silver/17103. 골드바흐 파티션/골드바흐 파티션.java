import java.io.*;

public class Main {

    public static boolean prime[];

    public static void getPrime() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i] == true)
                continue;
            else {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        prime = new boolean[1000001];
        getPrime();

        for (int i = Integer.parseInt(br.readLine()); i > 0; i--) {
            int num = Integer.parseInt(br.readLine());
            int res = 0;

            for (int j = 2; j <= num / 2; j++) {
                if (!prime[j] && !prime[num - j]) {
                    res++;
                }
            }
            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}