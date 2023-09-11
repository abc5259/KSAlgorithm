package BOJ.JaeIk.retry;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
    static int[] arr;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int high = 0;
        int low = 0;
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, arr[i]);
        }

        while(low+1 < high){
            int mid = (low+high)/2;

            if(check(mid)){
                low = mid;
            }else{
                high = mid;
            }
        }

        System.out.println(low);
    }

    static boolean check(int mid){
        int sum=0;
        for(int i=0; i<N; i++){
            if(arr[i] <= mid)continue;
            sum += (arr[i]-mid);
        }
        return sum >= M;
    }
}
