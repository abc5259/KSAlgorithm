package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import jdk.jfr.Unsigned;

public class BOJ_15829 {
    static int M = 1234567891;
    static double R = 31;
    static long answer = 0;
    static int DEDUCT = 96;
    static int L;
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine());
        input = br.readLine();

        char[] inputChar = input.toCharArray();
        for(int i=0; i<L; i++){
            int number = inputChar[i]-DEDUCT;
            answer += (number * Math.pow(R, i)) % M;
        }

        System.out.println(answer%M);
    }
}
