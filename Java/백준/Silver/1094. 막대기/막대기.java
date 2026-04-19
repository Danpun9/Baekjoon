import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int res = 0;
        int length = 64;

        while (X != 0) {
            if (length > X) {
                length /= 2;
            } else if (length <= X) {
                X -= length;
                res++;
            }
        }

        System.out.println(res);
    }
}
