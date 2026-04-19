import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());

        int res = 0;
        while (true) {
            if (l <= 0) {
                break;
            }
            l -= 5;
            res++;
        }

        System.out.println(res);
    }
}