package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20436 {
  // 키보드 자판 위치 배열 
  static char[][] map = {
    {'q','w','e','r','t','y','u','i','o','p'},
    {'a','s','d','f','g','h','j','k','l'},
    {'z','x','c','v','b','n','m'},
  };
  // 키보드 자판 모음인지 아는지 알려주는 배열 
  static boolean[][] isVowel = {
    {false,false,false,false,false,true,true,true,true,true},
    {false,false,false,false,false,true,true,true,true},
    {false,false,false,false,true,true,true},
  };
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    char L = st.nextToken().charAt(0);
    char R = st.nextToken().charAt(0);
    String s = br.readLine();
    int[] prevLeftPos = findPos(L);
    int[] prevRightPos = findPos(R);
    int answer = 0;
    for(int i=0; i<s.length(); i++) {
      // 현재 쳐야할 자판 
      char c = s.charAt(i);
      // 자판 위치 알아내기 
      int[] pos = findPos(c);
      // 현재 쳐야할 자판이 모음이라면 
      if(isVowel[pos[0]][pos[1]]) {
        // 이전 오른쪽 자판 위치와 현재 자판위치 택시거리 구하기
        answer += distance(prevRightPos, pos);
        // 이전 오른쪽 자판 위치 갱신
        prevRightPos = pos;
      }
      // 자음이라면 
      else {
        // 이전 왼쪽 자판 위치와 현재 자판위치 택시거리 구하기
        answer += distance(prevLeftPos, pos);
        // 이전 왼쪽 자판 위치 갱신
        prevLeftPos = pos;
      }
      // 키를 누르는데 걸리는 시간 더해주기
      answer++;
    }
    System.out.println(answer);
  }
  // 두 위치의 택시 거리 구하는 함수 시간복잡도 O(1)
  public static int distance(int[] pos1, int[] pos2) {
    return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
  }
  // 매개변수 c의 자판 위치 구하는 메서드 시간복잡도 O(N^2)
  public static int[] findPos(char c) {
    for(int row=0; row<map.length; row++) {
      for(int col=0; col<map[row].length; col++) {
        if(map[row][col] == c) return new int[]{row,col};
      }  
    }
    return new int[]{};
  }
}
