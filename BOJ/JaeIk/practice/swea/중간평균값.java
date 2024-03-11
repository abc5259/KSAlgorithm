package BOJ.JaeIk.practice.swea;

import java.util.Scanner;
class 중간평균값
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int tc=0; tc<T; tc++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;

            for(int i=0; i<10; i++){
                int number = sc.nextInt();

                if(max<number)max = number;
                if(min>number)min = number;
                sum += number;
            }

            long answer = Math.round((sum-max-min)/8.0);

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }
}
