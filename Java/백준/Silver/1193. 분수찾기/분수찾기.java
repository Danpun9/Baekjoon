import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int Y = 1;
        while (X > Y) {
            X -= Y;
            Y++;
        }

        if (Y % 2 == 0)
            Y = Y - X + 1;

        else if (Y % 2 == 1) {
            int temp = X;
            X = Y - temp + 1;
            Y = temp;
        }

        String res = X + "/" + Y;
        bw.write(res);
        bw.flush();
        bw.close();
    }
}
