package fct.unesp.br.bcc.pdi.TPF.UI;

import java.awt.Color;
import javax.swing.JFrame;

public class FrameTools extends JFrame{
	
	private static final long serialVersionUID = -3450138015387473519L;
	
	GeneralJPanel mainPanel;
	
	public FrameTools(){
		super();
		init();
	}
	
	private void init(){
		setResizable(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ferramentas");
		setSize(500, 400);		
		
		mainPanel = new MainPanel();
                add(new ToolsPanel());
		
		setVisible(true);
	}
	
	public static void main(String args[]){
		new FrameTools();
	}
}
