package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_17140 {
    static int r, c, k;
    static int rowCnt = 3, colCnt = 3;
    static int maxRowCnt, maxColCnt;
    static int[][] map = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        while (map[r][c] != k && time <= 100) {
            if (rowCnt >= colCnt) {
                for (int i = 1; i <= rowCnt; i++)
                    R(i);
                colCnt = maxColCnt;
            } else {
                for (int i = 1; i <= colCnt; i++)
                    C(i);
                rowCnt = maxRowCnt;
            }
            time++;
        }
        System.out.println(time > 100 ? -1 : time);
    }

    public static void R(int row) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int col = 1; col <= colCnt; col++) {
            if (map[row][col] == 0) continue;
            hashMap.put(map[row][col], hashMap.getOrDefault(map[row][col], 0) + 1);
        }
        ArrayList<int[]> arr = new ArrayList<>(hashMap.size());
        hashMap.forEach((key, value) -> {
            arr.add(new int[]{key, value});
        });

        arr.sort((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int cnt = 0;
        int index = 1;

        for (int i = 0; i < arr.size(); i++) {
            if (index > 100) break;
            map[row][index] = arr.get(i)[0];
            cnt++;
            if (index + 1 > 100) break;
            map[row][index + 1] = arr.get(i)[1];
            cnt++;
            index += 2;
        }


        if (index < 101 && map[row][index] != 0) {
            while (map[row][index] != 0 && index < 101) {
                map[row][index] = 0;
                index++;
            }
        }

        if (cnt < colCnt) {
            for (int i = cnt + 1; i <= colCnt; i++) {
                map[row][i] = 0;
            }
        }
        maxColCnt = Math.max(maxColCnt, cnt);
    }

    public static void C(int col) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int row = 1; row <= rowCnt; row++) {
            if (map[row][col] == 0) continue;
            hashMap.put(map[row][col], hashMap.getOrDefault(map[row][col], 0) + 1);
        }

        ArrayList<int[]> arr = new ArrayList<>(hashMap.size());
        hashMap.forEach((key, value) -> {
            arr.add(new int[]{key, value});
        });

        arr.sort((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int cnt = 0;
        int index = 1;
        for (int i = 0; i < arr.size(); i++) {
            if (index > 100) break;
            map[index][col] = arr.get(i)[0];
            cnt++;
            if (index + 1 > 100) break;
            map[index + 1][col] = arr.get(i)[1];
            cnt++;
            index += 2;
        }

        if (cnt < rowCnt) {
            for (int i = cnt + 1; i <= rowCnt; i++) {
                map[i][col] = 0;
            }
        }
        maxRowCnt = Math.max(maxRowCnt, cnt);
    }
}
