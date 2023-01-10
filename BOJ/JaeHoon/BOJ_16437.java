package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16437 {
  static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
  static int[] score;
  static char[] animal;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    score = new int[N+1];
    animal = new char[N+1];
    for(int i=0; i<=N; i++)  {
      nodes.add(new ArrayList<>());
    }

    for(int i=2; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      char c = st.nextToken().charAt(0);
      int cnt = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      score[i] = cnt;
      animal[i] = c;
      nodes.get(p).add(i);
    }
    
    System.out.println(postOrder(1));
  }
  public static long postOrder(int node) {
    long sum = 0;

    for(int next:nodes.get(node)) {
      sum += postOrder(next);
    }

    if(animal[node] == 'S') {
      return sum + score[node];
    }else {
      return sum - score[node] > 0 ? sum - score[node] : 0;
    }

  }
}
