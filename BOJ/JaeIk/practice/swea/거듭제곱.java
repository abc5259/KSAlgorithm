package BOJ.JaeIk.practice.swea;
import java.util.Scanner;

public class 거듭제곱 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int tc=0; tc<10; tc++){
            scanner.nextInt();
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            System.out.println("#"+(tc+1)+" "+getAnswer(n, m));
        }
        scanner.close();
    }

    static long getAnswer(int n, int m){
        if(m==1) return n;
        return n * getAnswer(n, m-1);
    }
}