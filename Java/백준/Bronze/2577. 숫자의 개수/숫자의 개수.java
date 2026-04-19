import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        a = a * b * c;

        int[] res = new int[10];
        while (a != 0) {
            res[a % 10]++;
            a /= 10;
        }

        for (int i : res) {
            System.out.println(i);
        }
    }
}