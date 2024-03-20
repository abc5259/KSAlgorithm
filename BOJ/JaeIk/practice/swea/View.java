package BOJ.JaeIk.practice.swea;

import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;


class View
{
    static int[] prime = {2, 3, 5, 7, 11};
    static BufferedReader br;
    public static void main(String args[]) throws Exception
    {

        br = new BufferedReader(new InputStreamReader(System.in));


        for(int tc=0; tc<10; tc++) {
            int building = Integer.parseInt(br.readLine());

            int[] floor = new int[building];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<building; i++) {
                floor[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println("#"+(tc+1)+" "+getAnswer(floor));
        }
    }

    static int getAnswer(int[] floor) {
        int answer = 0;

        for(int i=2; i<floor.length-2; i++) {
            boolean flag = true;
            int maxFloor = Integer.MIN_VALUE;
            for(int j=i-2; j<=i+2; j++) {
                if(i==j)continue;
                if(maxFloor < floor[j])maxFloor=floor[j];
                if(floor[j] > floor[i])flag=false;
            }

            if(flag) {
                //System.out.println("디버깅 : "+i+" -"+(floor[i]-maxFloor));
                answer += (floor[i]-maxFloor);
            }
        }

        return answer;
    }
}


