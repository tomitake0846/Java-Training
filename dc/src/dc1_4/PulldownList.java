package dc1_4;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dc1_4.dialog.PropertyDialog;

public class PulldownList extends Applet implements ActionListener{
	protected List list;
	protected Button pullButton;
	protected int shrinkedListRow = 1;
	protected int pulledListRow;
	protected int listRows;
	protected String selectedItem;
	private GridBagConstraints labelGBC;
	private GridBagConstraints listGBC;
	private GridBagConstraints buttonGBC;
	private Label label;
	private static int MAX_WIDTH;

	public PulldownList(String[] listItems,int pulledListRow,String selectedItem) {
		this(listItems,ButtonType.PULLDOWN_LIST, pulledListRow, selectedItem);
	}

	public PulldownList(String[] listItems,ButtonType type,int pulledListRow,String selectedItem) {
		listRows = shrinkedListRow;
		this.pulledListRow = pulledListRow;
		this.pullButton = ButtonFactory.getButton(type,this);
		listInit(listItems);
		changeSelectItem(selectedItem);
		this.selectedItem = selectedItem;
	}


	public void paintPrepare() {
		Dimension d = this.list.getPreferredSize(this.listRows);
		if(PulldownList.MAX_WIDTH < d.width) {
			MAX_WIDTH = d.width;
		}
		int fontSize = PropertyDialog.PROPERTY_FONT_SIZE;
		this.list.setSize(PulldownList.MAX_WIDTH, d.height);
		this.pullButton.setSize(fontSize+10, fontSize+10);
	}
	public void paintPrepare(GridBagLayout layout) {
		paintPrepare();
		layout.setConstraints(label,labelGBC);
		layout.setConstraints(list, listGBC);
		layout.setConstraints(pullButton, buttonGBC);

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

	//gbc accessor
	public void setListGBC(GridBagConstraints gbc) {
		this.listGBC = gbc;
	}
	public GridBagConstraints getListGBC() {
		return this.listGBC;
	}
	public void setButtonGBC(GridBagConstraints gbc) {
		this.buttonGBC = gbc;
	}
	public GridBagConstraints getButtonGBC() {
		return this.buttonGBC;
	}
	public void setLabelGBC(GridBagConstraints gbc) {
		this.labelGBC = gbc;
	}
	public GridBagConstraints getLabelGBC() {
		return this.labelGBC;
	}
	//label accessor
	public void setLabel(Label label) {
		this.label = label;
	}
	public Label getLabel() {
		return this.label;
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
