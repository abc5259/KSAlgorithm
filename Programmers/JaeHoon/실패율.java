package Programmers.JaeHoon;

import java.util.Arrays;

public class 실패율 {
  public static void main(String[] args) {
    int N = 5;
    int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
    int[] answer = new int[N];
    Arrays.sort(stages);
    Stage[] stage = new Stage[N];
    for(int i=0; i<N; i++)
      stage[i] = new Stage(i+1);
      
    int prevStatge = stages[0] - 1;
    int participants = stages.length;

    if(prevStatge < N) {
      stage[prevStatge].participants = participants;
      stage[prevStatge].noClearCnt += 1;
    }

    for(int i=1; i<stages.length; i++) {
      int curStage = stages[i] - 1;
      if(curStage >= N) continue;
      if(prevStatge == curStage) {
        stage[curStage].noClearCnt++;
      }else {
        prevStatge = curStage;
        stage[curStage].noClearCnt++;
        stage[curStage].participants = stages.length - i;
      }
    }
    Arrays.sort(stage);
    for(int i=0; i<N; i++) {
      answer[i] = stage[i].stageNum;
    }
    System.out.println(Arrays.toString(answer));
  }
  public static class Stage implements Comparable<Stage>{
    double participants = 1;
    double noClearCnt = 0;
    int stageNum;
    Stage(int stageNum) {
      this.stageNum = stageNum;
    }
    public double getFail() {
      return this.noClearCnt / this.participants;
    }
    @Override
    public int compareTo(Stage o) {
      return Double.compare(o.getFail(), this.getFail());
    }
  }
}
