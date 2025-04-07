package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] input = new int[N];
        int[][] res = new int[M][N];

        List<Integer> sorted = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank, count = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sorted.clear();
            map.clear();

            for (int j = 0; j < N; j++) {
                input[j] = Integer.parseInt(st.nextToken());
                sorted.add(input[j]);
            }

            Collections.sort(sorted);

            rank = 0;
            for (int j = 0; j < N; j++) {
                if (!map.containsKey(sorted.get(j))) {
                    map.put(sorted.get(j), rank++);
                }
            }

            for (int j = 0; j < N; j++) {
                res[i][j] = map.get(input[j]);
            }

            for (int p = 0; p < i; p++) {
                if (check(res[i], res[p])) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean check(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}

// G5 멀티버스 2 좌표 압축
// 기존의 배열 input과 res는 최종값을 비교할 2차원 배열
// 그리고 리스트와 해쉬맵을 이용한다. 리스트는 정렬조건 해쉬맵은 키를 포함하고 있다면 인덱스를 만들어주기 위해서이다
// 만약 같은 크기가 있을경우 바뀌면안된다. 그리고 map에 전달한다.