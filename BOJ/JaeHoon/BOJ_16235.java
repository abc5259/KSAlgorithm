package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_16235 {
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{1,1},{-1,1},{-1,-1}};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); //땅크기
    int M = Integer.parseInt(st.nextToken()); //M개의 나무
    int K = Integer.parseInt(st.nextToken()); //K년 

    int[][] A = new int[N][N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      } 
    }

    Ground[][] map = new Ground[N][N];

    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        map[i][j] = new Ground();
      }
    }

    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken()); //나이 
      map[x-1][y-1].addTree(z,1);
    }

    for(int k=0; k<K; k++) {
      //봄 
      for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
          map[i][j].meetSpring();
        } 
      }

      for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
          map[i][j].meetSummer();
        } 
      }

      for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
          map[i][j].meetAutumn(map, i, j);
        } 
      }

      for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
          map[i][j].meetWinter(A[i][j]);
        } 
      }
    }
    int answer = 0;
    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        answer += map[i][j].getTreeCnt();
      } 
    }
    System.out.println(answer);
  }
  static class Ground {
    private Map<Integer,Integer> treeMap = new HashMap<>();
    private Map<Integer,Integer> deadTreeMap = new HashMap<>();
    private int food = 5;
    
    public void addTree(int age, int cnt){
      treeMap.put(age, treeMap.getOrDefault(age, 0) + cnt);
    }
    public void meetSpring() {
      List<Integer> keySet = new ArrayList<>(treeMap.keySet());
      Map<Integer,Integer> newTreeMap = new HashMap<>();
      // 나이 값으로 오름차순 정렬
      Collections.sort(keySet);

      for (Integer age : keySet) {
        int cnt = treeMap.get(age);
        int total = age*cnt;
        if(food - total < 0) { //양분을 줄 수 없으면 
          int ableCnt = food / age; //양분을 줄 수 있는 나무 갯수 

          food -= ableCnt*age; 
          if(ableCnt != 0)
            newTreeMap.put(age+1, ableCnt);
          // 양분을 줄 수 없는 나무는죽음 
          deadTreeMap.put(age, deadTreeMap.getOrDefault(age, 0) + cnt - ableCnt);
        }else {
          food -= total; //양분 줄이기 
          newTreeMap.put(age+1, cnt); //나이가 1 많아지고 새로운 나무Map에 저장 
        }
      }

      treeMap = newTreeMap;
    }
    public void meetSummer() {
      List<Integer> keySet = new ArrayList<>(deadTreeMap.keySet());

      for (Integer age : keySet) {
        food += ((age / 2) * deadTreeMap.get(age));
        deadTreeMap.put(age, 0);
      }
    }
    public void meetAutumn(Ground[][] map, int x, int y) {
      Iterator<Map.Entry<Integer,Integer>> iter = treeMap.entrySet().iterator();

      while(iter.hasNext()) {
        Map.Entry<Integer,Integer> tree = iter.next();
        int age = tree.getKey();
        int cnt = tree.getValue();
        if(age % 5 == 0) {
          for(int i=0; i<8; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if(nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map.length) continue;
            map[nextX][nextY].addTree(1,cnt);
          }
        }
      }
    }
    public void meetWinter(int addFood) {
      food += addFood;
    }
    public int getTreeCnt() {
      List<Integer> valueList = new ArrayList<>(treeMap.values());
      int sum = 0;
      for (Integer cnt : valueList) {
        sum += cnt;
      }
      return sum;
    }
  }
}
