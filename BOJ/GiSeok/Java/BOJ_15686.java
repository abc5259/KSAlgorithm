/**
 * 15686 - 치킨 배달 [성공|01:53:34]
 * 골드5, 완전탐색, 시도3
 * 
 * 완전탐색, 조합으로 풀 수 있는 문제였다.
 * 처음에 풀었던 방법은 치킨집 좌표를 저장해두고 map에서 2(치킨집)를 최대 M개까지 표시한 모든 경우의 수를 재귀적으로 탐색해 가장 작은 도시의 치킨 거리를 찾는 방법이었다.
 * 두 번째는 조합으로 모든 집과 치킨집의 좌표를 따로 담아두고, 치킨집 M개를 뽑는 모든 경우의 수를 배열에 담아 경우의 수마다의 집 마다의 거리 최솟값을 갱신하는 방법이다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
    // N*N
    // 도시의 각 칸은 빈 칸, 치킨집, 집
    // (r, c) r, c는 1부터 시작
    // "치킨거리" -> 집과 가장 가까운 치킨집 사이의 거리
    // M개의 치킨집을 N*N 도시에 적절히 배치해 가장 작은 도시의 치킨 거리를 찾는 문제
    // 도시의 치킨거리 = 모든 집의 치킨거리 합
    // 0: 빈 칸
    // 1: 집
    // 2: 치킨집

    static int[][] map;
    static ArrayList<Pair> _chicken = new ArrayList<>();
    static ArrayList<Pair> _home = new ArrayList<>();
    static ArrayList<Pair> _dist = new ArrayList<>();
    static int N, M;
    static int ret = Integer.MAX_VALUE;

    static class Pair {
        int x, y;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void combi(int r) {
        if (_dist.size() == M) {

            int mdist = 0;
            for (Pair p : _home) {
                int dist = 100;
                for (Pair c : _dist)
                    dist = Math.min(dist, Math.abs(c.x-p.x) + Math.abs(c.y-p.y));
                mdist += dist;
            }

            ret = Math.min(ret, mdist);
            return;
        }

        for (int i = r + 1; i < _chicken.size(); i++) {
            Pair p = _chicken.get(i);

            _dist.add(p);
            combi(i);
            _dist.remove(p);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 1) _home.add(new Pair(y, x));
                if (map[y][x] == 2) _chicken.add(new Pair(y, x));
            }
        }

        combi(-1);
        
        System.out.println(ret);
    }
}
