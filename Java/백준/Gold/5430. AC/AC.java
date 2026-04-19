import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String func = br.readLine();

            int n = Integer.parseInt(br.readLine());
            Deque<Integer> arr = new ArrayDeque<>();

            String str = br.readLine();
            str = str.substring(1, str.length() - 1);
            StringTokenizer st = new StringTokenizer(str, ",");
            for (int j = 0; j < n; j++) {
                arr.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean isReverse = false, isBreak = false;
            for (int j = 0; j < func.length(); j++) {
                if (func.charAt(j) == 'R') {
                    isReverse = !isReverse;
                } else if (func.charAt(j) == 'D') {
                    if (arr.isEmpty()) {
                        sb.append("error").append("\n");
                        isBreak = true;
                        break;
                    }
                    if (isReverse) {
                        arr.removeLast();
                    } else {
                        arr.removeFirst();
                    }
                }
            }

            if (!isBreak && arr.isEmpty()) {
                sb.append("[]").append("\n");
                continue;
            } else if (!isBreak && isReverse == false) {
                sb.append("[");
                while (true) {
                    try {
                        sb.append(arr.removeFirst()).append(",");
                    } catch (Exception e) {
                        sb.deleteCharAt(sb.length() - 1).append("]\n");
                        break;
                    }
                }
            } else if (!isBreak && isReverse == true) {
                sb.append("[");
                while (true) {
                    try {
                        sb.append(arr.removeLast()).append(",");
                    } catch (Exception e) {
                        sb.deleteCharAt(sb.length() - 1).append("]\n");
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}