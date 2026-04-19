import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[3];
        int a = -1;

        for (int i = 0; i < 3; i++) {
            try {
                arr[i] = Integer.parseInt(br.readLine());
                a = i;
            } catch (Exception e) {
                continue;
            }
        }

        boolean fizz = false;
        boolean buzz = false;

        if ((arr[a] + 3 - a) % 3 == 0)
            fizz = true;
        if ((arr[a] + 3 - a) % 5 == 0)
            buzz = true;

        if (fizz && buzz)
            bw.write("FizzBuzz");
        else if (fizz)
            bw.write("Fizz");
        else if (buzz)
            bw.write("Buzz");
        else
            bw.write(String.valueOf(arr[a] + 3 - a));

        bw.flush();
        bw.close();
        br.close();
    }
}