package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import datastructure.BST;

public class TreePanel extends JPanel {

	private static final int LEVEL_GAP = 80;
	private static final int MIN_OFFSET = 40;

	private BST<Integer> bst;
	private double zoom = 1.0;

	public TreePanel(BST<Integer> bst) {
		this.bst = bst;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.translate(getWidth() / 2, 50);
		g2.scale(zoom, zoom);

		drawNode(g2, bst.getRoot(), 0, 0, getWidth() / 4);
	}

	public void zoomIn() {
		zoom += 0.1;
		repaint();
	}

	public void zoomOut() {
		if (zoom > 0.2) {
			zoom -= 0.1;
			repaint();
		}
	}

	private void drawNode(Graphics g, BST<Integer>.BSTNode node, int x, int y, int offset) {
		if (node == null) {
			return;
		}

		int nextOffset = Math.max(offset / 2, MIN_OFFSET);

		g.drawOval(x - 20, y - 20, 40, 40);
		g.drawString(node.getItem().toString(), x - 7, y + 5);

		if (node.getLeft() != null) {
			int childX = x - offset;
			int childY = y + LEVEL_GAP;

			g.drawLine(x, y + 20, childX, childY - 20);
			drawNode(g, node.getLeft(), childX, childY, nextOffset);
		}

		if (node.getRight() != null) {
			int childX = x + offset;
			int childY = y + LEVEL_GAP;

			g.drawLine(x, y + 20, childX, childY - 20);
			drawNode(g, node.getRight(), childX, childY, nextOffset);
		}
	}

}
