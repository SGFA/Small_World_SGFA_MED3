package menu_package;

import org.newdawn.slick.Graphics;

public class Toast {

	private static int x;
	private static int y;
	private static int delta;
	private static double time;
	private static String msg = " ";

	public static void reset() {
		time = System.currentTimeMillis();
	}

	public static void set(int x, int y, String msg, int delta) {

		Toast.msg = msg;
		Toast.delta = delta;
		Toast.x = x;
		Toast.y = y;

		Toast.reset();
	}

	public static void draw(Graphics g) {
		if (System.currentTimeMillis() < time + delta) {
			g.drawString(msg, x, y);
		}
	}
}
