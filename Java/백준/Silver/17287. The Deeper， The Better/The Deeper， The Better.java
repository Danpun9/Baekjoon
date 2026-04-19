import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int res = Integer.MIN_VALUE, score = 0;

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') { // 여는 괄호면 score 더하기
                if (c == '(')
                    score += 1;
                else if (c == '{')
                    score += 2;
                else if (c == '[')
                    score += 3;

            } else if (c == ')' || c == '}' || c == ']') { // 닫는 괄호면 score 빼기
                if (c == ')')
                    score -= 1;
                else if (c == '}')
                    score -= 2;
                else if (c == ']')
                    score -= 3;

            } else { // 숫자면 현재 score랑 가장 높았던 점수랑 비교
                res = Math.max(score, res);
            }
        }

        bw.write(res + "\n");

        bw.close();
        br.close();
    }
}
