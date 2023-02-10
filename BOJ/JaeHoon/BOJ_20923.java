package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20923 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    ArrayDeque<Integer> doDeck = new ArrayDeque<>();
    ArrayDeque<Integer> suDeck = new ArrayDeque<>();

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      doDeck.offerFirst(Integer.parseInt(st.nextToken()));
      suDeck.offerFirst(Integer.parseInt(st.nextToken()));
    }

    Queue<Integer> doGround = new LinkedList<>();
    Queue<Integer> suGround = new LinkedList<>();
    boolean turn = false; // false: 도도, true: 수연
    int doGroundFront = -1;
    int suGroundFront = -1;
    String answer = null;
    while(M > 0) {
      M--;

      if(!turn) { //도도 턴 
        doGroundFront = doDeck.pollFirst(); //도도 덱에서 1장 뺴기
        doGround.offer(doGroundFront); // 그라운드에 올려놓기
      }else {
        suGroundFront = suDeck.pollFirst(); //수현 덱에서 1장 뺴기
        suGround.offer(suGroundFront); // 그라운드에 올려놓기
      }
      
      if(doDeck.isEmpty()) {
        answer = "su";
        break;
      }

      if(suDeck.isEmpty()) {
        answer = "do";
        break;
      }

      if(doGroundFront == 5 || suGroundFront == 5) {
        win(doDeck,doGround,suGround);
        doGroundFront = suGroundFront = -1;
      }

      if(doGroundFront != -1 && suGroundFront != -1 && doGroundFront + suGroundFront == 5) {
        win(suDeck,suGround,doGround);
        doGroundFront = suGroundFront = -1;
      }
      
      turn = !turn;
    }
    if(answer != null) {
      System.out.println(answer);
    }else {
      if(doDeck.size() > suDeck.size()) {
        System.out.println("do");
      }
      else if(doDeck.size() < suDeck.size()) {
        System.out.println("su");
      }else {
        System.out.println("dosu");
      }
    }
  }
  static void win(ArrayDeque<Integer> deck, Queue<Integer> me, Queue<Integer> you) {
    while(!you.isEmpty()) {
      deck.offerLast(you.poll());
    }

    while(!me.isEmpty()) {
      deck.offerLast(me.poll());
    }
  }
}
