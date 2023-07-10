package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17503 {
    static int N,M,K;
    static int[][] beerArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        beerArr = new int[K][2];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            beerArr[i][0] = Integer.parseInt(st.nextToken());
            beerArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(beerArr,(a,b) -> {
            if(a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });


        Queue<Integer> pq = new PriorityQueue<>();

        int total = 0;
        int answer = -1;
        for(int[] beer: beerArr) {
            pq.add(beer[0]);
            total += beer[0];

            if(pq.size() > N) {
                total -= pq.poll();
            }
            if(pq.size() == N && total >= M) {
                answer = beer[1];
                break;
            }
        }

        System.out.println(answer);
    }
    public static boolean check(long liverValue) {
        int sum = 0;
        int cnt = 0;
        for (int[] beer : beerArr) {
            if(cnt == N) break;
            if (beer[1] <= liverValue) {
                sum += beer[0];
                cnt++;
            }
        }
        if(cnt < N) return false;

        return sum >= M;

    }

}

//3 9 5
//2 5
//4 6
//3 3
//4 3
//1 4