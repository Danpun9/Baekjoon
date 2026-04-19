import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        if (x > 0) {
            if (y > 0) // x 양수 y 양수 1사분면
                System.out.println("1");
            else // x 양수 y 음수 4사분면
                System.out.println("4");
        } else {
            if (y > 0) // x 음수 y 양수 2사분면
                System.out.println("2");
            else // x 음수 y 음수 3사분면
                System.out.println("3");
        }
    }
}