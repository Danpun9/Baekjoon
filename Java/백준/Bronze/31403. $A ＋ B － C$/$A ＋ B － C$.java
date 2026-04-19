import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int res = a + b - c;

        bw.write(res + "\n");

        res = Integer.parseInt(String.valueOf(a) + String.valueOf(b)) - c;

        bw.write(res + "\n");

        bw.close();
    }
}