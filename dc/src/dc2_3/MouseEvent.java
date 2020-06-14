package dc2_3;

import java.awt.PopupMenu;
import java.awt.event.MouseListener;

public class MouseEvent implements MouseListener{
	PopupMenu pop;
	private int x;
	private int y;
	public MouseEvent(PopupMenu pop) {
		this.pop = pop;
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("click!");
		if(e.getButton() == java.awt.event.MouseEvent.BUTTON3) {
			pop.show(e.getComponent(),
					e.getX(),e.getY());
		}
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
			x = e.getX();
			y = e.getY();
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		int afterX = e.getX();
		int afterY = e.getY();
		int windowX = DigitalClock.myWindow.getX();
		int windowY = DigitalClock.myWindow.getY();
		DigitalClock.myWindow.setLocation(windowX+ (afterX - x), windowY+(afterY - y));
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//mouseがアプレット上に乗った
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//mouseがアプレットの外へ出た

	}

}
