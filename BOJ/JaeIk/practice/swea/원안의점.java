package BOJ.JaeIk.practice.swea;

import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;


class 원안의점
{
    static BufferedReader br;
    public static void main(String args[]) throws Exception
    {

        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            int number = Integer.parseInt(br.readLine());
            System.out.println("#"+(tc+1)+" "+getAnswer(number));
        }
    }

    static int getAnswer(int number) {
        int answer=0;

        for(int i=-number; i<=number; i++) {
            for(int j=-number; j<=number; j++) {
                if(i*i + j*j <= number*number)answer++;
            }
        }

        return answer;
    }
}

