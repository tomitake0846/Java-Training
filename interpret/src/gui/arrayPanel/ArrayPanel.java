package gui.arrayPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.ArrayItem;
import processing.interpret.InterpretException;

public class ArrayPanel extends JPanel{

	private JScrollPane scrollPane;
	private JPanel itemPanel;
	private int arraySize;

	public ArrayPanel() {
		itemPanel = new JPanel();
		this.scrollPane = new JScrollPane(itemPanel);

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}

	public void initArrayItemList(String type,String size) throws InterpretException{

		this.arraySize = parseSize(size);

		itemPanel.setLayout(new GridLayout(arraySize+1,1));
		itemPanel.add(getTitlePanel());

		for(int i=0;i<arraySize;i++) {
			ArrayItem item = new ArrayItem(type,i);
			ArrayItemPanel panel = new ArrayItemPanel(item);
			this.itemPanel.add(panel);
		}
	}

	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}
	public int getArraySize () {
		return this.arraySize;
	}

	public JPanel getScrolledPanel() {
		return this.itemPanel;
	}


	private JPanel getTitlePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		panel.add(new JLabel("Index"));
		panel.add(new JLabel("toString"));
		return panel;
	}

	private int parseSize(String size) throws InterpretException{
		int arraySize = 0;
		try {
			arraySize = Integer.parseInt(size);
		} catch (NumberFormatException e) {
			throw new InterpretException("Input value is not a number.",e);
		}
		if(arraySize <= 0) {
			throw new InterpretException("Input value is not a positive Integer.", new NegativeArraySizeException());
		}
		return arraySize;
	}
}
