package dc2_4.dialog;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ColorComboBox<T> extends JComboBox<T>{

	private ColorComboBox() {}
	private ColorComboBox(DefaultComboBoxModel<T> CBModel) {
		super(CBModel);
	}

	public static ColorComboBox<ColorLabel> getColorComboBox(String[] colorList) {

		//results
		ColorComboBox<ColorLabel> box;

		DefaultComboBoxModel<ColorLabel> CBModel = new DefaultComboBoxModel<ColorLabel>();
		for(String color : colorList) {
			CBModel.addElement(new ColorLabel(color));
		}

		box = new ColorComboBox<ColorLabel>(CBModel);
		box.setRenderer(new MyCellRenderer());

		return box;
	}

	public String getSelectedColorItem() {
		ColorLabel label = (ColorLabel)super.getSelectedItem();
		return label.getColorName();
	}
	public void setSelectedColorItem(String color) {
		ColorLabel label = new ColorLabel(color);
		super.setSelectedItem(label);
	}

	private static class MyCellRenderer extends JLabel implements ListCellRenderer {
	    MyCellRenderer(){
	        setOpaque(true);
	      }
		@Override
		public Component getListCellRendererComponent(
				JList list,
				Object value,
				int index,
				boolean isSelected,
				boolean cellHasFocus) {

			ColorLabel label = (ColorLabel)value;

			this.setIcon(label.getColorChip());
			this.setText(label.getColorName());

			if(isSelected) {
		        setForeground(Color.black);
		        setBackground(Color.gray);
			} else {
				setForeground(Color.black);
		        setBackground(Color.white);
			}

			return this;
		}

	}
}
