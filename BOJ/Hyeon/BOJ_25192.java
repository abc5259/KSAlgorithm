package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        int res = 0;
        while (N-- > 0) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                res += set.size();
                set.clear();
            } else {
                set.add(str);
            }
        }
        res += set.size();

        System.out.print(res);
    }
}

// S4 인사성 밝은 곰곰이
// 문자열 입력단위로 새롭게 중복을 제거해야 했다. 이때 SET을 계쏙해서 만드려고 했는데
// 생각해보니까 Set.clear()를 쓰면됐엇다. 여러 Set을 받기위해 ArrayList<SET>을 생각했었는데
// 그냥 Set clear로 해서 이전까지의 개수를 저장해둔다음 계속해서 중복을 제거하는 단위마다 계산하고
// 마지막에 ENTER가 없으니까 반복문 끝에서도 남는 SET값을 더해주고 끝낸다.