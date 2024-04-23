package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 태혁의사랑은타이밍 {
    static int promiseTime = 1440*11 + 60*11 + 11;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int WaitingTime = inputToMin(D, H, M) - promiseTime;

            int answer = (WaitingTime>=0)?WaitingTime:-1;

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static int inputToMin(int D, int H, int M){
        return 1440*D + 60*H + M;
    }
}
