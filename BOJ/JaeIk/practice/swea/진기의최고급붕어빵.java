package BOJ.JaeIk.practice.swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class 진기의최고급붕어빵
{
    static int[] arr;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if(max<arr[i])max=arr[i];
            }
            Arrays.sort(arr);
            String answer = (isPossible(n, m, k, max))?"Possible":"Impossible";
            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static boolean isPossible(int n, int m, int k, int max) {
        int count = 0;

        int idx = 0;
        for(int j=0; j<=max; j++) {
            if(j!=0 && j%m == 0) {
                count += k;
            }
            //System.out.println("만든붕어빵 : "+count+" ,"+j+"초");

            if(j==arr[idx]){
                idx++;
                if(--count<0)return false;
            }
            //System.out.println("남은붕어빵 : "+count+" ,"+j+"초");
        }

        return true;
    }
}
