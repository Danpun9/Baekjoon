import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!((input = br.readLine()).equals("."))) {

            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;
            int i = 0;
            while (input.charAt(i) != '.') {
                if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                    stack.push(input.charAt(i));
                }
                try {
                    if (input.charAt(i) == ')') {
                        if (stack.pop() != '(') {
                            isVPS = false;
                            break;
                        }
                    } else if (input.charAt(i) == ']') {
                        if (stack.pop() != '[') {
                            isVPS = false;
                            break;
                        }
                    }
                } catch (EmptyStackException e) {
                    isVPS = false;
                    break;
                }
                i++;
            }

            if (stack.isEmpty() && isVPS) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}