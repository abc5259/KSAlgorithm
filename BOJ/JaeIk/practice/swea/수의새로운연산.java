package BOJ.JaeIk.practice.swea;

import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수의새로운연산 {
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int sum1=0;
            int px = 0;
            int py = 0;
            for(int i=1; ; i++) {
                sum1 += i;
                if(sum1 >= p) {
                    px = i-(sum1-p);
                    py = i+1-px;
                    break;
                }
            }

            int sum2=0;
            int qx=0;
            int qy=0;
            for(int i=1; ; i++) {
                sum2 += i;
                if(sum2 >= q) {
                    qx = i-(sum2-q);
                    qy = i+1-qx;
                    break;
                }
            }

            int x = px+qx;
            int y = py+qy;
            int sum = 1;
            for(int i=1; i<x+y-1; i++) {
                sum+=i;
            }

            int answer = sum + x-1;
            System.out.println("#"+(tc+1)+" "+answer);

        }
    }
}
