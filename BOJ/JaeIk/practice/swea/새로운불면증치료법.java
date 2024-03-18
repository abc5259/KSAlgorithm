package BOJ.JaeIk.practice.swea;

import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;


class 새로운불면증치료법
{
    static int[] visited;
    static BufferedReader br;
    public static void main(String args[]) throws Exception
    {

        br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        for(int tc=0; tc<input; tc++) {
            int number = Integer.parseInt(br.readLine());
            visited = new int[10];

            System.out.println("#"+(tc+1)+" "+getAnswer(number)*number);
        }
    }

    static int getAnswer(int number) {
        boolean flag = false;
        int count = 1;

        while(!flag) {
            int temp = number * count;
            String numberStr = String.valueOf(temp);
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<numberStr.length(); i++) {
                //0아스키 코드를 빼서 각 자리를 정수형으로 변환
                int digit = numberStr.charAt(i)-'0';
                //System.out.println("디버깅 : "+digit);
                if(visited[digit]==0)visited[digit]=1;
            }
            //System.out.println();

            int sum = 0;
            for(int j=0; j<10; j++) {
                sum += visited[j];
            }

            if(sum != 10) {
                count++;
            }else {
                flag = true;
            }

        }

        return count;
    }
}


