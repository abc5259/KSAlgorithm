package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class BOJ_1541
{
    static String[] sub;
    static String[] add;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sub = br.readLine().split("-");

        int sum = Integer.MAX_VALUE;
        for(int i=0; i<sub.length; i++) {
            int temp = 0;

            add = sub[i].split("\\+");

            for(int j=0; j<add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }

            if(sum == Integer.MAX_VALUE) {
                sum = temp;
            }else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}