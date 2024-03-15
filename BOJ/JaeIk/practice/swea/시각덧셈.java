package BOJ.JaeIk.practice.swea;

import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;


class 시각덧셈
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hour1 = Integer.parseInt(st.nextToken());
            int min1 = Integer.parseInt(st.nextToken());
            int hour2 = Integer.parseInt(st.nextToken());
            int min2 = Integer.parseInt(st.nextToken());

            int hour = hour1 + hour2;
            int min = min1 + min2;

            if(hour>12) {
                hour -= 12;
            }

            if(min>59) {
                hour++;
                min = min-60;
            }

            System.out.println("#"+(tc+1)+" "+hour+" "+min);
        }

    }


}