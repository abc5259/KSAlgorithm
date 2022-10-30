// 그리디 - boj.kr/1541 잃어버린 괄호
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        String[] exps;
        int sum = 0;

        exps = exp.split("\\-");

        for (int i = 0; i < exps.length; i++) {
            int add = 0;
            for (String s : exps[i].split("\\+"))
                add += Integer.parseInt(s);

            if (i > 0)
                sum += (-add);
            else
                sum += add;
        }

        System.out.println(sum);
    }
}