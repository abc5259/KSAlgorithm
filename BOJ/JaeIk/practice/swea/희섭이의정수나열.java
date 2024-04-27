package BOJ.JaeIk.practice.swea;

import java.io.IOException;
import java.util.Scanner;

public class 희섭이의정수나열 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=0; tc<T; tc++){
            int n = sc.nextInt();

            String str = "";
            for(int i=0; i<n; i++){
                str += sc.next();
            }

            int answer;
            for(int i=0; ;i++){
                if(!str.contains(Integer.toString(i))){
                    answer = i;
                    break;
                }
            }

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }
}
