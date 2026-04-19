import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] data = new int[9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = 0;
            for (int j = 0; j < n; j++) {
                k = Math.max(k, Integer.parseInt(st.nextToken()));
            }

            data[i] = k;
        }

        int res = 0;

        for (int i = 0; i < 9; i++) {
            if (data[res] < data[i]) {
                res = i;
            }
        }

        switch (res) {
            case 0:
                System.out.println("PROBRAIN");
                break;

            case 1:
                System.out.println("GROW");
                break;
            case 2:
                System.out.println("ARGOS");
                break;

            case 3:
                System.out.println("ADMIN");
                break;

            case 4:
                System.out.println("ANT");
                break;

            case 5:
                System.out.println("MOTION");
                break;

            case 6:
                System.out.println("SPG");
                break;

            case 7:
                System.out.println("COMON");
                break;

            case 8:
                System.out.println("ALMIGHTY");
                break;
            default:
                break;
        }
    }
}