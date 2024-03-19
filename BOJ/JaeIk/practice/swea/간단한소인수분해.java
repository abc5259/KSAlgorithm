package BOJ.JaeIk.practice.swea;

import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;


class 간단한소인수분해
{
    static int[] prime = {2, 3, 5, 7, 11};
    static BufferedReader br;
    public static void main(String args[]) throws Exception
    {

        br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        for(int tc=0; tc<input; tc++) {
            int number = Integer.parseInt(br.readLine());

            int[] answer = factorize(number);

            System.out.print("#"+(tc+1)+" ");
            for(int i=0; i<answer.length; i++) {
                System.out.print(answer[i]+" ");
            }
            System.out.println();
        }
    }

    static int[] factorize(int number) {
        int[] answer = new int[prime.length];

        while(number != 1) {
            for(int i=0; i<prime.length; i++) {
                if(number%prime[i]==0) {
                    answer[i]++;
                    number /= prime[i];
                }
            }
        }

        return answer;
    }
}


