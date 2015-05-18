import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;


public class VariantsPanel extends JPanel implements ActionListener{
	
	int nospiestas_pogas=0;
	JButton[] skaitluPogas = new JButton[35];
	Random ran = new Random();
	Variants variants = new Variants();
	
	public VariantsPanel(){
		this.setLayout(new GridLayout(6,6));
				
		for (int i=0; i<35; i++){
			skaitluPogas[i] = new JButton(i+1 + ""); 
			this.add(skaitluPogas[i]);	
			skaitluPogas[i].addActionListener(this);
		}

		
		//generetSkaitlus();
	}
	
	public void generetSkaitlus(){
		ArrayList<Integer> tempMas = new ArrayList<Integer>();
		for(int i = 0; i<35; i++){
			tempMas.add(i+1);
		}
		
		for (int i=0;i<5;i++){
			int sk = ran.nextInt(tempMas.size())+1;
			variants.skaitli.add(sk);
			tempMas.remove(sk-1);
			skaitluPogas[sk-1].setBackground(Color.blue);
			nospiestas_pogas++;
			System.out.print(variants.getSkaitli());
			System.out.println(nospiestas_pogas);
			
			this.repaint();
			this.revalidate();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i=0; i<35; i++){
			if (e.getSource().equals(skaitluPogas[i])){
				if(!(skaitluPogas[i].getBackground().equals(Color.blue)) && nospiestas_pogas<5){
					variants.skaitli.add(Integer.parseInt(skaitluPogas[i].getText()));
					skaitluPogas[i].setBackground(Color.blue);
					nospiestas_pogas++;
					System.out.print(variants.getSkaitli());
					System.out.println(nospiestas_pogas);
					
				}
				else{
					int temp=i+1;
					if(variants.skaitli.contains(new Integer(temp))){
						variants.skaitli.remove(variants.skaitli.indexOf(temp));
						skaitluPogas[i].setBackground(null);
						nospiestas_pogas--;
						System.out.print(variants.getSkaitli());
						System.out.println(nospiestas_pogas);
					}
				}
			}
		}
	}		
}
