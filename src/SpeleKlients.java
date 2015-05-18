import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class SpeleKlients extends JFrame implements ActionListener{
	
	JMenuBar jmenuBar;
	JMenuItem pirktBileti;
	
	public SpeleKlients(){
		this.setLayout(null);
		this.setBounds(0,0,1200,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//menubar
		jmenuBar = new JMenuBar();
		jmenuBar.setBounds(0,0,this.getWidth(),30);
		
		pirktBileti = new JMenuItem("Pirkt Bileti");
		pirktBileti.setBounds(0,0,1,30);
		pirktBileti.addActionListener(this);
		jmenuBar.add(pirktBileti);

		this.add(jmenuBar);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(pirktBileti)){
			//KlientsPanel
			KlientsPanel klientsPanel = new KlientsPanel();
			klientsPanel.setBounds(0,30,1200,700);
			this.add(klientsPanel);
			
			this.repaint();
			this.validate();
			
		}
		
	}
}
