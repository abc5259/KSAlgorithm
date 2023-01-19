package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1088 {
  static class Cake implements Comparable<Cake>{
    double weight;
    int cnt; // 무게, 자른횟수 
    int idx;
    Cake(double weight, int cnt,int idx) {
      this.idx = idx;
      this.weight = weight;
      this.cnt = cnt;
    }
    public double val() {
      return weight / (cnt + 1);
    }
    public int compareTo(Cake p) {
      double diff = weight / (cnt + 1) - p.weight / (p.cnt + 1);
      if (diff > 0) {
        return -1;
      } else if (diff == 0) {
        return 0;
      }
      return 1;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    Cake[] cakes = new Cake[N];
    PriorityQueue<Cake> pq = new PriorityQueue<>();
    double smallest = Double.MAX_VALUE;
    for(int i=0; i<N; i++) {
      int w = Integer.parseInt(st.nextToken());
      cakes[i] = new Cake(w, 0,i);
      pq.offer(new Cake(w, 0,i));
      smallest = Math.min(smallest, w);
    }

    double answer = Double.MAX_VALUE;

    int M = Integer.parseInt(br.readLine());

    for(int i=0; i<=M; i++) {
      Cake cake = pq.poll();
      answer = Math.min(answer, cake.val() - smallest);
      Cake addedCake = new Cake(cake.weight, cake.cnt + 1,cake.idx);
      pq.add(addedCake);
      smallest = Math.min(smallest, addedCake.val());
    }
    System.out.printf("%.10f",answer);
  }
}