package at.fhv.itb.lro3572;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ViewPolynom {
	private MathPolynom _mathPolynom;
	private Axis _axis;
	private Color[] _colors;
	private static int _indexColors = 0;
	
	public ViewPolynom(MathPolynom mathPolynom, Axis axis) {
		_mathPolynom = mathPolynom;
		_axis = axis;
		_colors = new Color[] {Color.RED, Color.CYAN, Color.GREEN, Color.ORANGE, Color.BLUE, Color.MAGENTA, Color.LIGHT_GRAY};
	}
	
	public MathPolynom getMathPolynom() {
		return _mathPolynom;
	}

	public void setMathPolynom(MathPolynom mathPolynom) {
		_mathPolynom = mathPolynom;
	}

	public Axis getAxis() {
		return _axis;
	}

	public void setAxis(Axis axis) {
		_axis = axis;
	}
	
	public static int get_indexColors() {
		return _indexColors;
	}

	public static void set_indexColors(int _indexColors) {
		ViewPolynom._indexColors = _indexColors;
	}

	public void draw(Graphics g, int width, int height) {
		int midWidth = width/2;
		int midHeight = height/2;
		Color color = _colors[_indexColors % _colors.length];
		_indexColors += 1;
		for (double x1 = -10; x1 <= 10; x1 += 0.1) {
			double x2 = x1 + 0.1;
			
			double y1 = _mathPolynom.calculateY(x1);
			double y2 = _mathPolynom.calculateY(x2);
			
			int roundedX1 = _axis.convertX(x1) + midWidth;
			int roundedX2 = _axis.convertX(x2) + midWidth;
			int roundedY1 = midHeight - _axis.convertY(y1);
			int roundedY2 = midHeight - _axis.convertY(y2);
			
			Graphics2D graph = (Graphics2D) g;
			graph.setColor(color);
			graph.setStroke(new BasicStroke(2));
			graph.drawLine(roundedX1, roundedY1, roundedX2, roundedY2);
		}
	}

	@Override
	public String toString() {
		return "ViewPolynom [_mathPolynom=" + _mathPolynom + ", _axis=" + _axis + "]";
	}
	
}
