package com.dyh.array;

import java.util.Arrays;

/**
 * Flipping an Image:给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
   *    反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * input:[[1,1,0],[1,0,1],[0,0,0]]
 * output:[[1,0,0],[0,1,0],[1,1,1]]
 * @author dyh
 *
 */
public class FlippingAnImage {
	
	public static int[][] flipAndInvertImage(int[][] A) {
		int row = A.length;
		int col = A[0].length;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col / 2; j++) {
				int t = A[i][j];
				A[i][j] = A[i][col - 1 - j];
				A[i][col - 1 - j] = t;
			}
		}
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				A[i][j] = A[i][j] == 0 ? 1 : 0;
			}
		}
        return A;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1,1,0}, {1,0,1},{0,0,0}};
		int[][] B = new int[3][3];
		B = flipAndInvertImage(A);
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[0].length; j++) {
				System.out.println(B[i][j]);
			}
		}
	}

}
