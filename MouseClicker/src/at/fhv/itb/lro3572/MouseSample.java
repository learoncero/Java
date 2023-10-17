package at.fhv.itb.lro3572;

import java.awt.*;
import java.awt.event.*;

public class MouseSample extends Frame {
	private static final long serialVersionUID = 1L;
	
	public MouseSample() {
		setSize(400, 400);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Click: " + e);
			}
		});
	}

	public static void main(String[] args) {
		MouseSample s = new MouseSample();
		s.setVisible(true);
		
	}
}
