package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2539 {
    static int row, col, paper, wrong;
    static int[][] mistake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        paper = Integer.parseInt(br.readLine());
        wrong = Integer.parseInt(br.readLine());

        mistake = new int[wrong][2];
        for (int i = 0; i < wrong; i++) {
            st = new StringTokenizer(br.readLine());
            mistake[i][0] = Integer.parseInt(st.nextToken());
            mistake[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(mistake, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        System.out.println(lowerBound(Math.min(row, col)));
    }

    static int lowerBound(int max) {
        int lo = 0;
        int hi = max;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }

    static boolean check(int var) {
        // var 보다 높은 행의 경우 그냥 아묻따 false
        for (int i = 0; i < wrong; i++) {
            if (mistake[i][0] > var) {
                return false;
            }
        }

        // 모자이크가 색종이 크기보다 작을 때
        int cnt = 0;
        int row = 1;

        for (int[] point : mistake) {
            if (row <= point[1]) {
                row = point[1] + var;
                cnt++;
            }
        }
        return cnt <= paper;
    }
}
// G4 모자이크 이분탐색 + 그리디
// 58분
// 일단 구하고자 하는게 색종이의 개수도 아니고 색종이의 길이이다 색종이는 정사각형이고
// 조건이 밑변에서 고정이기 때문에 바로 생각할 수 있는게 색종이의 길이가 1이면 모자이크 개수일텐데
// 주어진 종이 즉 paper 보다 갯수가 많아질 거기 때문에 이러면 F 가 된다
// 그러면 색종이의 길이를 늘리면 색종이의 개수가 줄어들어 T가 돼서
// FFFF TTTT 의 결정 문제라고 생각했다
// 그래서 lowerBound로 설정해서 했고 hi값을 리턴하고 lo가 익스클루시브여야되기에 색종이길이가 0인것을 lo
// 그리고 색종이의 길이는 row 와 col의 최소값과 같아야 하기에 이를 hi 값으로 설정했따

// 그런데 주어진 입력값이 행과 열이 100만이라 이를 시간복잡도와 공간복잡도를 고려해야했고
// N^2으로 탐색하면 시간초과일 거 같아서 고민하다가 mistake 배열로 따로 빼서 만들었다
// check 함수가 제일 까다로웠는데
// 일단 색종이의 길이보다 높은 행의 경우 무조건 안되기에 false 를 리턴하고
// 또 모자이크들을 이제 열정렬을 통해서 순차적으로 처리했다.
// 색종이의 길이보다 괜찮으면 그리디를 통해서 cnt 로 색종이의 개수를 세고 row 로 현제 x 좌표를 계산하여
// 최종적으로 cnt 의 개수가 paper 보다 적으면 가능했다.