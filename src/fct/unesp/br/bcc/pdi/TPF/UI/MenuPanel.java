package fct.unesp.br.bcc.pdi.TPF.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout.Group;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuPanel extends GeneralJPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8146979500357124344L;

	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem menuOpen;
	private JMenuItem menuSaveAs;
	private JMenuItem menuExportRedChannel;
	private JMenuItem menuExportBlueChannel;
	
	@Override
	public void init() {
		menuBar = new JMenuBar();
		menuFile = new JMenu();
		menuOpen = new JMenuItem();
		menuSaveAs = new JMenuItem();
		menuExportRedChannel = new JMenuItem();
		menuExportBlueChannel = new JMenuItem();
	}

	@Override
	public void initComponents() {
		menuFile.setText("Arquivo");
		
		menuOpen.setText("Abrir");
		
		menuSaveAs.setText("Salvar como");
		
		menuExportRedChannel.setText("Exportar vermelho");
		menuExportBlueChannel.setText("Exportar azul");
		menuBar.add(menuFile);
		
		menuFile.add(menuOpen);
		//menuFile.add(menuSaveAs);
		//menuFile.add(menuExportRedChannel);
		//menuFile.add(menuExportBlueChannel);
		
		menuOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser JFC = new JFileChooser();
				FileNameExtensionFilter extensionFilter = 
						new FileNameExtensionFilter("PNM", "pgm", "ppm");
				JFC.setFileFilter(extensionFilter);
				JFC.setFileSelectionMode(JFileChooser.FILES_ONLY);
				if(JFC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
					((Frame)getTopLevelAncestor()).openFile(JFC.getSelectedFile().getAbsolutePath());
			}
		});
	}

	@Override
	public void setComponents() {
		Group verticalGroup = layout.createSequentialGroup();
		Group horizontalGroup = layout.createSequentialGroup();
		
		verticalGroup.addComponent(menuBar, 20,20,20);
		horizontalGroup.addComponent(menuBar, 100,100,Integer.MAX_VALUE);
		
		setVerticalGroup(verticalGroup);
		setHorizontalGroup(horizontalGroup);
	}

}
