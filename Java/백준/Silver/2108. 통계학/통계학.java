import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        sb.append((int) Math.round((double) sum / n)).append("\n");

        Arrays.sort(arr);

        sb.append(arr[n / 2]).append("\n");

        boolean flag = false;
        int mode_max = 0;
        int mode = 10000;

        for (int i = 0; i < n; i++) {
            int jump = 0;
            int count = 1;
            int i_value = arr[i];

            for (int j = i + 1; j < n; j++) {
                if (i_value != arr[j]) {
                    break;
                }
                count++;
                jump++;
            }

            if (count > mode_max) {
                mode_max = count;
                mode = i_value;
                flag = true;
            } else if (count == mode_max && flag == true) {
                mode = i_value;
                flag = false;
            }

            i += jump;
        }

        sb.append(mode).append("\n").append(arr[n - 1] - arr[0]);

        System.out.println(sb);
    }
}