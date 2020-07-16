package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.FrameController;

public class SelectFrame extends JFrame{

	public SelectFrame(ActionListener e) {

		setSize(800,600);

		JPanel panel = new JPanel();

		panel.add(getButton(FrameController.ARRAY,e));
		panel.add(getButton(FrameController.SINGLE_INSTANCE,e));
		panel.add(getButton("exit",new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動生成されたメソッド・スタブ
				System.exit(0);
			}
		}));

		this.add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JButton getButton(String name,ActionListener e) {
		JButton button = new JButton(name);
		button.setSize(100, 30);
		button.addActionListener(e);
		button.setVisible(true);
		return button;
	}

}
