import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
                
            } else if (cmd.equals("pop")) {
                try {
                    sb.append(stack.pop()).append("\n");
                } catch (Exception e) {
                    sb.append("-1\n");
                }
                
            } else if (cmd.equals("size")) {
                sb.append(stack.size()).append("\n");
                
            } else if (cmd.equals("empty")) {
                if (stack.isEmpty())
                    sb.append("1\n");
                else
                    sb.append("0\n");
                
            } else if (cmd.equals("top")) {
                try {
                    sb.append(stack.peek()).append("\n");
                } catch (Exception e) {
                    sb.append("-1\n");
                }
            }
        }
        System.out.println(sb);
    }
}