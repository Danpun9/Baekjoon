import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            ArrayList<Integer> arr = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            while (arr.size() != 2) {
                ArrayList<Integer> temp = new ArrayList<>();

                if (arr.size() % 2 == 0) {
                    for (int j = 0; j < arr.size() / 2; j++) {
                        temp.add(arr.get(j) + arr.get(arr.size() - 1 - j));
                    }
                } else {
                    for (int j = 0; j <= arr.size() / 2; j++) {
                        temp.add(arr.get(j) + arr.get(arr.size() - 1 - j));
                    }
                }
                arr = temp;
            }

            if (arr.get(0) > arr.get(1)) {
                sb.append("Case #").append(i).append(": Alice\n");
            } else {
                sb.append("Case #").append(i).append(": Bob\n");
            }
        }

        System.out.println(sb);
    }
}