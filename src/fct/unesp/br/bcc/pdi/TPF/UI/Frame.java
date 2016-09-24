package fct.unesp.br.bcc.pdi.TPF.UI;

import fct.unesp.br.bcc.pdi.TPF.fileTypes.PNM;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;

public class Frame extends JFrame{
	
	private static final long serialVersionUID = -3450138015387473519L;
	
	GeneralJPanel mainPanel;
	
	public Frame(){
		super();
		init();
	}
	
	private void init(){
		setResizable(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("BitPhotoFilter");
		setSize(400, 300);		
		
		mainPanel = new MainPanel();
		add(mainPanel);		
		setVisible(true);
	}
	
	public void openFile(String filePath){
            ((MainPanel)mainPanel).openImage(filePath);
	}
        
        public void saveFile(String filePath) throws IOException{
            ((MainPanel)mainPanel).saveImage(filePath);
        }
        
        public PNM getImage(){
            return ((MainPanel)mainPanel).getImage();
        }
	
	public static void main(String args[]){
		new Frame();
	}
}
