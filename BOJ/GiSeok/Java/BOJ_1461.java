package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] coordinate = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            coordinate[i] = Integer.parseInt(st.nextToken());
        coordinate[N] = 0;
        Arrays.sort(coordinate);

        int zeroIdx = 0;
        for (int i = 0; i < coordinate.length; i++) {
            if (coordinate[i] == 0) {
                zeroIdx = i;
                break;
            }
        }

        int maxIdx = Math.abs(coordinate[0]) > coordinate[coordinate.length-1] ? 0 : coordinate.length-1; 

        int ans = Math.abs(coordinate[maxIdx]);
        for (int i = 0; i < zeroIdx; i+=M) {
            if (i == maxIdx) continue;
            ans += (Math.abs(coordinate[i]) * 2);
        }

        for (int i = coordinate.length-1; i > zeroIdx; i-=M) {
            if (i == maxIdx) continue;
            ans += (coordinate[i] * 2);
        }

        System.out.println(ans);
    }
}