package BOJ.JaeIk.practice.baekjoon;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class BOJ_1107
{
    static int target;
    static int number;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(br.readLine());
        number = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        if(number>0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<number; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int result = Math.abs(target-100);

        for(int i=0; i<=999999; i++) {
            String str = String.valueOf(i);

            boolean hasBroken = false;
            for(int j=0; j<str.length(); j++) {
                if(broken[str.charAt(j)-'0']) {
                    hasBroken = true;
                    break;
                }
            }

            if(!hasBroken) {
                //숫자 버튼 갯수 + 채널이동 수
                int min = str.length() + Math.abs(target-i);
                result = Math.min(result, min);
            }
        }

        System.out.print(result);
    }
}