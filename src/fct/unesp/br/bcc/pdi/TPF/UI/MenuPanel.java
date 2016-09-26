package fct.unesp.br.bcc.pdi.TPF.UI;

import fct.unesp.br.bcc.pdi.TPF.exceptions.InvalidHistogramException;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PGM;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PNM;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;

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
        private JButton desfazerButton;
        private JButton refazerButton;
        private JButton histogramaButton;
	
	@Override
	public void init() {
		
		buttonOpen = new JButton("Abrir");
		buttonSave = new JButton("Salvar");
		buttonExportChannels = new JButton("Exportar");
                ferramentasButton = new JButton("Ferramentas");
                desfazerButton = new JButton("Desfazer");
                refazerButton = new JButton("Refazer");
                histogramaButton = new JButton("Equalizar Histograma");
                
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
                desfazerButton.setToolTipText("Desfazer");
                refazerButton.setToolTipText("Refazer");
                
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
                                PNM image = ((Frame)getTopLevelAncestor()).getImage();
                                JFileChooser JFC = new JFileChooser();
                                FileNameExtensionFilter extensionFilter =
                                        new FileNameExtensionFilter("PNM", (image instanceof PGM)?"pgm":"ppm");
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
                
                ferramentasButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new FrameTools(
                                ((Frame)getTopLevelAncestor()).getManager(), ((Frame)getTopLevelAncestor()));
                    }
                });
                
                desfazerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ((Frame)getTopLevelAncestor()).undo();
                    }
                });
                
                refazerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ((Frame)getTopLevelAncestor()).redo();
                    }
                });
                
                histogramaButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            ((Frame)getTopLevelAncestor()).equalizar();
                        } catch (InvalidHistogramException ex) {
                            Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
                        .addComponent(ferramentasButton,20,20,20)
                        .addComponent(desfazerButton,20,20,20)
                        .addComponent(refazerButton,20,20,20)
                        .addComponent(histogramaButton,20,20,20));
		
		horizontalGroup.addGap(5);
		horizontalGroup.addComponent(buttonOpen);
		horizontalGroup.addGap(5);
		horizontalGroup.addComponent(buttonSave);
		horizontalGroup.addGap(5);
		horizontalGroup.addComponent(buttonExportChannels);
                horizontalGroup.addGap(5)
                .addComponent(ferramentasButton);
                horizontalGroup.addGap(5)
                .addComponent(desfazerButton);
                horizontalGroup.addGap(5)
                .addComponent(refazerButton);
                horizontalGroup.addGap(5)
                .addComponent(histogramaButton);
		
		setVerticalGroup(verticalGroup);
		setHorizontalGroup(horizontalGroup);
	}

}
