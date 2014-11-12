package DialogWindows.DecideWindow;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

class DecideWindow{
	
	Boolean state;
	
	public DecideWindow(String questionText, Boolean stateReference){
		int i;
		String copyText = new String('');
		for(i=0; i<questionText.length; i++){
			copyText += questionText.charAt(i);
			if(i%20 = 0){
				copyText.concat("<p>");
			}
		}
		this.state = stateReference;
		initUI(copyText);
	}
	
	private void initUI(String displayText){
		JFrame frame = new JFrame();
		JButton yesButton = new JButton("Igen");
		JButton noButton = new JButton("Nem");
		setPress(yesButton, true);
		setPress(noButton, false);
		JPanel panel = new JPanel();
		frame.setLayout(new GridLayout(2,1));
		panel.setLayut(new Gridlayout(1,2));
		panel.add(noButton);
		panel.add(yesButton);
		frame.add(new JLabel(displayText));
		frame.add(panel);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void setPress(JButton button, boolean answer){
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
	
}
