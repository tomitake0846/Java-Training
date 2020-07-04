package gui.arrayPanel;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import controller.ArrayItem;
import gui.panels.ItemPanel;

public class ArrayItemPanel extends ItemPanel{

	private ArrayItem arrayItem;

	public ArrayItemPanel(ArrayItem ai) {
		this.arrayItem = ai;

		setLayout(new GridLayout(1,2));

		JLabel indexLabel = new JLabel(""+ai.getIndex());
		JLabel toStringLabel = new JLabel(ai.toString());

		add(indexLabel);
		add(toStringLabel);

		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("clicked");
		arrayItem.run();
	}

}
