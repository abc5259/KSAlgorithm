package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11501 {
    public static void main(String[] args) throws IOException {
        //8:44
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] stockArr = new int[N];
            for(int i=0; i<N; i++) {
                stockArr[i] = Integer.parseInt(st.nextToken());
            }

            long money = 0;

            int max = 0;
            for(int i=N-1; i>=0; i--) {
                if(stockArr[i] > max) {
                    max = stockArr[i];
                }else {
                    money += max - stockArr[i];
                }
            }

            sb.append(money+"\n");
        }
        System.out.println(sb);
    }
}
