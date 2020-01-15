package dc1_4;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PulldownList extends Applet{
	protected List list;
	protected int shrinkedListRow = 1;
	protected int pulledListRow;
	protected int listRows;
	protected String selectedItem;
	private GridBagConstraints labelGBC;
	private GridBagConstraints listGBC;
	private GridBagConstraints paretGBC;
	private Label label;
	private Label paretLabel;
	private String listName;

	public PulldownList(String[] listItems,int pulledListRow,String selectedItem,String listName) {
		this.listName = listName;
		listRows = shrinkedListRow;
		this.pulledListRow = pulledListRow;
		listInit(listItems);
		changeSelectItem(selectedItem);
		this.selectedItem = selectedItem;
		paintPrepare();
	}


	public void paintPrepare() {
		Dimension d = this.list.getPreferredSize(this.listRows);
		this.list.setSize(d.width+20,d.height);
	}
	public void paintPrepare(GridBagLayout layout) {
		paintPrepare();
		layout.setConstraints(label,labelGBC);
		layout.setConstraints(list, listGBC);
		layout.setConstraints(paretLabel, paretGBC);

	}

	public List getList() {
		return this.list;
	}
	public String getSelectedItem() {
		return this.selectedItem;
	}

	//gbc settor
	public void setListGBC(GridBagConstraints gbc) {
		this.listGBC = gbc;
	}
	public void setLabelGBC(GridBagConstraints gbc) {
		this.labelGBC = gbc;
	}
	public void setParetGBC(GridBagConstraints gbc) {
		this.paretGBC = gbc;
	}

	//label accessor
	public void setLabel(Label label) {
		this.label = label;
	}
	public void setParetLabel(Label paretLabel) {
		this.paretLabel = paretLabel;
	}

	private void listInit(String[] items) {
		List tmpList = new List(listRows,false);
		tmpList.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1) {
					//pull action
					if(listRows == shrinkedListRow) {
						listRows = pulledListRow;
					}
				} else if (e.getClickCount() == 2) {
					changeSelectItem(selectedItem);
				}
				paintPrepare();
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}

		});
		tmpList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectItem = e.getActionCommand();
				changeSelectItem(selectItem);
				selectedItem = selectItem;
				listRows=1;
				if(listName.contains("Color")) {
					paretLabel.setBackground(DigitalClock.property.toColor(selectItem));
				}
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
