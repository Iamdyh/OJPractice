package com.dyh.array;

/**
 * Projection Area of 3D Shapes：在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。投影就像影子，将三维形体映射到一个二维平面上。在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。返回所有三个投影的总面积。
 * input:[[1,2],[3,4]]
 * output:17
 * @author dyh
 *
 */

public class ProjectionAreaOf3DShapes {

	/**
	 * 正视图：每一行最大值之和
	 * 侧视图：每一列最大值之和
	 * 俯视图：柱子个数
	 * @param grid
	 * @return
	 */
	public static int projectionArea(int[][] grid) {

		int sum = 0;
		int row = 0;
		int col = 0;
		for(int i = 0; i < grid.length; i++) {
			row = 0;
			col = 0;
			for(int j = 0; j < grid[0].length; j++) {
				row = Math.max(row, grid[i][j]);
				col = Math.max(col, grid[j][i]);
				sum += grid[i][j] == 0 ? 0 : 1;
			}
			sum = sum + row + col;
		}
		return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1, 2}, {3, 4}};
		System.out.println(projectionArea(grid));
	}

}
