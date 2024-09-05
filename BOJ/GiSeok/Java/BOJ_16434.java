/**
 * 16434 - 드래곤 앤 던전 [성공|00:41:50]
 * 골드4, 이분탐색, 시도2
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16434 {
    // 시간제한 1초, 메모리제한 256MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        long[][] dungeon = new long[n][3];
        long high = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                dungeon[i][j] = Integer.parseInt(st.nextToken());
                if (dungeon[i][0] == 1) high += (dungeon[i][1] * ((dungeon[i][2] / h) + 1));
            }
        }

        long low = 0;

        while (low + 1 < high) {
            long mid = (low + high) / 2;

            long atk = h;
            long hp = mid;
            for (int i = 0; i < n; i++) {
                if (dungeon[i][0] == 1) {
                    long cnt = 0;
                    if (dungeon[i][2] - atk <= 0) continue;
                    cnt = (dungeon[i][2] - atk) / atk;
                    if ((dungeon[i][2] - atk) % atk != 0) cnt++;

                    hp -= (cnt * dungeon[i][1]);

                    if (hp <= 0) break;
                } else {
                    atk += dungeon[i][1];
                    hp += dungeon[i][2];
                    if (hp > mid) hp = mid;
                }
            }

            if (hp > 0) high = mid;
            else low = mid;
        }

        System.out.println(high);
    }
}
