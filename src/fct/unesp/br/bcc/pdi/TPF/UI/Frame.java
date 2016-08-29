package fct.unesp.br.bcc.pdi.TPF.UI;

import java.awt.Color;
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
	
	public static void main(String args[]){
		new Frame();
	}
}
