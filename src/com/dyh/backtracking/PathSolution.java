package com.dyh.backtracking;

/**
 * 矩阵中的路径：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 思路：利用回溯法
 * @author dyh
 *
 */

public class PathSolution {
	
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
		//取一个boolean[matrix.length]标记某个字符是否已经被访问过
		boolean[] visited = new boolean[matrix.length];
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(hasPathCore(matrix, rows, cols, i, j, 0, str, visited)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean hasPathCore(char[] matrix, int rows, int cols, int i, int j, int index,  char[] str, boolean[] visited){
		if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[i * cols + j] != str[index] || visited[i * cols + j]){
			return false;
		}
		if(index == str.length - 1){
			return true;
		}
		visited[i * cols + j] = true;
		if(hasPathCore(matrix, rows, cols, i-1, j, index + 1, str, visited)
				|| hasPathCore(matrix, rows, cols, i, j - 1, index + 1, str, visited)
				|| hasPathCore(matrix, rows, cols, i + 1, j, index + 1, str, visited)
				|| hasPathCore(matrix, rows, cols, i, j + 1, index + 1, str, visited)){
			return true;
		}
		
		visited[i * cols + j] = false;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e' };
		int rows = 3;
		int cols = 4;
//		char[] str = {'b', 'c', 'c', 'e', 'd'};
		char[] str = {'a', 'b', 'c', 'b'};
		System.out.println(hasPath(matrix, rows, cols, str));
	}

}
