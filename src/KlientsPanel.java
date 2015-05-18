import java.awt.Color;
import java.awt.GridLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class KlientsPanel extends JPanel implements ActionListener, ItemListener, ListSelectionListener{
	
	public ArrayList<VariantsPanel> paneluSaraksts = new ArrayList<VariantsPanel>();
	JLabel label1;
	JComboBox comboBox;
	JLabel label2;
	JList list;
	JLabel label3;
	JTextField adrese;
	JButton poga;
	JPanel bilesuPanel;
	JButton iesniegt;
	VariantsPanel variantsPanel;
	
	//SpeleServeris serv = new SpeleServeris();
	
	
	public KlientsPanel(){
		this.setLayout(null);
		
		label1 = new JLabel("Cik variantus vçlaties pirkt?");
		label1.setBounds(0,0,200,20);
		this.add(label1);
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(0,30,100,20);
		comboBox.addItem("0");
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItemListener(this);
		this.add(comboBox);
		
		label2 = new JLabel("Iezîmçjiet, kurus variantus generçt");
		label2.setBounds(0,60,200,20);
		this.add(label2);
		
		list = new JList();
		list.setBounds(0,90,100,100);
		list.addListSelectionListener(this);
		this.add(list);
		
		label3 = new JLabel("Biïetes nopirkðanas vieta");
		label3.setBounds(250,60,200,20);
		this.add(label3);
		
		adrese = new JTextField("Ventspils Pasts -term. 1000");
		adrese.setBounds(250,90,200,20);
		this.add(adrese);
		
		bilesuPanel = new JPanel();
		bilesuPanel.setLayout(null);
		bilesuPanel.setBounds(0,0,1000,700);
				
		iesniegt = new JButton("Iesniegt");
		iesniegt.setBounds(10,500,100,30);
		this.add(iesniegt);
		
		try{
			//client socket - 2.
			Socket clientSoc = new Socket("localhost", 8090);
			
			// get streams - 3.
			OutputStream oS = clientSoc.getOutputStream();
			InputStream iS = clientSoc.getInputStream();
							
			ObjectOutputStream oOS = new ObjectOutputStream(oS);
			ObjectInputStream oIS = new ObjectInputStream(iS);
							
			//sent message - 4.
			String mess = oIS.readObject().toString();
			JOptionPane.showMessageDialog(null, mess);
			
		}catch (Exception e) {
            System.err.println("Client Error: " + e.getMessage());
        }
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(iesniegt)){
			//nosuta izveletos skaitljus uz serv
		}
		
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(comboBox)){
			DefaultListModel model = new DefaultListModel();
			list.setModel(model);
			bilesuPanel.removeAll();
			for (int i=0; i<comboBox.getSelectedIndex(); i++){
				variantsPanel = new VariantsPanel();
				variantsPanel.setBounds(i*300,200,290,290);
				bilesuPanel.add(variantsPanel);
				paneluSaraksts.add(variantsPanel);
				model.addElement(i+1 + ". Variants");
				
			}
			this.add(bilesuPanel);
			
			this.repaint();
			this.validate();
		}
	}


	int sk = 0;
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource().equals(list)){
			sk++;
			if (sk%2==0){ // lai neatkartojas 2 reizes
				int index = list.getSelectedIndex();
				System.out.println("Indekss: " + index);
				paneluSaraksts.get(index+1).generetSkaitlus(); // mainot + mainaas cik paneljiem darbojas ???? 
				
				//System.out.println(paneluSaraksts.get(indx).skaitluPogas[0].getText());
				
				this.repaint();
				this.revalidate();
			}		
		}
	}
}
