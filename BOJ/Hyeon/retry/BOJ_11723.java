package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int S = 0;

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int x;
            switch (str) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    S |= 1 << x;
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    S &= ~(1 << x);
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    S ^= 1 << x;
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append(((S & 1 << x) == 0) ? 0 : 1).append("\n");
                    break;
                case "all":
                    S |= (1 << 21) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
// 시간 초과를 대비해 비트마스킹으로 푼다. 1 << 21 - 1을 한 이유는 1<< 1햇을 때 이진수로 10이 나오지만 1을 추가한거라고
// 생각하기 위해서 초기값 0일 때 1 << 1을 하면 1이 추가가되기위해 1 << 0이 되어야 하는것을 방지하고자
// 1칸식 더 추가하여서 0에서 1 << 0을 했을 때 0의 값으로 판단하고 1 << 1을 하면 1임을 받아들인다.
// 그렇기 때문에 해당 조건에 있을 때 비트 연산시 입력값 그대로 쉬프트 연산을 할 수 있다.
// add는 있으면 그대로 없으면 추가인데 비트연산과 생각해보면 S에 있으면(==1)일 때 입력값도 1일 테니 무조건 1이고
// 없어도 1이 나오기 하기 위해 or 연산을 통해 가지고 있는 값과 상관없이 1을 만든다.
// remove의 경우 입력한 값이 있을경우 0으로 없어도 0으로 하는데 비트 연산을 통해 항상 0을 만드는건 없어서 이를 ~연산을 통해 and를 사용한다.
// and의 경우 1 1일 때만 1을 만들기 때문에 지우는 경우 1일 때도 0 0일 때도 0을 만들기 위해서 입력값을 NOT연산으로 0으로 만든다.
// toggle의 경우 있으면 0으로 없으면 1로 인데 이는 XOR 연산과 유사하여 입력값은 항상 1이고 S에 존재하면 0이되고 안하면 1이 되기위해 XOR사용
// check 의 경우 현재 S와 입력값 x의 1<< x 연산에서 둘다 존재하면 1을 출력 존재 안하면 0출력인데,
// &연산을 해서 0이 나오면 존재하지 않는다는 의미이므로 0을 출력하면된다.