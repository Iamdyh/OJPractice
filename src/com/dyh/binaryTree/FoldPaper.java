package com.dyh.binaryTree;
import java.util.ArrayList;

/**
 * 折纸练习题:请把纸条竖着放在桌子上，然后从纸条的下边向上方对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背面，这条折痕叫做“下”折痕 ；
 * 突起的方向指向纸条正面的折痕叫做“上”折痕。如果每次都从下边向上方 对折，对折N次。请从上到下计算出所有折痕的方向。
 * 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up"。
 * 例：1
 * 返回： ["down"]
 * 思路：这实际上是一颗以“下”为头节点，“上”为左子树，“下”为右子树的二叉树。
 *     实现先右再中、最后左的先序遍历，就是所有折痕的打印顺序。
 * @author dyh
 *
 */

public class FoldPaper {
	
	public static String[] foldPaper(int n) {
        // write code here
		ArrayList<String> list = new ArrayList<>();
		fold(1, n, true, list);  //头节点
		String[] strings = new String[list.size()];
		for(int i = 0; i < list.size(); i++) {
			strings[i] = list.get(i);
		}
		return strings;
		
		
    }
	public static void fold(int i, int n, boolean down, ArrayList<String> list) {
		if(i > n)
			return;
		fold(i+1, n, true, list); //先遍历右子树
		list.add(down?"down":"up"); 
		fold(i+1, n, false, list);//再遍历左子树
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		String[] reStrings = foldPaper(n);
		for (String string : reStrings) {
			System.out.print(string + " ");
		}
	}

}
