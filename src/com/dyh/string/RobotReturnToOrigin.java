package com.dyh.string;

/**
 * Robot Return to Origin：一个机器人在位置（0,0）上开始移动，移动一度时间后，判断是否返回了原点。字符串“R”、“L”、“U”、“D”代表机器人移动的四个方向。
   * 例："UD"
   * 返回：true
 * "LL"
   * 返回：false 
 * @author dyh
 *
 */

public class RobotReturnToOrigin {
	
	//原
	public static boolean judgeCircle(String moves) {
		int lcount = 0;
		int rcount = 0;
		int ucount = 0;
		int dcount = 0;
		char ch;
		for(int i = 0; i < moves.length(); i++) {
			ch = moves.charAt(i);
			if(ch == 'L') {
				lcount++;
			}else if(ch == 'R') {
				rcount++;
			}else if(ch == 'U') {
				ucount++;
			}else if(ch == 'D') {
				dcount++;
			}
		}
		if(lcount == rcount && ucount == dcount) {
			return true;
		}
        return false;
    }

	//改
	public static boolean judgeCircle2(String moves) {
		int lr = 0;
		int ud = 0;
		for(char ch : moves.toCharArray()) {
			switch (ch) {
			case 'L':
				lr++;
				break;
			case 'R':
				lr--;
				break;
			case 'U':
				ud++;
				break;

			default:
				ud--;
				break;
			}
		}
        return ud == 0 && lr == 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "RURLULDULR";
		System.out.println(judgeCircle2(string));
	}

}
