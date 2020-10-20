import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

// erzeugt: Canvas Objekt als Zeichengrundlage

public class DrawObject extends Canvas implements MouseListener { 

	private float _x, _y; 
	private int _clickCounter;
	private int _sizeX, _sizeY;
	
	// Variablen für Größenanpassung Objekte
	String objectSize;
	
	// Variablen für Distanzberechnung
	float circle1x = 0;
	float circle1y = 0;
	float circle2x = 0;
	float circle2y = 0;

	// Variablen für Linie zwischen den Kreisen
	private float _x1;
	private float _x2;
	private float _y1;
	private float _y2;
	
	public DrawObject(int _sizeX, int _sizeY) {
		_x = 0;
		_y = 0;
		_clickCounter = 0;
		this._sizeX = _sizeX;
		this._sizeY = _sizeY;
		this.objectSize = MainWindow.getObjektGroeße();
		setSize(_sizeX,_sizeX);
		setBackground(Color.lightGray);
		addMouseListener(this);
	    setVisible(true); 
	} // Constructor
			
	@Override
	public void paint(Graphics g) {
		if (_x == 0 && _y == 0) return;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(2.5F));
		objectSize = MainWindow.getObjektGroeße();
		float diameter = Float.parseFloat(objectSize);
		Ellipse2D ellipse2D = new Ellipse2D.Float(
				_x,_y,
				diameter,diameter
				);
		g2d.draw(ellipse2D);
	
		// Koordinaten anzeigen
		if (_clickCounter == 0) {
			g2d.drawString ("Koordinate Kreis 1 - X: "+_x, _x+diameter, _y);
			_x1 = _x;
			_y1 = _y;
			g2d.drawString ("Koordinate Kreis 1 - Y: "+_y, _x+diameter, _y+20);
			circle1x = _x;
			circle1y = _y;
		} 		
		if (_clickCounter == 1) {
			g2d.drawString ("Koordinate Kreis 2 - X: "+_x, _x+diameter, _y);
			_x2 = _x;
			_y2 = _y;
			g2d.drawString ("Koordinate Kreis 2 - Y: "+_y, _x+diameter, _y+20);
			circle2x = _x;
			circle2y = _y;	

			//Distance berechnen
			float distance = (float) Math.sqrt(((circle2y-circle1y)*(circle2y-circle1y))+((circle2x-circle1x)*(circle2x-circle1x)));		
			distance = (float) (distance + 0.005);
			distance = (int)(distance*100);
			distance = distance / 100;
			g2d.drawString("Distanz zwischen den Kreisen: " + distance, 10, 30);

			// Linie zwischen 2 Kreisen
			g.setColor(Color.blue);   
	        g.drawLine((int)_x1+(int)diameter/2 , (int)_y1+(int)diameter/2, (int)_x2+(int)diameter/2, (int)_y2+(int)diameter/2); 
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
