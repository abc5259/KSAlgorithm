package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Ball[] cballs = new Ball[N+1];
        Ball[] balls = new Ball[N+1];
        balls[0] = new Ball(0,0);
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(color,size);
            balls[i].id = i;
            cballs[i] = balls[i];
        }

        Arrays.sort(balls,(a,b) -> {
            if(a.size == b.size) return a.color - b.color;
            return a.size - b.size;
        });

        int[] sum = new int[N+1];
        int count = 1;
        for(int i=1; i<=N; i++) {

            if(balls[i-1].size != balls[i].size) {
                if(count > 1) {
                    sum[i-1] += balls[i-1].size * count;
                    count = 1;
                }
                sum[i] += sum[i-1] + balls[i].size;
            }
            else {
                if(count == 1) sum[i-1] = sum[i-2];
                sum[i] = sum[i-1];
                count++;
            }
        }

        Map<Integer,Integer> hashMap = new HashMap<>();
        count = 1;
        for(int i=1; i<=N; i++) {
            if(balls[i-1].color == balls[i].color && balls[i-1].size == balls[i].size) {
                if(count == 1) {
                    hashMap.put(balls[i-1].color, hashMap.get(balls[i-1].color) - balls[i-1].size);
                }
                cballs[balls[i].id].result = cballs[balls[i-1].id].result;
                count++;
            }else {

                if(count > 1) {
                    hashMap.put(
                            balls[i-1].color,
                            hashMap.getOrDefault(balls[i-1].color,0) + balls[i-1].size * count);
                    count = 1;
                }

                int minus = hashMap.getOrDefault(balls[i].color,0);
                cballs[balls[i].id].result = sum[i-1] - minus;

                hashMap.put(balls[i].color, minus + balls[i].size);
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++) {
            sb.append(cballs[i].result).append("\n");
        }

        System.out.println(sb);

    }
    static class Ball {
        int color, size, id, result;

        public Ball(int color, int size) {
            this.color = color;
            this.size = size;
        }
    }
}
