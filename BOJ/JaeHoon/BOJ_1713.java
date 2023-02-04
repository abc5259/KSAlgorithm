package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1713 {
  static class Student implements Comparable<Student>{
    int recommendCnt;
    int id;
    int postingTime;
    Student(int id) {
      this.id = id;
    }
    @Override
    public int compareTo(Student b) {
      if(this.recommendCnt == b.recommendCnt) 
        return this.postingTime - b.postingTime;
      return this.recommendCnt - b.recommendCnt;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int total = Integer.parseInt(br.readLine());


    StringTokenizer st = new StringTokenizer(br.readLine());

    Student[] candidates = new Student[N];

    Student[] students = new Student[100+1];
    for(int i=0; i<=100; i++) {
      students[i] = new Student(i);
    }


    Set<Integer> set = new HashSet<>();

    int candidatesIdx = 0;

    for(int i=0; i<total; i++) {
      int recommendNum = Integer.parseInt(st.nextToken());
      // 추천 + 1
      students[recommendNum].recommendCnt += 1;

      if(!set.contains(recommendNum)) { //이미 사진틀에 올라간 후보가 아니라면 
        if(set.size() < N) { //사진틀에 게시된 사진이 꽉 차지 않았다면 

          //사진틀에 후보 넣기
          set.add(recommendNum); 
          candidates[candidatesIdx++] = students[recommendNum];

          //사진틀에 올라간 시간 지정 
          students[recommendNum].postingTime = i; 

        }else {//사진틀에 게시된 사진이 꽉 찼다면  

          // 후보 뺴기 
          Arrays.sort(candidates);
          set.remove(candidates[0].id);
          candidates[0].recommendCnt = 0;

          //사진틀에 후보 넣기
          set.add(recommendNum); 
          candidates[0] = students[recommendNum];
          
          //사진틀에 올라간 시간 지정 
          students[recommendNum].postingTime = i; 
        }
      }
    }
    StringBuffer sb = new StringBuffer();
    int[] answer = new int[set.size()];
    int idx = 0;
    Iterator<Integer> iter = set.iterator();
    while(iter.hasNext()) {
      answer[idx++] = iter.next();
    }
    Arrays.sort(answer);

    for(int i=0; i<answer.length; i++) {
      sb.append(answer[i] + " ");
    }
    System.out.println(sb);
  }
}
