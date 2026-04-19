import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[6];
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int shirt = Integer.parseInt(st.nextToken());
        int pen = Integer.parseInt(st.nextToken());

        int Sres = 0, Pres1 = 0, Pres2 = 0;

        for (int i = 0; i < 6; i++) {
            while (arr[i] > 0) {
                Sres++;
                arr[i] -= shirt;
            }
        }

        Pres1 = n / pen;
        Pres2 = n % pen;

        bw.write(Sres + "\n" + Pres1 + " " + Pres2);

        bw.flush();
        bw.close();
    }
}