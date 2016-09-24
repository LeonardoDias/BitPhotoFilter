package fct.unesp.br.bcc.pdi.TPF.UI;

import java.awt.Dimension;

import javax.swing.GroupLayout.Group;
import javax.swing.JScrollPane;

import fct.unesp.br.bcc.pdi.TPF.code.PNMManager;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PNM;
import java.io.IOException;

public class MainPanel extends GeneralJPanel{
	
	private static final long serialVersionUID = -3724594684763713520L;
	private GeneralJPanel imagePanel;
	private PNMManager manager;
	private JScrollPane imagePanelJSP;
	private Thread imagePanelRefreshThread;
	private GeneralJPanel menuPanel;
	private Frame GUIFrame;
	
	@Override
	public void init() {
		manager = new PNMManager();
	}

	@Override
	public void initComponents() {
		imagePanel = new ImagePanel();
		menuPanel = new MenuPanel();
		imagePanelJSP = new JScrollPane(imagePanel);
		imagePanelRefreshThread = new Thread((ImagePanel)imagePanel);
		
	}

	@Override
	public void setComponents() {
		Group verticalGroup = layout.createSequentialGroup();
		Group horizontalGroup = layout.createParallelGroup();
		
		verticalGroup.addComponent(menuPanel, 30, 30, 30);
		verticalGroup.addComponent(imagePanelJSP, 100, 100, Integer.MAX_VALUE);
		
		horizontalGroup.addComponent(menuPanel, 0, 0, Integer.MAX_VALUE);
		horizontalGroup.addGroup(layout.createSequentialGroup()
				.addGap(5)
				.addComponent(imagePanelJSP,100,100,Integer.MAX_VALUE)
				.addGap(5));
		
		setVerticalGroup(verticalGroup);
		setHorizontalGroup(horizontalGroup);
	}
	
	public void openImage(String fileToOpen){
		if(GUIFrame == null)
			GUIFrame = (Frame)getTopLevelAncestor();
		
		manager.openImage(fileToOpen);
		updateImage();
		
		GUIFrame.setSize(new Dimension(manager.getImage().getWidth(), manager.getImage().getHeight()));
		GUIFrame.setTitle("BitPhotoFilter - ".concat(fileToOpen));
		
		if(!imagePanelRefreshThread.isAlive())
			imagePanelRefreshThread.start();
		
	}
	
	public void updateImage(){
		((ImagePanel) imagePanel).setImage(manager.getImage());
		((ImagePanel) imagePanel).hasAlteration();
	}
	
	public void originalImage(){
		((ImagePanel) imagePanel).setImage(manager.getOriginalImage());
		((ImagePanel) imagePanel).hasAlteration();
	}

        public void saveImage(String filePath) throws IOException {
            manager.saveImage(filePath);
            
        }

        public PNM getImage() {
            return manager.getImage();
        }

}
