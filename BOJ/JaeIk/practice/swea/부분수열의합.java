package BOJ.JaeIk.practice.swea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class 부분수열의합
{
    static int n, k;
    static int count;
    static int[] arr;
    static boolean[] visited;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];
            visited = new boolean[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            count = 0;

            dfs(0, 0);

            System.out.println("#"+(tc+1)+" "+count);
        }
    }

    static void dfs(int sum, int idx) {

        if(sum > k)return;

        if(sum == k) {
            count++;
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(!visited[i] && i>=idx) {
                sum += arr[i];
                visited[i] = true;

                dfs(sum, i);

                sum -= arr[i];
                visited[i] = false;
            }
        }
    }

}
