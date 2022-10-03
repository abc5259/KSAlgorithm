// 이분탐색 - boj.kr/2110 공유기 설치
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    static int N;
    static int C;
    static int[] houses;

    public static int binary_search(int start, int end) {
        int mid = (start + end) / 2;

        int iptime = 1;
        int previousHouse = houses[0];

        for (int i = 1; i < N; i++) {
            if ((houses[i] - previousHouse) >= mid) {
                previousHouse = houses[i];
                iptime += 1;
            }
        }

        if (start > end)
            return mid;
        else if (iptime >= C)
            return binary_search(mid + 1, end);
        else if (iptime < C)
            return binary_search(start, mid - 1);

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int interval = 1000000000;

        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        bw.write(binary_search(0, interval) + "\n");

        bw.flush();
        bw.close();
    }
}