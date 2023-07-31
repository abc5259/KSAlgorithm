package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
    static int n, m;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 10000;

        while(low+1 < high){
            int mid = (low+high)/2;

            if(check(mid))low=mid;
            else high=mid;
        }
        System.out.println(low);

    }

    static Boolean check(int mid){
        long sum = 0;
        for(int i=0; i<n; i++){
            if(arr[i]>mid)sum += arr[i]-mid;
        }
        return sum>=m;
    }
}
