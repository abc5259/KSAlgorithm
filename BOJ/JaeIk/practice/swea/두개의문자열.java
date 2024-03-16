package BOJ.JaeIk.practice.swea;

import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;


class 두개의문자열
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length1 = Integer.parseInt(st.nextToken());
            int length2 = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[length1];
            int[] arr2 = new int[length2];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<length1; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<length2; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            int[] big;
            int[] small = getMinLength(arr1, arr2);
            if(arr1 == small) {
                big = arr2;

            }else {
                big = arr1;
            }




            int answer = getAnswer(small, big);

            System.out.println("#"+(tc+1)+" "+answer);
        }

    }

    static int getAnswer(int[] small, int[] big) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<big.length-small.length+1; i++) {

            int sum = 0;
            int idx = 0;
            for(int j=i; j<i+small.length; j++) {
                if(idx<small.length) {
                    int a = small[idx++];
                    int b = big[j];
                    //System.out.println(idx+" "+j+" "+a*b);
                    sum += a*b;

                }
            }


            if(max < sum)max = sum;
        }

        return max;
    }

    static int[] getMinLength(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        if(length1 > length2)return arr2;
        else return arr1;
    }
}


