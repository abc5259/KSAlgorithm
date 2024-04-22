package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 한빈이와SpotMart {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max=0;
            int sum=0;

            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    sum = arr[i]+arr[j];
                    if(sum<=m && max<sum)max=sum;
                }
            }

            if(max==0)System.out.println("#"+(tc+1)+" "+-1);
            else System.out.println("#"+(tc+1)+" "+max);
        }
    }
}

