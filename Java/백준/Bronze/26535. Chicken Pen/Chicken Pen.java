import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int size = 1;
        while (size * size < n) {
            size++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size + 2; i++) {
            sb.append("x");
        }
        sb.append("\n").append("x");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(".");
            }
            sb.append("x").append("\n").append("x");
        }

        for (int i = 0; i < size + 1; i++) {
            sb.append("x");
        }

        System.out.println(sb);
    }
}
