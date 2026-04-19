import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int i = 1;
        while ((i + 1) * (i + 1) <= N) {
            i++;
        }

        System.out.println(i);
    }
}