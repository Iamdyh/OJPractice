package com.dyh.dynamic;

/**
 * Divisor Game: Alice and Bob take turns playing a game, with Alice starting first.Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
 * Choosing any x with 0 < x < N and N % x == 0.
 * Replacing the number N on the chalkboard with N - x.
 * Also, if a player cannot make a move, they lose the game.Return True if and only if Alice wins the game, assuming both players play optimally.
 * 例：2
 * 返回： true
 * 解释：Alice chooses 1, and Bob has no more moves.
 * @author dyh
 *
 */

public class DivisorGame {
//	使用动态规划
//	1、N = 1时很容易理解，不存在这样的x，Alice判定为输；
//	2、N = 2时，仅存在唯一的x=1满足条件，Alice经过这一个操作后，N = N - x = 1，由1知道轮到Bob时，找不到满足条件的x，Alice判断为赢；
//	3、N = 3时，同2仅存在唯一的x=1满足条件，轮到Bob时N = N - x = 2，由2知道Alice判定为输
//	4、N = 10时，满足条件的x={1,2,5}，存在x=1使得Alice判定为赢
//	从上面的计算过程可以总结，每一个N的计算都依赖于前面[1,N-1]的结果
	public static boolean divisorGame(int N) {
		boolean[] res = new boolean[N + 1];
		res[1] = false;
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j < i; j++) {
				if(i % j == 0 && !res[i - j]) {
					res[i] = true;
					break;
				}
			}
		}
		return res[N];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 10;
		System.out.println(divisorGame(N));
	}

}
