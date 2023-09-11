package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
    static int n,m;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            long n = Long.parseLong(st.nextToken());
            sb.append(bs(n)).append('\n');
        }

        System.out.println(sb);
    }

    static int bs(long n){
        int low = 0; int high = arr.length;
        int mid;

        while(low+1 < high){
            mid = (low+high)/2;

            if(n<arr[mid]){
                high = mid;
            }
            //조건문 이렇게 하면 출력이 안나옴 why??

            else if(n>arr[mid]){
                low = mid;
            }
        }

        return arr[low] == n ? 1 : 0;
    }
}
