package MousePosition;

import java.awt.*;
import java.awt.event.*;

public class MousePositioner extends Frame {
	private static final long serialVersionUID = 1L;

	public MousePositioner() {
		initFrame();
		initPanels();
	}
	
	private void initFrame() {
		setTitle("Mouse Positioner");
		setSize(400, 400);
		setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void initPanels() {
		Panel labelPanel = new Panel();
		Label xCoordinateLabel = new Label("x");
		Label xCoordinateLabel2 = new Label("    ");
		Label yCoordianteLabel = new Label("y");
		Label yCoordinateLabel2 = new Label("    ");
		Label eventLabel = new Label("Event");
		Label eventLabel2 = new Label("            ");
		
		labelPanel.add(xCoordinateLabel);
		labelPanel.add(xCoordinateLabel2);
		labelPanel.add(yCoordianteLabel);
		labelPanel.add(yCoordinateLabel2);
		labelPanel.add(eventLabel);
		labelPanel.add(eventLabel2);
		
		add(labelPanel, BorderLayout.NORTH);

		Panel mousePanel = new Panel();
		mousePanel.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Integer xCoordinate = e.getX();
				Integer yCoordinate = e.getY();
				xCoordinateLabel2.setText(xCoordinate.toString());
				yCoordinateLabel2.setText(yCoordinate.toString());
				eventLabel2.setText("Dragged");
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				Integer xCoordinate = e.getX();
				Integer yCoordinate = e.getY();
				xCoordinateLabel2.setText(xCoordinate.toString());
				yCoordinateLabel2.setText(yCoordinate.toString());
				eventLabel2.setText("Moved");
			}
		});
		
		add(mousePanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		MousePositioner mp = new MousePositioner();
		mp.setVisible(true);
	}
}
