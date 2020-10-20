import java.awt.*;
import java.awt.event.*;
import javax.swing.BoxLayout;

public class MainWindow extends Frame implements WindowListener {
	
	private int _x, _y;
	private Panel controlPanel;
	static String objektGroe�e;
		
	public MainWindow(int windowSizeX, int windowSizeY) {
		this._x = windowSizeX;
		this._y = windowSizeY;
		setTitle("Programm f�r Softwaretechnik");
		setSize(_x,_y);
		addWindowListener(this);
		
		DrawObject d = new DrawObject(_x-100, _y-100);
		add(d);
			
		MainMenuBar mmB = new MainMenuBar(d);
		setMenuBar(mmB);
				
		setLayout(new FlowLayout());
			 		 
		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());
		add(controlPanel);
	 
		Label frage = new Label("Wie Gro� soll der Kreis werden?: ", Label.CENTER);
		final TextField antwortText = new TextField(6);
		Button antwortButton = new Button("senden");
		antwortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				objektGroe�e = antwortText.getText();			
			 }
		});

		 controlPanel.add(frage);
		 controlPanel.add(antwortText);
		 controlPanel.add(antwortButton);
	 
	} // Construktor
		
	public int getX () {
		return _x;
	}
	
	public int getY () {
		return _y;
	}
	
	public static String getObjektGroe�e() {
		if (objektGroe�e == null) {
			return objektGroe�e = "50";
		}else {
			return objektGroe�e;
		}
	}
	
	public void openWindow() {
		setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		dispose();	//	Ressourcenfreigabe
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
}
