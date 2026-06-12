package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControlPanel extends JPanel {

	private JTextField inputField;
	private JButton addButton;
	private JButton removeButton;
	private JButton clearButton;
	private JButton zoomInButton;
	private JButton zoomOutButton;

	public ControlPanel() {
		inputField = new JTextField(10);
		addButton = new JButton("Add");
		removeButton = new JButton("Remove");
		clearButton = new JButton("Clear");
		zoomInButton = new JButton("+");
		zoomOutButton = new JButton("-");

		add(inputField);
		add(addButton);
		add(removeButton);
		add(clearButton);
		add(zoomInButton);
		add(zoomOutButton);

	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getRemoveButton() {
		return removeButton;
	}

	public JButton getClearButton() {
		return clearButton;
	}

	public JTextField getInputField() {
		return inputField;
	}

	public JButton getZoomInButton() {
		return zoomInButton;
	}

	public JButton getZoomOutButton() {
		return zoomOutButton;
	}

}
