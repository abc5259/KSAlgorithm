package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {
  public static void main(String[] args) throws IOException {
    //보석점에는 보석 N개 
    // 보석의 무게 -> M
    // 보석의 가격 -> V
    // 가방에 담을 수 있는 최대 무게 -> C
    // 가방에는 최대 한개의 보석만 넣을 수 있음
    // 훔칠 수 있는 보석의 최대 가격
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Jewels[] jewels = new Jewels[N];
    int[] bags = new int[K];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      jewels[i] = new Jewels(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    for(int i=0; i<K; i++) {
      st = new StringTokenizer(br.readLine());
      bags[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(jewels);
    Arrays.sort(bags);
    long sum = 0;
    PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
    int j = 0;
    for(int i=0; i<K; i++) {
      while(j < N && bags[i] >= jewels[j].m) {
        q.offer(jewels[j].v);
        j++;
      }
      if(!q.isEmpty()) {
        sum += q.poll();
      }
    }
    System.out.println(sum);
  }
  public static class Jewels implements Comparable<Jewels>{
    int m,v;
    Jewels(int m,int v) {
      this.m = m;
      this.v = v;
    }
    @Override
    public int compareTo(Jewels o) {
      // 무게가 같다면 가격이 비싼 순으로 
      if(this.m == o.m) return -(this.v - o.v);
      // 무게순으로 정렬
      return this.m - o.m;
    }
    
  }
}

// 무게가 제일 작은 가방부터 선택해서 해당 가방에 넣을 수 있는 보석중에서 제알 비싼 보석을 넣는다.
// 해당 가방에 넣을 수 있는 보석을 어떻게 찾을까..
// 보석 600,000중에서 찾을려면 600,000 * 600,000의 시간복잡도를 가져 절대 시간내에 못품
// 보석을 가격이 비싼순 and 무게가 작은순으로 정렬하면 될까?? 
// 1 1000  ->  10
// 10 999   
// 무게가 젤 낮고 
// 같은무게 중에서 제일 비싼애 먼저 꺼내기 
// 1 60
// 2 70
// 