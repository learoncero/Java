package at.fhv.itb.lro3572;

import java.awt.*;

public class Axis {
	private double _xScale;
	private double _yScale;
	
	public Axis() {
		_xScale = 0;
		_yScale = 0;
	}
	
	public double getxScale() {
		return _xScale;
	}

	public void setxScale(double xScale) {
		_xScale = xScale;
	}

	public double getyScale() {
		return _yScale;
	}

	public void setyScale(double yScale) {
		_yScale = yScale;
	}

	public int convertX(double x) {
		return (int) (x * _xScale);
	}
	
	public int convertY(double y) {
		return (int) (y * _yScale);
	}
	
	public void draw(Graphics g, int width, int height) {
		int border = 40;
		int midWidth = width/2;
		int midHeight = height/2;
		
		// draw axis
		g.setColor(Color.BLACK);
		g.drawLine(border, midHeight, width - border, midHeight);
		g.drawLine(midWidth, border, midWidth, height - border);
		
		// labelling axis with "x" and "y"
		g.drawString("x", width - border, midHeight + 15);
		g.drawString("y", midWidth + 15, border);
		
		int axisLengthX = width - 2*border;
		int axisLengthY = height - 2* border;
		int strokeLength = 5;
		
		// labelling X axis
		_xScale = (axisLengthX - 10) / 25;
		for (int x = -10; x <= 10; x += 1) {
			int xPosition = midWidth + (x * (int) _xScale);
			String label = Integer.toString(x);
			g.drawLine(xPosition, midHeight  + strokeLength, xPosition, midHeight - strokeLength);
			g.drawString(label, xPosition - 5, midHeight + 20);
		}
		
		// labelling Y axis
		_yScale = (axisLengthY - 10) / 165;
		for (int y = -80; y <= 80; y += 20) {
			int yPosition = midHeight - (y * (int) _yScale);
			String label = null;
			if (y == 0) {
				label = " ";
			}
			else {
				label = Integer.toString(y);
			}
			g.drawLine(midWidth + strokeLength, yPosition, midWidth - strokeLength, yPosition);
			g.drawString(label, midWidth + 8, yPosition + 5);
		}
	}
}
