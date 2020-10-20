import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenuBar extends MenuBar implements ActionListener{
	
	private Menu _menu;
	private MenuItem _color1, _color2, _color3, _color4;
	private final Canvas _drawObject;
	
	public MainMenuBar(Canvas drawObject) {
		_menu = new Menu("Ändere die Hintergrundfarbe");
		this._drawObject = drawObject;

		_color1 = new MenuItem("Farbe: Rot");
		_color1.addActionListener(this);
		_menu.add(_color1);
		_color2 = new MenuItem("Farbe: Gelb");
		_color2.addActionListener(this);
		_menu.add(_color2);
		_color3 = new MenuItem("Farbe: Blau");
		_color3.addActionListener(this);
		_menu.add(_color3);
		_color4 = new MenuItem("Grundeinstellung");
		_color4.addActionListener(this);
		_menu.add(_color4);
				
		add(_menu);
		} //Construktor

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == _color1) {
			this._drawObject.setBackground(Color.red);
		}else if (e.getSource() == _color2) {
			this._drawObject.setBackground(Color.yellow);
		}else if (e.getSource() == _color3) {
			this._drawObject.setBackground(Color.blue);
		}else if (e.getSource() == _color4) {
			this._drawObject.setBackground(Color.lightGray);
		}
	}
}


