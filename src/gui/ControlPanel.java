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
	private JButton findMaxButton;
	private JButton findMinButton;
	private JButton displayPreOrderButton;
	private JButton displayInOrderButton;
	private JButton displayPostOrderButton;

	public ControlPanel() {
		inputField = new JTextField(10);
		addButton = new JButton("Add");
		removeButton = new JButton("Remove");
		clearButton = new JButton("Clear");
		zoomInButton = new JButton("+");
		zoomOutButton = new JButton("-");
		findMaxButton = new JButton("Max");
		findMinButton = new JButton("Min");
		displayPreOrderButton = new JButton("Preorder");
		displayInOrderButton = new JButton("Inorder");
		displayPostOrderButton = new JButton("Postorder");

		add(inputField);
		add(addButton);
		add(removeButton);
		add(clearButton);
		add(zoomInButton);
		add(zoomOutButton);
		add(findMaxButton);
		add(findMinButton);
		add(displayPreOrderButton);
		add(displayInOrderButton);
		add(displayPostOrderButton);

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
	
	public JButton getFindMaxButton() {
		return findMaxButton;
	}
	
	public JButton getFindMinButton() {
		return findMinButton;
	}
	
	public JButton getDisplayPreOrderButton() {
		return displayPreOrderButton;
	}
	
	public JButton getDisplayInOrderButton() {
		return displayInOrderButton;
	}
	
	public JButton getDisplayPostOrderButton() {
		return displayPostOrderButton;
	}

}
