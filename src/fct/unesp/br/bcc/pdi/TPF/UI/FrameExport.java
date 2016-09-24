package fct.unesp.br.bcc.pdi.TPF.UI;

import fct.unesp.br.bcc.pdi.TPF.fileTypes.PNM;
import java.awt.Color;
import javax.swing.JFrame;

public class FrameExport extends JFrame{
	
	private static final long serialVersionUID = -3450138015387473519L;
	
	public FrameExport(PNM image){
		super();
		init(image);
	}
	
	private void init(PNM image){
		setResizable(true);
                setSize(210,220);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Exportar");		
                add(new ExportPanel(image));
		
		setVisible(true);
	}

}
