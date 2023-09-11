package BOJ.JaeIk.retry;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816 {
    static long[] arr;
    static int n;

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
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            long in = Long.parseLong(st.nextToken());
            //값이 존재 할 때 idx1은 하한 바로 밑, idx2는 상한
            int idx1 = lower(in);
            int idx2 = upper(in);

            if(arr[idx2] == in){
                sb.append(idx2-idx1+1).append(" ");
            }
            else sb.append(0+" ");
        }
        System.out.println(sb);
    }

    static int lower(long in){
        //왜 -1일까
        //디버거 돌리면 알겠는데 와닿지않음
        int low = -1;
        int high = n;
        int mid;

        while(low+1 < high){
            mid = (low+high)/2;

            if(in <= arr[mid]){
                high = mid;
            }
            else{
                low = mid;
            }
        }
        return high;
    }

    static int upper(long in){
        int low = 0;
        int high = n;
        int mid;

        while(low+1 < high){
            mid = (low+high)/2;

            if(arr[mid] <= in){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
}
