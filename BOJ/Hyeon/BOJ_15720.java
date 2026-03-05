package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] order = new int[3];
        order[0] = Integer.parseInt(st.nextToken());
        order[1] = Integer.parseInt(st.nextToken());
        order[2] = Integer.parseInt(st.nextToken());

        int set = Math.min(Math.min(order[0], order[1]), order[2]);

        int sum = 0;
        int dis = 0;

        List<Integer>[] list = new ArrayList[3];

        for (int i = 0; i < 3; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < order[i]; j++) {
                int price = Integer.parseInt(st.nextToken());
                list[i].add(price);
                sum += price;
            }
        }

        for (int i = 0; i < 3; i++) {
            list[i].sort(Collections.reverseOrder());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < set; j++) {
                dis += list[i].get(j);
            }
        }

        System.out.println(sum);
        System.out.println((sum - dis) + dis * 9 / 10);

    }
}
// S5 카우버거 구현
// 11분
// 걍 풀었다 구현으로 쉽게 접근해서 set 메뉴라는 가장 최소 값을 입력받아서
// 각 햄버거 음료 사이드 별로 내림차순해서 set 까지의 반복문으로 할인된 가격을 총합을 구한다음
// 각 list 에 삽입할때 sum 으로 모든 가격을 입력받으면 그만.
// 자료구조를 인접 리스트 처럼 만들어서 3개의 배열로 관리하면서 Collections.sort의 reverseOrder()하니 끝임.