import java.awt.*;
import java.awt.event.*;

import javax.swing.BoxLayout;

public class MainWindow extends Frame implements WindowListener {
	
	private int _x, _y;
	private Label statusLabel;
	private Panel controlPanel;
	static String objektGroeﬂe;
	
	
	public MainWindow(int windowSizeX, int windowSizeY) {
		this._x = windowSizeX;
		this._y = windowSizeY;
		setTitle("Programm f¸r Softwaretechnik");
		setSize(_x,_y);

		addWindowListener(this);
		DrawObject d = new DrawObject(_x-100, _y-100);
		add(d);
			
		MainMenuBar mmB = new MainMenuBar(d);
		setMenuBar(mmB);
				
		setLayout(new FlowLayout());
			 
		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(600,100);
		 
		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());
		 
		add(controlPanel);
		add(statusLabel);
		 
		Label frage = new Label("Wie Groﬂ soll der Kreis werden?: ", Label.CENTER);
		final TextField antwortText = new TextField(6);
		Button antwortButton = new Button("senden");
		antwortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = antwortText.getText();
				statusLabel.setText(data);
				System.out.println(statusLabel.getText());
				objektGroeﬂe = statusLabel.getText();
				System.out.println("String ausgegeben: " +objektGroeﬂe);
			 }
		});

		 controlPanel.add(frage);
		 controlPanel.add(antwortText);
		 controlPanel.add(antwortButton);	 
	}
		
	public int getX () {
		return _x;
	}
	
	public int getY () {
		return _y;
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
