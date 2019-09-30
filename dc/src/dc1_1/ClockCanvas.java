package dc1_1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockCanvas extends Canvas{

	DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");

	public ClockCanvas(int width,int height) {
		setSize(width,height);
		setBackground(Color.black);

	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
//		g.drawRect(0, 0, getWidth(),getHeight());
		g.setFont(new Font("Serif",Font.ITALIC,32));
		g.drawString(LocalDateTime.now().format(f), getWidth() / 2, getHeight() / 2);
	}
}
