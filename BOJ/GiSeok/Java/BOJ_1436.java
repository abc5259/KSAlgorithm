/**
 * 1436 - 영화감독 숌 [성공(알고리즘 분류 힌트)|00:31:37]
 * 실버5, 완전탐색, 시도1
 * 
 * 음.. N이 10,000이길래 숫자가 엄청 커진다 생각해서 무슨 규칙 같은게 있는 문제인줄 알았음..
 * 그냥 완전탐색 문제였다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = 666;
        for (int n = 1; n <= N; num++) {
            if (String.valueOf(num).contains("666")) n++;
        }

        System.out.println(num - 1);
    }
}
