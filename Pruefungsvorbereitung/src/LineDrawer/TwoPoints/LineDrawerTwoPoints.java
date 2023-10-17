package LineDrawer.TwoPoints;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class LineDrawerTwoPoints extends Frame {
	private static final long serialVersionUID = 1L;
	private LinkedList<Point> _points;
	
	public LineDrawerTwoPoints() {
		initFrame();
	}
	
	private void initFrame() {
		_points = new LinkedList<>();
		
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
				_points.add(e.getLocationOnScreen());
				
				if (_points.size() == 2) {
					repaint();
				}
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (_points.size() == 2) {
			Point point1 = _points.get(0);
			Point point2 = _points.get(1);
			
			g.drawLine((int)point1.getX(), (int)point1.getY(), (int)point2.getX(), (int)point2.getY());
			_points.clear();
		}
		
	}
	
	public static void main(String[] args) {
		LineDrawerTwoPoints ld = new LineDrawerTwoPoints();
		ld.setVisible(true);
	}
	
}
