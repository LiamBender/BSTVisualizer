package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import datastructure.BST;

public class MainFrame extends JFrame {

	public MainFrame() {
		setTitle("BST Visualizer");
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		BST<Integer> bst = new BST<>();

		ControlPanel controlPanel = new ControlPanel();
		TreePanel treePanel = new TreePanel(bst);

		setLayout(new BorderLayout());

		add(controlPanel, BorderLayout.NORTH);
		add(treePanel, BorderLayout.CENTER);

		controlPanel.getAddButton().addActionListener(e -> {

			try {
				int value = Integer.parseInt(controlPanel.getInputField().getText());

				bst.add(value);
				treePanel.repaint();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Enter a valid integer.", "Invalid Input",
						JOptionPane.ERROR_MESSAGE);
			}

			controlPanel.getInputField().setText("");
		});

		controlPanel.getRemoveButton().addActionListener(e -> {
			try {
				int value = Integer.parseInt(controlPanel.getInputField().getText());

				bst.remove(value);
				treePanel.repaint();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Enter a valid integer.", "Invalid Input",
						JOptionPane.ERROR_MESSAGE);
			}

			controlPanel.getInputField().setText("");
		});

		controlPanel.getClearButton().addActionListener(e -> {
			bst.clear();
			treePanel.repaint();
			controlPanel.getInputField().setText("");
		});

		controlPanel.getZoomInButton().addActionListener(e -> {
			treePanel.zoomIn();
		});

		controlPanel.getZoomOutButton().addActionListener(e -> {
			treePanel.zoomOut();
		});

		controlPanel.getFindMaxButton().addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "The largest number is: " + bst.findMax());
		});

		controlPanel.getFindMinButton().addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "The smallest number is: " + bst.findMin());
		});

		setVisible(true);
	}
}
