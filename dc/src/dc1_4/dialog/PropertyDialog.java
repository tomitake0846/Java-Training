package dc1_4.dialog;

import java.awt.Button;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dc1_4.ButtonFactory;
import dc1_4.ButtonType;
import dc1_4.DigitalClock;
import dc1_4.PropertyInfo;
import dc1_4.PulldownList;

public class PropertyDialog extends abstractDialog implements ActionListener{

	public static final int PROPERTY_FONT_SIZE = 20;
	public static final int DIALOG_WINDOW_SIZE = 600;

	private final String FONT_FAMILY = "Font Family";
	private final String FONT_SIZE = "Font Size";
	private final String CHAR_COLOR = "Character Color";
	private final String BG_COLOR = "BackGround Color";

	private PropertyInfo propertyInfo;
	private Font propertyFont;

	private Button updateButton;
	private Button cancelButton;
	private Button resetButton;

	private PulldownList fontFamilyPulldownList;
	private PulldownList fontSizePulldownList;
	private PulldownList bgColorPulldownList;
	private PulldownList charColorPulldownList;

	private GridBagLayout layout;

	public PropertyDialog(){
		layout = new GridBagLayout();
		this.setLayout(layout);

		setBounds(DigitalClock.frame.getX()+20,DigitalClock.frame.getY()+20,DIALOG_WINDOW_SIZE,DIALOG_WINDOW_SIZE/2);
		setResizable(false);

		this.propertyInfo = PropertyInfo.instance;

		this.propertyFont = new Font("Serif",0,PROPERTY_FONT_SIZE);
		setFont(this.propertyFont);

		String[] fontFamilyList = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();

		String[] fontSizeList = {"20","26","32","40","48","56"};

		String[] colorList = {"white","lightGray","gray","darkGray","black","red",
				"pink","orange","yellow","green","magenta","cyan","blue"};

		this.fontFamilyPulldownList = initPulldownList(fontFamilyList,10,this.propertyInfo.getFontFamily(),FONT_FAMILY);
		this.fontSizePulldownList = initPulldownList(fontSizeList,5,this.propertyInfo.getFontSize()+"",FONT_SIZE);
		this.charColorPulldownList = initPulldownList(colorList,5,this.propertyInfo.getCharColor(),CHAR_COLOR);
		this.bgColorPulldownList = initPulldownList(colorList,5,this.propertyInfo.getBGColor(),BG_COLOR);

		//update & cancel Button initialization
		this.updateButton = ButtonFactory.getButton(ButtonType.PROPERTY_UPDATE,this);
		this.cancelButton = ButtonFactory.getButton(ButtonType.PROPERTY_CANCEL, this);
		this.resetButton = ButtonFactory.getButton(ButtonType.PROPERTY_RESET, this);

		add(updateButton);
		add(cancelButton);
		add(resetButton);

	}

	public void paint(Graphics g) {

		this.fontFamilyPulldownList.paintPrepare(this.layout);
		this.bgColorPulldownList.paintPrepare(this.layout);
		this.charColorPulldownList.paintPrepare(this.layout);
		this.fontSizePulldownList.paintPrepare(this.layout);

		int rightDown = (DIALOG_WINDOW_SIZE/2) - PROPERTY_FONT_SIZE * 2;
		this.updateButton.setBounds((int)(rightDown*1.5),rightDown,PROPERTY_FONT_SIZE+12,PROPERTY_FONT_SIZE+5);
		this.cancelButton.setBounds((int)(rightDown*1.5) + PROPERTY_FONT_SIZE+20,rightDown,PROPERTY_FONT_SIZE+42,PROPERTY_FONT_SIZE+5);
		this.resetButton.setBounds((int)(rightDown*1.5) + PROPERTY_FONT_SIZE+90,rightDown,PROPERTY_FONT_SIZE+42,PROPERTY_FONT_SIZE+5);
	}

	@Override
	//update PropertyInfo
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("OK")) {

			String currentFontFamily = fontFamilyPulldownList.getSelectedItem();
			String currentFontSize = fontSizePulldownList.getSelectedItem();
			String currentCharColor = charColorPulldownList.getSelectedItem();
			String currentBGColor = bgColorPulldownList.getSelectedItem();

			propertyInfo.setFontFamily(currentFontFamily);
			propertyInfo.setFontSize(currentFontSize);
			propertyInfo.setCharColor(currentCharColor);
			propertyInfo.setBGColor(currentBGColor);

			DigitalClock.prefs.propertyUpdate();

		} else if (e.getActionCommand().equals("reset")) {
			DigitalClock.prefs.propertyReflesh();
			DigitalClock.prefs.positionReflesh();
		}

		DigitalClock.frame.setSize(propertyInfo.getClockWidth(),propertyInfo.getClockHeight());
		DigitalClock.canvas.repaint();

		close();
	}


	private int count=0;
	private PulldownList initPulldownList(String[] items,int firstRow,String selectedItem,String attrName) {
		PulldownList pulldownList = new PulldownList (items,firstRow,selectedItem,attrName);
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx=0;
		gbc.gridy=count;
		gbc.anchor = GridBagConstraints.EAST;
		Label label = new Label(attrName);
		pulldownList.setLabel(label);
		pulldownList.setLabelGBC(gbc);
		layout.setConstraints(label, gbc);
		add(label);

		gbc = new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=count;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pulldownList.setListGBC(gbc);
		layout.setConstraints(pulldownList.getList(), gbc);
		add(pulldownList.getList());

		gbc = new GridBagConstraints();
		gbc.gridx=2;
		gbc.gridy=count++;
		label = new Label("   ");
		pulldownList.setParetLabel(label);
		pulldownList.setParetGBC(gbc);
		layout.setConstraints(label, gbc);
		add(label);

		pulldownList.paintPrepare();
		return pulldownList;
	}
}
