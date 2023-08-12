package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_23254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int totalTime = N * 24;

        st = new StringTokenizer(br.readLine());
        Exam[] exams = new Exam[M];
        for(int i=0; i<M; i++) {
            int score = Integer.parseInt(st.nextToken());
            exams[i] = new Exam();
            exams[i].score = score;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int add = Integer.parseInt(st.nextToken());
            exams[i].add = add;
        }

        PriorityQueue<Exam> pq = new PriorityQueue<>((a,b) -> {
            if(a.add == b.add) return a.score - b.score;
            return b.add - a.add;
        });
        for(int i=0; i<M; i++) {
            pq.offer(exams[i]);
        }

        int result = 0;
        while (totalTime > 0 && !pq.isEmpty()) {
            Exam exam = pq.poll();

            int needTime = (100 - exam.score) / exam.add;

            if(needTime <= totalTime) { //시간이 충본하면
                int score = exam.score + needTime * exam.add;
                totalTime -= needTime;
                if(score < 100) { //100점을 넘지 않으면 다시 덯기
                    Exam newExam = new Exam();
                    newExam.score = score;
                    newExam.add = 100 - score;
                    pq.offer(newExam);
                }else { //100점을 넘으면 끝
                    result += 100;
                }
            }else { //시간이 충분하지 않으면
                int score = exam.score + totalTime * exam.add;
                totalTime = 0;
                Exam newExam = new Exam();
                newExam.score = score;
                pq.offer(newExam);
            }
        }

        while (!pq.isEmpty()) result += pq.poll().score;

        System.out.println(result);

    }
    static class Exam {
        int score,add;
    }
}
