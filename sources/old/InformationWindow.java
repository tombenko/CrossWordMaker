package DialogWindows.InformationWindow;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

class InformationWindow extends JFrame{
	
	public InformationWindow(String title, String text){
		initWindow(title, text);
	}
	
	private void initWindow(String title, String text){
		JButton button = new JButton("OK");
		setLayout(new GridLayout(2,1));
		add(new JLabel(text));
		add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		setTitle(title);
		pack();
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void dispose(){
		super.dispose();
	}
}
