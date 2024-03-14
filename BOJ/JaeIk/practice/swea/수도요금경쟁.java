package BOJ.JaeIk.practice.swea;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

import java.util.Scanner;
import java.io.FileInputStream;


class 수도요금경쟁
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc=0; tc<T; tc++) {
            int P = sc.nextInt();
            int Q = sc.nextInt();
            int R = sc.nextInt();
            int S = sc.nextInt();
            int W = sc.nextInt();

            int A_Fee = getAFee(P, W);
            int B_Fee = getBFee(Q, R, S, W);

            int answer = (A_Fee > B_Fee)?B_Fee : A_Fee;

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static int getAFee(int P, int W) {
        return W*P;
    }

    static int getBFee(int Q, int R, int S, int W) {
        int fee = 0;

        if(W <= R) {
            fee = Q;
        }else {
            fee = Q + (W-R)*S;
        }

        return fee;
    }
}