package com.dyh.array;

/**
 * Available Captures for Rook: 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进
 * 入同一个方格。返回车能够在一次移动中捕获到的卒的数量。
 * input:[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * output:3
 * 
 * @author dyh
 *
 */

public class AvailableCapturesforRook {
	
	public static int numRookCaptures(char[][] board) {
        int max = 0;
        int rowB = 0;           //行
        int colB = 0;            //列
        for(int i = 0; i < 8; i++) {
        	for(int j = 0; j < 8; j++) {
        		if(board[i][j] == 'R') {
        			rowB = i;
        			colB = j;
        		}
        	}
        }
        //左边
        for(int i = colB - 1; i >= 0; i--) {
        	if(board[rowB][i] == 'p') {
        		max ++;
        		break;
        	}else if(board[rowB][i] == 'B') {
        		break;
        	}
        }
        //右边
        for(int i = colB + 1; i < 8; i++) {
        	if(board[rowB][i] == 'p') {
        		max ++;
        		break;
        	}else if(board[rowB][i] == 'B') {
        		break;
        	}
        }
        //上边
        for(int i = rowB - 1; i >= 0; i--) {
        	if(board[i][colB] == 'p') {
        		max ++;
        		break;
        	}else if(board[i][colB] == 'B') {
        		break;
        	}
        }
        //下边
        for(int i = rowB + 1; i < 8; i++) {
        	if(board[i][colB] == 'p') {
        		max ++;
        		break;
        	}else if(board[i][colB] == 'B') {
        		break;
        	}
        }
        return max;
    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
