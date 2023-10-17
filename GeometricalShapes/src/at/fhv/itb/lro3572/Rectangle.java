/*
 *
 * Uebungsblatt 1
 * Aufgabe 1: Geometrische Figuren
 * 
 * Autor: Lea Roncero
 *
 * Datum: 20.03.2023 
 *
 */

package at.fhv.itb.lro3572;

import java.util.Arrays;

public class Rectangle {
	private Point _lowerLeft = new Point();
	private int _width;
	private int _height;
	
	// Methode 1: Erzeugen von Rechtecken, die an beliebigen Positionen stehen können
	public Rectangle(Point p1, Point p2) {
		this(p1, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	}
	
	// Methode 2: Erzeugen von Rechtecken, die an beliebigen Positionen stehen können
	public Rectangle(Point origin, int width, int height) {
		_lowerLeft = origin;
		_width = width;
		_height = height;
		
		if ((_width < 0) && (_height < 0)) {
			_width *= -1;
			_height *= -1;
			_lowerLeft.setX(_lowerLeft.getX() - _width);
			_lowerLeft.setY(_lowerLeft.getY() - _height);
		}
		else if (_height < 0) {
			_height *= -1;
			_lowerLeft.setY(_lowerLeft.getY() - _height);
		}
		else if (_width < 0) {
			_width *= -1;
			_lowerLeft.setX(_lowerLeft.getX() - _width);
		}
	}

	public Point get_lowerLeft() {
		return _lowerLeft;
	}

	public void set_lowerLeft(Point lowerLeft) {
		_lowerLeft = lowerLeft;
	}

	public int get_width() {
		return _width;
	}

	public void set_width(int width) {
		_width = width;
	}

	public int get_height() {
		return _height;
	}

	public void set_height(int height) {
		_height = height;
	}

	// Verschieben eines Rechtecks
	public void move(int xMove, int yMove) {
		_lowerLeft.setX(_lowerLeft.getX() + xMove);
		_lowerLeft.setY(_lowerLeft.getY() + yMove);
	}
	
	// Prüfen auf Quadrat-Eigenschaft
	public boolean isSquare() {
		return (_height == _width);
		}
	
	// Bestimmen des Umkreises eines Rechtecks
	public Circle getCircle() {
		Point center = new Point(_lowerLeft.getX() + _width/2, _lowerLeft.getY() + _height/2);
		double radius = (Math.sqrt(Math.pow(_width, 2) + Math.pow(_height, 2)));
		
		Circle c = new Circle(center, radius);
		
		return c;
		
	}
	
	// „Zoomen“ eines Rechtecks
	public void zoom(double zoomFactor) {
		_width *= zoomFactor;
		_height *= zoomFactor;
	}

	// Teilen in vier gleiche große Rechtecke
	public Rectangle[] divideIntoFour() {
		Rectangle first = new Rectangle(_lowerLeft, _width/2, _height/2);
		Rectangle second = new Rectangle(new Point(_lowerLeft.getX(), _lowerLeft.getY() + _height/2), _width/2, _height/2);
		Rectangle third = new Rectangle(new Point(_lowerLeft.getX() + _width/2, _lowerLeft.getY()), _width/2, _height/2);
		Rectangle fourth = new Rectangle(new Point(_lowerLeft.getX() + _width/2, _lowerLeft.getY() + _height/2), _width/2, _height/2);
		
		Rectangle[] fourRectangles = new Rectangle[] {first, second, third, fourth};
		
		return fourRectangles;
	}
	
	// Teilen entlang einer der Diagonalen in zwei Dreiecke
	public Triangle[] divideIntoTriangle(Point diagonal1, Point diagonal2) {
		Point remaining1 = new Point(diagonal1.getX() + _width, diagonal1.getY());
		Point remaining2 = new Point(diagonal1.getX(), diagonal1.getY() + _height);
		
		Triangle t1 = new Triangle(diagonal1, diagonal2, remaining1);
		Triangle t2 = new Triangle(diagonal1, diagonal2, remaining2);
		
		Triangle[] triangles = new Triangle[] {t1, t2};
		
		return triangles;
	}

	@Override
	public String toString() {
		return "Rectangle [_lowerLeft=" + _lowerLeft + ", _width=" + _width + ", _height=" + _height
				+ ", get_lowerLeft()=" + get_lowerLeft() + ", get_width()=" + get_width() + ", get_height()="
				+ get_height() + ", isSquare()=" + isSquare() + ", getCircle()=" + getCircle() + ", divideIntoFour()="
				+ Arrays.toString(divideIntoFour()) + "]";
	}

	public static void main(String[] args) {
		Point p1 = new Point(7, 2);
		Point p2 = new Point(1, 8);
		Rectangle r1 = new Rectangle(p1, p2);
		
		System.out.println("Circle: " + r1.getCircle()); 
		
		System.out.println("Rectangle r1: " + r1);	
		
		System.out.println("Is square? " + r1.isSquare());

		Triangle[] triangles = r1.divideIntoTriangle(p1, p2);
		System.out.println("Triangles" + triangles[1] + triangles[1]);
	}
}