package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class 쉬운거스름돈
{
    static int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    static BufferedReader br;
    public static void main(String args[]) throws Exception
    {
        br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        for(int tc=0; tc<input; tc++) {
            int money = Integer.parseInt(br.readLine());

            int[] answer = getAnswer(money);

            System.out.println("#"+(tc+1));
            for(int i=0; i<answer.length; i++) {
                System.out.print(answer[i]+" ");
            }
            System.out.println();
        }
    }

    static int[] getAnswer(int money) {
        int[] count = new int[unit.length];

        for(int i=0; i<unit.length; i++) {
            if(money/unit[i] > 0) {
                count[i] += money/unit[i];
                money %= unit[i];
            }
        }

        return count;
    }
}

