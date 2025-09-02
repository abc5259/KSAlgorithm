package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append(Integer.parseInt(st.nextToken())).append(" ");

            int[] students = new int[21];

            int sum = 0;
            for (int i = 1; i < students.length; i++) {
                int height = Integer.parseInt(st.nextToken());
                for (int j = i - 1; j >= 0; j--) {
                    if (students[j] > height) {
                        students[j + 1] = students[j];
                        sum++;
                    } else {
                        students[j + 1] = height;
                        break;
                    }
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}

// S5 줄세우기 구현
// 삽입정렬 써서 했다. 현재 타겟의 숫자와 이전 위치의 원소 비교해서
// 타겟 숫자가 더 작으면 이전 인덱스를 오른쪽으로 한칸 밀고 그러다가 만약 현재 값보다 작은게 나올 경우
// 그 인덱스에 현재 값을 삽입한다.
// 계속 민다고 생각하면된다 삽입하기 위해서 뒤로 민다. 오름차순
// sum 은 그 미는 횟수이고