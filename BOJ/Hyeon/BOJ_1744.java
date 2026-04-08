package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BOJ_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1이하인 애들은 하면안되고
        // 2이상인애들은 맨 큰수부터 2개씩?

        List<Integer> plus = new LinkedList<>();
        List<Integer> minus = new LinkedList<>();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 1) {
                sum += 1;
            } else if (num > 1) {
                plus.add(num);
            } else {
                minus.add(num);
            }
        }

        Collections.sort(plus, Collections.reverseOrder());

        Collections.sort(minus);

        sum += calculate(plus);
        sum += calculate(minus);

        System.out.println(sum);
    }

    static int calculate(List<Integer> list) {
        int tmp = 0;
        while (list.size() > 1) {
            tmp += list.get(0) * list.get(1);
            list.remove(0);
            list.remove(0);
        }

        if (!list.isEmpty()) {
            tmp += list.get(0);
        }
        return tmp;
    }
}
// G4 수 묶기 그리디
// 40분
// 일단 풀었다.
// 그리디로 최적의 경우의 수를 고려했을 때 양수는 내림차순으로 정렬해서 짝수개일 경우 곱해서 더하고 홀수개일 경우 맨 마지막꺼만 따로 더한다
// 이때 1은 곱해봤자 도움이 안되기때문에 1이 만약 입력으로 주어진다면 일단 더하고 plus 리스트에 안넣는다.
// 그리고 음수의 경우도 가장 작은 수 끼리 곱해야 큰 양수가 되기에 오름차순으로 정렬해서
// plus 와 같은 맥락이라 calculate 메소드를 만들어서 list 를 입력받아
// 짝수일 경우 while 로 처리하고 홀수이면 if 조건문 1개로 0번 인덱스를 더한다
// 더하는 즉시 0 인덱스를 삭제시켜서 list 를 비운다.