package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2879 {
  static class Line {
    int tab;
    int properTab;
    Line(int tab) {
      this.tab = tab;
    }
    public int getDif() {
      return properTab - tab;
    }
    public String getPlus() {
      return getDif() > 0 ? "plus" : getDif() < 0 ?  "minus" : "zero";
    }
  }
  static Line[] lines;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    lines = new Line[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      lines[i] = new Line(Integer.parseInt(st.nextToken()));
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      lines[i].properTab = Integer.parseInt(st.nextToken());
    }
    int answer = 0;
    String prev = lines[0].getPlus();
    int startIdx = 0;
    while(startIdx >= N && lines[startIdx].getPlus().equals("zero")) {
      startIdx++;
      prev = lines[startIdx].getPlus();
    }
    if(startIdx == N) {
      System.out.println(0);
      System.exit(0);
    }
    for(int i=startIdx+1; i<N; i++) {
      String curr = lines[i].getPlus();
      if(!prev.equals(curr)) {
        answer += calculationTab(startIdx,i-1);
        prev = curr;
        startIdx = i;
      }
    }
    answer += calculationTab(startIdx,N-1);
    System.out.println(answer);
  }
  public static int calculationTab(int startIdx, int endIdx) {
    if(startIdx > endIdx) return 0;
    int total = 0;
    int min = lines[startIdx].getDif();
    for(int i=startIdx; i<=endIdx; i++) {
      if(Math.abs(lines[i].getDif()) < Math.abs(min)) {
        min = lines[i].getDif();
      }
    }
    total+=Math.abs(min);
    ArrayList<Integer> zeroArr = new ArrayList<>();
    for(int i=startIdx; i<=endIdx; i++) {
      lines[i].tab += min;
      if(lines[i].getDif() == 0)
        zeroArr.add(i);
    }
    if(zeroArr.size() == endIdx - startIdx + 1) return total;
    else {
      for(int i=0; i<zeroArr.size(); i++) {
        if(i==0)
          total += calculationTab(startIdx, zeroArr.get(i)-1);
        if(i == zeroArr.size() - 1) 
          total += calculationTab(zeroArr.get(i)+1, endIdx);
        else 
          total += calculationTab(zeroArr.get(i)+1, zeroArr.get(i+1)-1);
      }
      return total;
    }
  }
}
