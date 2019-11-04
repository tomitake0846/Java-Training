package dc1_2;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dc1_2.dialog.PropertyDialog;

public class PulldownList extends Applet implements ActionListener{
	protected List list;
	protected Button pullButton;
	protected int shrinkedListRow = 1;
	protected int pulledListRow;
	protected int listRows;
	protected String selectedItem;
	private int x;
	private int y;

	public PulldownList(String[] listItems,int pulledListRow,String selectedItem,int x,int y) {
		this(listItems,ButtonType.PULLDOWN_LIST, pulledListRow, selectedItem, x, y);
	}

	public PulldownList(String[] listItems,ButtonType type,int pulledListRow,String selectedItem,int x,int y) {
		listRows = shrinkedListRow;
		this.pulledListRow = pulledListRow;
		this.pullButton = ButtonFactory.getButton(type,this);
		listInit(listItems);
		changeSelectItem(selectedItem);
		this.selectedItem = selectedItem;
		this.x = x;
		this.y = y;
	}


	public void paintPrepare() {
		Dimension d = this.list.getPreferredSize(this.listRows);
		int fontSize = PropertyDialog.PROPERTY_FONT_SIZE;
		this.list.setBounds(getX(), getY(), d.width, d.height);
		this.pullButton.setBounds(getX()+d.width+2, getY(), fontSize+5,fontSize+5);
	}

	@Override
	//pull down button's action
	public void actionPerformed(ActionEvent e) {
		//pull action
		if(listRows == shrinkedListRow) {
			listRows = pulledListRow;

		//shrink action
		} else {
			listRows = shrinkedListRow;
		}
		paintPrepare();
	}

	public List getList() {
		return this.list;
	}
	public Button getButton() {
		return this.pullButton;
	}
	public String getSelectedItem() {
		return this.selectedItem;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}

	private void listInit(String[] items) {
		List tmpList = new List(listRows,false);
		tmpList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectItem = e.getActionCommand();
				changeSelectItem(selectItem);
				selectedItem = selectItem;
				listRows=1;
				paintPrepare();
			}
		});

		for(String item : items) {
			tmpList.add(item);
		}
		this.list = tmpList;
	}

	private void changeSelectItem(String item) {
		int selectTarget=0;
		String[] items = this.list.getItems();
		for(int i=0;i<items.length;i++) {
			if(item.equals(items[i])) {
				selectTarget = i;
				break;
			}
		}

		//GUI update
		this.list.select(selectTarget);
		this.list.makeVisible(selectTarget);
	}

}
