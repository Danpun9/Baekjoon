import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = Integer.parseInt(br.readLine()); i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(st.nextToken());

            switch (select) {
                case 1:
                    int X = Integer.parseInt(st.nextToken());
                    deque.addFirst(X);
                    break;
                case 2:
                    X = Integer.parseInt(st.nextToken());
                    deque.addLast(X);
                    break;
                case 3:
                    try {
                        sb.append(deque.removeFirst()).append("\n");
                    } catch (Exception e) {
                        sb.append(-1).append("\n");
                    }
                    break;
                case 4:
                    try {
                        sb.append(deque.removeLast()).append("\n");
                    } catch (Exception e) {
                        sb.append(-1).append("\n");
                    }
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if (deque.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case 7:
                    try {
                        sb.append(deque.getFirst()).append("\n");
                    } catch (Exception e) {
                        sb.append(-1).append("\n");
                    }
                    break;
                case 8:
                    try {
                        sb.append(deque.getLast()).append("\n");
                    } catch (Exception e) {
                        sb.append(-1).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}