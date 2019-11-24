package dc1_3.dialog;

import java.awt.Button;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dc1_2.ButtonFactory;
import dc1_2.ButtonType;
import dc1_2.DigitalClock;
import dc1_2.PropertyInfo;
import dc1_2.PulldownList;

public class PropertyDialog extends abstractDialog implements ActionListener{

	public static final int PROPERTY_FONT_SIZE = 20;
	public static final int DIALOG_WINDOW_SIZE = 600;

	private final String FONT_FAMILY = "Font Family";
	private final String FONT_SIZE = "Font Size";
	private final String CHAR_COLOR = "Character Color";
	private final String BG_COLOR = "BackGround Color";
	private final int MAX_PROPERTY_WIDTH;

	private PropertyInfo propertyInfo;
	private Font propertyFont;

	private Button updateButton;

	private PulldownList fontFamilyPulldownList;
	private PulldownList fontSizePulldownList;
	private PulldownList bgColorPulldownList;
	private PulldownList charColorPulldownList;

	public PropertyDialog(){
		setSize(DIALOG_WINDOW_SIZE,DIALOG_WINDOW_SIZE);
		setResizable(false);

		this.propertyInfo = PropertyInfo.instance;

		this.propertyFont = new Font("Serif",0,PROPERTY_FONT_SIZE);
		setFont(this.propertyFont);

		//shoud refactoring
		this.MAX_PROPERTY_WIDTH = getMaxPropertyWidth(propertyFont,
				FONT_FAMILY,FONT_SIZE,CHAR_COLOR,BG_COLOR);

		int listWidth = MAX_PROPERTY_WIDTH+40;

		String[] fontFamilyList = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();

		String[] fontSizeList = {"20","26","32","40","48","56"};

		String[] colorList = {"white","lightGray","gray","darkGray","black","red",
				"pink","orange","yellow","green","manatee","cyan","blue"};

		this.fontFamilyPulldownList = initPulldownList(fontFamilyList,10,this.propertyInfo.getFontFamily(),listWidth,80);
		this.fontSizePulldownList = initPulldownList(fontSizeList,5,this.propertyInfo.getFontSize()+"",listWidth,130);
		this.charColorPulldownList = initPulldownList(colorList,5,this.propertyInfo.getCharColor(),listWidth,180);
		this.bgColorPulldownList = initPulldownList(colorList,5,this.propertyInfo.getBGColor(),listWidth,230);

		//update Button initialization
		this.updateButton = ButtonFactory.getButton(ButtonType.PROPERTY_UPDATE,this);
		add(updateButton);

	}

	public void paint(Graphics g) {
		g.drawString(FONT_FAMILY,20,100);
		g.drawString(FONT_SIZE, 20, 150);
		g.drawString(CHAR_COLOR,20,200);
		g.drawString(BG_COLOR, 20, 250);

		this.fontFamilyPulldownList.paintPrepare();
		this.bgColorPulldownList.paintPrepare();

		int rightDown = DIALOG_WINDOW_SIZE - PROPERTY_FONT_SIZE * 2;
		this.updateButton.setBounds(rightDown,rightDown,PROPERTY_FONT_SIZE+12,PROPERTY_FONT_SIZE+5);
	}

	@Override
	//update PropertyInfo
	public void actionPerformed(ActionEvent e) {
		String currentFontFamily = fontFamilyPulldownList.getSelectedItem();
		String currentFontSize = fontSizePulldownList.getSelectedItem();
		String currentCharColor = charColorPulldownList.getSelectedItem();
		String currentBGColor = bgColorPulldownList.getSelectedItem();

		propertyInfo.setFontFamily(currentFontFamily);
		propertyInfo.setFontSize(currentFontSize);
		propertyInfo.setCharColor(currentCharColor);
		propertyInfo.setBGColor(currentBGColor);

		DigitalClock.frame.setSize(propertyInfo.getClockWidth(),propertyInfo.getClockHeight());
		DigitalClock.canvas.repaint();

		close();
	}



	private PulldownList initPulldownList(String[] items,int firstRow,String selectedItem,int x,int y) {
		PulldownList pulldownList = new PulldownList (items,firstRow,selectedItem,x,y);
		add(pulldownList.getList());
		add(pulldownList.getButton());
		pulldownList.paintPrepare();
		return pulldownList;
	}

	private int getMaxPropertyWidth(Font font,String...targets) {
		int maxPropertyWidth = 0;
		int width = 0;
		Graphics graphics = createImage(DIALOG_WINDOW_SIZE, DIALOG_WINDOW_SIZE).getGraphics();
		FontMetrics fontMetrics = graphics.getFontMetrics(font);

		for(String target : targets) {
			width = fontMetrics.stringWidth(target);
			if(maxPropertyWidth < width) {
				maxPropertyWidth = width;
			}
		}

		graphics = null;
		fontMetrics = null;

		return maxPropertyWidth;
	}

}
