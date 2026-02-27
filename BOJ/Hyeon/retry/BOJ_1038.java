package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1038 {
    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N >= 1023) {
            System.out.println(-1);
            return;
        }

        list = new ArrayList<>();

        for (int i = 0; i <= 9; i++) {
            dfs(i);
        }

        Collections.sort(list);

        System.out.println(list.get(N));
    }

    static void dfs(long num) {
        list.add(num);

        long last = num % 10;

        for (int i = 0; i < last; i++) {
            dfs(num * 10 + i);
        }
    }
}
// G5 감소하는 수 DFS
// 55분
// 일단 자릿수가 9876543210 으로 인해서 0부터 9까지 수에 있어서 1개부터 10개까지 선택을 한 결과가
// 내림차로 정해진다고 가정하면 부분집합의 개수와 같다 10개중 1개에서 10개를 뽀ㅃ는 부분집합의 개수는 총 공집합을
// 제외한 2의 10승 - 1이다 근데 0은 0번째라서 9876543210 은 1022 번째라서
// N이 1023보다 크거나 같으면 기저사례로 탈출한다
// 그다음 dfs 를 통해서 재귀로 값을 가질껀데 0부터 시작해서 9까지 시작할 수 있는 숫자에 대해서
// 해당 숫자부터 dfs 를 태워서
// 0이 입력되면 0의 나머지 값보다 작은 값이 뒤로 이어질 수 있다 얘를들어 9로 시작한다면 9가 첫 마지막 숫자라서
// 0부터 8까지 올 수 있고 그다음 8이 온다면 0부터 7 이런식으로 재귀로 DFS 할수있고 해당하는 수들은 모두
// list 에 등록돼서
// i가 0이면 0, i가 1이면 1, 10 i가 2면 2가 들어오고 20 , 21, 210 까지 3개가 된다. 이를 오름차 정렬을 해버리면
// 숫자별로 N개의 수를 담당해서 0이 0번째가 되고 1이 1번째가 돼서 N의 인덱스를 접근해서 출력한다.