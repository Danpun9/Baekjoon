import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = Integer.parseInt(br.readLine()); i > 0; i--) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;

            for (int j = 0; j < input.length(); j++) {
                try {
                    if (input.charAt(j) == '(') {
                        stack.push(input.charAt(j));
                    } else if (input.charAt(j) == ')') {
                        stack.pop();
                    }
                } catch (EmptyStackException e) {
                    isVPS = false;
                    break;
                }
            }

            if (stack.isEmpty() && isVPS) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}