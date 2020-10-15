import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D.Float;


public class DrawObject extends Canvas implements MouseListener {

	private float _x, _y; 
	private int _clickCounter;
	private int  _sizeX, _sizeY;
	
	

	public DrawObject(int _sizeX, int _sizeY) {
		_x = _y;
		_clickCounter = 0;
		this._sizeX = _sizeX;
		this._sizeY = _sizeY;
		setSize(_sizeX,_sizeX);
		setBackground(Color.green);
		addMouseListener(this);
		
	}
		
	@Override
	public void paint(Graphics g) {
		if (_x == 0 && _y == 0) return;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(2.5F));
		Rectangle rectangle = new Rectangle((int)_x,(int) _y, 50,50);
//		Ellipse2D ellipse2D = new Ellipse2D.Float(
//				_x,_y,
//				50,50)
//				;
		
//		g2d.draw(ellipse2D);	
		g2d.draw(rectangle);
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
