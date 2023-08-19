package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);


        int left = 0;
        int right = n-1;
        int ans = 0;
        while(left<right){
            int sum = arr[left] + arr[right];

            if(sum==x){
                ans++;
                left++;
                right--;
            }
            else if(sum>x){
                right--;
            }
            else if(sum<x){
                left++;
            }
        }

        System.out.println(ans);
    }
}
