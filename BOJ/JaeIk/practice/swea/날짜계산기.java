package BOJ.JaeIk.practice.swea;

import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;


class 날짜계산기
{
    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static BufferedReader br;
    public static void main(String args[]) throws Exception
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        for(int tc=0; tc<input; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int month1 = Integer.parseInt(st.nextToken());
            int day1 = Integer.parseInt(st.nextToken());
            int month2 = Integer.parseInt(st.nextToken());
            int day2 = Integer.parseInt(st.nextToken());

            System.out.println("#"+(tc+1)+" "+getAnswer(month1, day1, month2, day2));
        }
    }

    static int getAnswer(int month1, int day1, int month2, int day2) {
        int apart = 1;

        //사이에 있는 월의 날을 합한다
        for(int i=0; i<12; i++) {
            if(month1<i && i<month2) {
                apart += days[i-1];
            }
        }

        //month1월 day일 부터 month1+1월까지의 날을 합한다
        apart += (days[month1-1] - day1);

        //month2월 day2일 부터 month2월 마지막 날 까지의 날을 합한다
        if(month1 != month2) {
            apart += day2;
        }

        return apart;
    }
}

