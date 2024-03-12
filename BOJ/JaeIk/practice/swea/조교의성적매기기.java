package BOJ.JaeIk.practice.swea;


import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class 조교의성적매기기
{
    static final String[] credit = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
    static final double MID_RATIO = 0.35;
    static final double FINAL_RATIO = 0.45;
    static final double ASSIGNMENT_RATIO = 0.2;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc=0; tc<T; tc++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            double[] scores = new double[n];
            int[] gpa = new int[n];

            for(int i=0; i<n; i++){
                int midterm = sc.nextInt();
                int finals = sc.nextInt();
                int assignment = sc.nextInt();

                //총 점수 계산
                double totalScore = getTotalScore(midterm, finals, assignment);
                scores[i] = totalScore;
            }

            String answer = getAnswer(scores, n, k);

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static String getAnswer(double[] scores, int n, int k){
        String answer=" ";
        double target = scores[k-1];
        Arrays.sort(scores);

        for(int i=0; i<n; i++){
            if(scores[i]==target){
                //System.out.println(i);
                answer = credit[i/(n/10)];
                break;
            }
        }

        return answer;
    }

    static double getTotalScore(int midterm, int finals, int assignment){
        return midterm*MID_RATIO + finals*FINAL_RATIO + assignment*ASSIGNMENT_RATIO;
    }
}