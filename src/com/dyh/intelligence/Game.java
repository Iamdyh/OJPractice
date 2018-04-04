package com.dyh.intelligence;

/**
 * 游戏练习题：A与B做游戏。 在一个n*m的矩阵中的出发点是（1，m），终点是（n,1），规则是只能向左移动一格，向下一格或向左下移动一格，
 * 先走到终点的为winner。 A先走。
 * 给定两个整数n和m，请返回最后的获胜者的名字(A或B)。
 * 例：5,3
 * 返回：B
 * @author dyh
 *
 */

public class Game {

	public static char getWinner(int n, int m){
		//当n和m都是奇数时，B才会赢
		if(n % 2 != 0 && m % 2 != 0)
			return 'B';
		else
			return 'A';
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int m = 3;
		System.out.println(getWinner(n, m));
	}

}
