package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {
    static int[] card;
    static int[] own;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        own = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            own[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(own);

        int m = Integer.parseInt(br.readLine());
        card = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            sb.append(search(0, n-1, card[i])).append(" ");
        }

        System.out.println(sb);
    }

    static int search(int low, int high, int number){
        int mid;

        if(low<=high){
            mid = (low+high)/2;

            if(number == own[mid])return 1;
            else if(number<own[mid]){
                return search(low, mid-1, number);
            }
            else {
                return search(mid+1, high, number);
            }
        }

        return 0;
    }
}
