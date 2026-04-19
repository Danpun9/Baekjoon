import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[3];
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(br.readLine());
            sum += a[i];
        }

        if (sum == 180) {
            if (a[0] == 60 && a[1] == 60 && a[2] == 60)
                System.out.println("Equilateral");
            else if (a[0] == a[1] || a[1] == a[2] || a[2] == a[0])
                System.out.println("Isosceles");
            else
                System.out.println("Scalene");
        } else
            System.out.println("Error");
    }
}
