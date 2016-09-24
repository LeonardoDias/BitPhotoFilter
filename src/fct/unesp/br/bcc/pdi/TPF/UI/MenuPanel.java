package fct.unesp.br.bcc.pdi.TPF.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
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

	/*private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem menuOpen;
	private JMenuItem menuSaveAs;
	private JMenuItem menuExportRedChannel;
	private JMenuItem menuExportBlueChannel;
	*/
	
	private JButton buttonOpen;
	private JButton buttonSave;
	private JButton buttonExportChannels;
        private JButton ferramentasButton;
       
	
	@Override
	public void init() {
		
		buttonOpen = new JButton("Abrir");
		buttonSave = new JButton("Salvar");
		buttonExportChannels = new JButton("Exportar");
                ferramentasButton = new JButton("Ferramentas");
                
		/*
		menuBar = new JMenuBar();
		menuFile = new JMenu();
		menuOpen = new JMenuItem();
		menuSaveAs = new JMenuItem();
		menuExportRedChannel = new JMenuItem();
		menuExportBlueChannel = new JMenuItem();*/
	}

	@Override
	public void initComponents() {
		/*
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
		
		*/
		
		buttonOpen.setToolTipText("Open");
		buttonSave.setToolTipText("Save As");
		buttonExportChannels.setToolTipText("Export Channel");
                
		buttonOpen.addActionListener(new ActionListener() {
			
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
                
                buttonSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                            try {
                                JFileChooser JFC = new JFileChooser();
                                FileNameExtensionFilter extensionFilter =
                                        new FileNameExtensionFilter("PNM", "pgm", "ppm");
                                JFC.setFileFilter(extensionFilter);
                                JFC.setFileSelectionMode(JFileChooser.FILES_ONLY);
                                if(JFC.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                                    ((Frame)getTopLevelAncestor()).saveFile(JFC.getSelectedFile().getAbsolutePath());
                            } catch (IOException ex) {
                                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
                
                buttonExportChannels.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new FrameExport(((Frame)getTopLevelAncestor()).getImage());
                    }
                });
	}

	@Override
	public void setComponents() {
		Group verticalGroup = layout.createSequentialGroup();
		Group horizontalGroup = layout.createSequentialGroup();
		
		verticalGroup.addGap(5);
		verticalGroup.addGroup(layout.createParallelGroup()
			.addComponent(buttonOpen, 20,20,20)
			.addComponent(buttonSave, 20,20,20)
			.addComponent(buttonExportChannels, 20,20,20)
                        .addComponent(ferramentasButton,20,20,20));
		
		horizontalGroup.addGap(5);
		horizontalGroup.addComponent(buttonOpen);
		horizontalGroup.addGap(5);
		horizontalGroup.addComponent(buttonSave);
		horizontalGroup.addGap(5);
		horizontalGroup.addComponent(buttonExportChannels);
                horizontalGroup.addGap(5)
                .addComponent(ferramentasButton);
		
		setVerticalGroup(verticalGroup);
		setHorizontalGroup(horizontalGroup);
	}

}
