package fct.unesp.br.bcc.pdi.TPF.UI;

import fct.unesp.br.bcc.pdi.TPF.code.PNMManager;
import java.awt.Color;
import javax.swing.JFrame;

public class FrameTools extends JFrame{
	
	private static final long serialVersionUID = -3450138015387473519L;
	
	private GeneralJPanel mainPanel;
        private Frame mainFrame;
        
	public FrameTools(PNMManager manager, Frame mainFrame){
		super();
		init(manager, mainFrame);
	}
	
	private void init(PNMManager manager, Frame mainFrame){
		setResizable(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Ferramentas");
		setSize(500, 400);		
		
		mainPanel = new MainPanel();
                add(new ToolsPanel(manager, mainFrame));
		
		setVisible(true);
	}
}
