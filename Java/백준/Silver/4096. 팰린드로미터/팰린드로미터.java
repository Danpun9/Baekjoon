import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();

            if (str.equals("0")) {
                break;
            }

            int num = Integer.parseInt(str);

            int res = 0;
            while (!isPal(str.length(), num)) {
                num++;
                res++;
            }

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isPal(int l, int n) {
        String str = Integer.toString(n);
        while (str.length() != l) {
            str = "0" + str;
        }

        for (int i = 0; i < l / 2; i++) {
            if (str.charAt(i) != str.charAt(l - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}