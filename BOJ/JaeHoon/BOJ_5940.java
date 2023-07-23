package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5940 {
    static int N;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int k = 0;
        int word = 3;
        int length = 3;
        while (length < N) {
            length = length + word+1 + length;
            word++;
            k++;
        }
        fun(k,length);
    }
    public static void fun(int k,int size) {
        int wordSize = k+3;
        int prevWordSize = (size - wordSize) / 2;
        if(prevWordSize + wordSize >= N) {
            N -= prevWordSize;
            if(N == 1) System.out.println("m");
            else System.out.println("o");
            System.exit(0);
        }
        N = N - (prevWordSize+wordSize);
        int newK = 0;
        int word = 3;
        int length = 3;
        while (length < N) {
            length = length + word+1 + length;
            word++;
            newK++;
        }
        fun(newK,length);
    }
}
