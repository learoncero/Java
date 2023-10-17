package LineDrawer.OnePoint;

import java.awt.*;
import java.awt.event.*;

public class LineDrawerOnePoint extends Frame {
	private static final long serialVersionUID = 1L;
	private Point _point;
	
	public LineDrawerOnePoint() {
		setTitle("Line Drawer");
		setSize(400, 400);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				_point = e.getLocationOnScreen();
				repaint();
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int x1 = 10;
		int y1 = (int)_point.getY();
		int x2 = getWidth() - 10;
		int y2 = (int)_point.getY();
		
		g.drawLine(x1, y1, x2, y2);
	}
	
	public static void main(String[] args) {
		LineDrawerOnePoint lineDrawer = new LineDrawerOnePoint();
		lineDrawer.setVisible(true);
	}
}
