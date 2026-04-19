import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
    
        int T;
        T = scanner.nextInt();
        
        int[] x1 = new int[T];
        int[] y1 = new int[T];
        int[] r1 = new int[T];
        int[] x2 = new int[T];
        int[] y2 = new int[T];
        int[] r2 = new int[T];

        for (int i = 0; i < T; i++){
            x1[i] = scanner.nextInt();
            y1[i] = scanner.nextInt();
            r1[i] = scanner.nextInt();
            x2[i] = scanner.nextInt();
            y2[i] = scanner.nextInt();
            r2[i] = scanner.nextInt();
        }

        for (int i = 0; i < T; i++){
            double xd = Math.pow(x1[i]-x2[i], 2);
            double yd = Math.pow(y1[i]-y2[i], 2);
            double d = Math.sqrt(xd+yd);
            // distance = √(x1 - x2)^2 + (y1 - y2)^2 거리계산

            int result = resBranch(d, r1[i], r2[i]);
            System.out.println(result);
        }
    }

    public static int resBranch(double d, int r1, int r2) { // 결과 분기 함수
        if (d == 0) { // 좌표 같음
            if (r1 == r2) return -1; // 같은 원
            else return 0; // 반지름이 다른 동심원
        }
        else { // 좌표 다름
            if (r1 + r2 == d) return 1; // 외접
            else if (Math.abs(r1 - r2) == d) return 1; // 내접
            else if (r1 + r2 < d) return 0; // 밖에서 닿지 않음
            else if (Math.abs(r1 - r2) < d && d < r1 + r2) return 2; // 안에서 닿지 않음
            return 0; 
        } 

    }
}