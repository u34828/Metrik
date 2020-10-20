import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

// erzeugt: Canvas Objekt als Zeichengrundlage

public class DrawObject extends Canvas implements MouseListener { 

	private float _x, _y; 
	private int _clickCounter;
	private int  _sizeX, _sizeY;
	float circle1x = 0;
	float circle1y = 0;
	float circle2x = 0;
	float circle2y = 0;
	
	public DrawObject(int _sizeX, int _sizeY) {
		_x = _y;
		_clickCounter = 0;
		this._sizeX = _sizeX;
		this._sizeY = _sizeY;
		setSize(_sizeX,_sizeX);
		setBackground(Color.lightGray);
		addMouseListener(this);
	    setVisible(true); 
	    //Test initial
	} // Constructor
	
		
	@Override
	public void paint(Graphics g) {
		if (_x == 0 && _y == 0) return;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(2.5F));
		Ellipse2D ellipse2D = new Ellipse2D.Float(
				_x,_y,
				50,50
				);
		
		g2d.draw(ellipse2D);
		
		if (_clickCounter == 0) {
			g2d.drawString ("Koordinate Kreis 1 - X: "+_x, _x+50, _y);
			g2d.drawString ("Koordinate Kreis 1 - Y: "+_y, _x+50, _y+20);
			circle1x = _x;
			circle1y = _y;
		} 
		
		if (_clickCounter == 1) {
			g2d.drawString ("Koordinate Kreis 2 - X: "+_x, _x+50, _y);
			g2d.drawString ("Koordinate Kreis 2 - Y: "+_y, _x+50, _y+20);
			circle2x = _x;
			circle2y = _y;	

			float distance = (float) Math.sqrt(((circle2y-circle1y)*(circle2y-circle1y))+((circle2x-circle1x)*(circle2x-circle1x)));		
			distance = (float) (distance + 0.005);
			distance = (int)(distance*100);
			distance = distance / 100;
			g2d.drawString("Distanz zwischen den Kreisen: " + distance, 10, 30);
		}
		if (_clickCounter > 1) {
			g2d.clearRect(0, 0, _sizeX, _sizeY);
			_clickCounter = -1;
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		_x = e.getX();
		_y = e.getY();	
        paint(getGraphics());
        _clickCounter++; 
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}
}
