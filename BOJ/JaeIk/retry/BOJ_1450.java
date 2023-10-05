package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1450 {
    static int N, C;
    static int[] weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        weight = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i< weight.length; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }
    }


}
