package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    static long low, mid, high, sum, max;
    static long[] arr;
    static int k, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        arr = new long[k];
        for(int i=0; i<k; i++){
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        /*
         * 가장 긴 랜선이 800인 경우
         * 정답(low)가 800일 수 있기 때문에
         * 정답의 범위를 나타내기 위해
         * high = 800 + 1로 초기화 해야한다
         */
        low = 1;
        high = max+1;

        binarySearch();

        System.out.println(low);
    }
    static boolean check(long mid){
        for(long length : arr){
            sum += length/mid;
        }
        return sum >= n;
    }

    static void binarySearch(){
        while(low+1 < high){
            sum = 0;
            mid = (low+high)/2;

            if(check(mid))low = mid;
            else high = mid;
        }
    }
}