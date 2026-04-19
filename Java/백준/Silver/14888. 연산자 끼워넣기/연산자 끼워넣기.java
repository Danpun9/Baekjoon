import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        num = new int[n];
        int[] operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, num[0], -1, operator);

        bw.write(max + "\n" + min);

        bw.close();
        br.close();
    }

    static void dfs(int idx, int res, int operator, int[] operatorList) {
        if (idx == n) {
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        int[] operatorListCopy = Arrays.copyOf(operatorList, 4);
        if (operator != -1) {

            if (operatorList[operator] == 0) {
                return;
            }

            switch (operator) {
                case 0: {
                    res += num[idx];
                    break;
                }
                case 1: {
                    res -= num[idx];
                    break;
                }
                case 2: {
                    res *= num[idx];
                    break;
                }
                case 3: {
                    res /= num[idx];
                    break;
                }
            }

            operatorListCopy[operator]--;
        }

        for (int i = 0; i < 4; i++) {
            dfs(idx + 1, res, i, operatorListCopy);
        }
    }
}