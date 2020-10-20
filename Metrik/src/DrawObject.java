import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

// erzeugt: Canvas Objekt als Zeichengrundlage

public class DrawObject extends Canvas implements MouseListener { 

	private float _x, _y; 
	private int _clickCounter;
	private int  _sizeX, _sizeY;
	
	float _x1;
	float _x2;
	float _y1;
	float _y2;
	
	public DrawObject(int _sizeX, int _sizeY) {
		_x = _y;
		_clickCounter = 0;
		this._sizeX = _sizeX;
		this._sizeY = _sizeY;
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
		Ellipse2D ellipse2D = new Ellipse2D.Float(
				_x,_y,
				50,50
				);
		g2d.draw(ellipse2D);
		
		if (_clickCounter == 0) {
			g2d.drawString ("Koordinate Kreis 1 - X: "+_x, _x+50, _y);
			_x1 = _x;
			_y1 = _y;
			g2d.drawString ("Koordinate Kreis 1 - Y: "+_y, _x+50, _y+20);
		}
		
		if (_clickCounter == 1) {
			g2d.drawString ("Koordinate Kreis 2 - X: "+_x, _x+50, _y);
			_x2 = _x;
			_y2 = _y;
			g2d.drawString ("Koordinate Kreis 2 - Y: "+_y, _x+50, _y+20);
			g.setColor(Color.blue);   
	        g.drawLine((int)_x1+25 , (int)_y1+25, (int)_x2+25, (int)_y2+25); 
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
