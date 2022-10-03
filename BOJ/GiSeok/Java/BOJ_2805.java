// 이분탐색 | boj.kr/2805 나무 자르기
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2805 {
    static int N;
    static int M;
    static int[] trees;
    
    public static long binary_search(long min, long max) {
        long mid = (min + max) / 2;

        long result = 0;
        long treeMiter = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > mid) {
                treeMiter = trees[i] - mid;
                result += treeMiter;
            }
        }

        if (min > max) {    // 조건 검사 전에 mid 먼저 계산하니까 max로 리턴안해도 됨
            return mid;
        } else if (result >= M) { // h low
            return binary_search(mid + 1, max);
        } else if (result < M) {
            return binary_search(min, mid - 1);
        }

        return -1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        long ans = binary_search(1, 2000000000L);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }
}
