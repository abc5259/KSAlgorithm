package BOJ.JaeIk.practice.swea;

import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;


class 지그재그숫자
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            int number = Integer.parseInt(br.readLine());
            int answer = jigjag(number);

            System.out.println("#"+(tc+1)+" "+answer);
        }

    }

    static int jigjag(int number) {
        int answer = 0;

        for(int i=1; i<=number; i++) {
            if(i%2 != 0) {
                answer += i;
            }else {
                answer -= i;
            }
        }

        return answer;
    }
}


