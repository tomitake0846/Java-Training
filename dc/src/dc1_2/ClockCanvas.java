package dc1_2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockCanvas extends Canvas{

	private DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
	private String fontFamily = "Serif";
	private int fontName = Font.ITALIC;
	private int fontSize = 32;

	public ClockCanvas(int width,int height) {
		setSize(width,height);
		setBackground(Color.black);

	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		Font font = new Font(fontFamily,this.fontName,fontSize);
		String drawString = LocalDateTime.now().format(f);
		FontMetrics metrics = g.getFontMetrics(font);

		g.setFont(font);
		g.drawString(drawString, metrics.stringWidth(drawString) , getHeight() / 2);
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	public void setFontName(int fontName) {
		this.fontName = fontName;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
}
