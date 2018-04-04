package com.dyh.intelligence;

/**
 * 跳格子练习题：你和你的朋友正在玩棋子跳格子的游戏，而棋盘是一个由n个格子组成的长条，你们两人轮流移动一颗棋子，每次可以选择让棋子跳1-3格，先将棋子移出棋盘的人获得胜利。
 * 我们知道你们两人都会采取最优策略，现在已知格子数目，并且初始时棋子在第一格由你操作。请你计算你是否能获胜。
 * 给定格子的数目n(n为不超过300的正整数)。返回一个整数，1代表能获胜，0代表不能获胜。
 * 例：3
 * 返回：1
 * @author dyh
 *
 */

public class Jump {
    
	public static int checkWin(int n){
		//当n < 4时，必赢，n == 4时，必输
		//当4<n<7时，可以直接把对方送入n==4的位置，而n==8时，你无论走[1，2，3]步，对方都可以通过走[3，2，1]步，把你送入n==4的位置，因此n==8时，你必输，
		//当8<n<12时，你可以通过走[1，2，3]，把对方送入n==8的位置，
		//综上，n%4==0时是死位，谁在该位置谁就会输
		return n % 4 == 0 ? 0 : 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		System.out.println(checkWin(n));
	}

}
