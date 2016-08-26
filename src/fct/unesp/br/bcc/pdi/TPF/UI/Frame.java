package fct.unesp.br.bcc.pdi.TPF.UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import fct.unesp.br.bcc.pdi.TPF.code.PNMManager;

public class Frame extends JFrame{
	
	private static final long serialVersionUID = -3450138015387473519L;
	private GeneralJPanel mainPanel;
	private PNMManager manager;
	private JScrollPane imagePanelJSP;
	private Thread imagePanelRefreshThread;
	
	public Frame(String fileToOpen){
		super();
		init();
		imagePanelRefreshThread = new Thread(mainPanel);
		manager = new PNMManager();
		openImage(fileToOpen);
	}
	
	private void init(){
		setResizable(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("BitPhotoFilter");
		mainPanel = new imagePanel();
		imagePanelJSP = new JScrollPane(mainPanel);
		add(imagePanelJSP);
		setVisible(true);
	}
	
	private void openImage(String fileToOpen){
		manager.openImage(fileToOpen);
		((imagePanel) mainPanel).setImage(manager.getImage());
		setSize(new Dimension(manager.getImage().getWidth()+5, manager.getImage().getHeight()+5));
		if(!imagePanelRefreshThread.isAlive())
			imagePanelRefreshThread.start();
		
		setTitle("BitPhotoFilter - ".concat(fileToOpen));
	}
	
	public void updateImage(){
		((imagePanel) mainPanel).setImage(manager.getImage());
		((imagePanel) mainPanel).hasAlteration();
	}
	
	public void originalImage(){
		((imagePanel) mainPanel).setImage(manager.getOriginalImage());
		((imagePanel) mainPanel).hasAlteration();
	}
	
	public static void main(String args[]){
		new Frame("/home/leonardo/Pictures/pdi/supergirl.ppm");
		//new Frame("/home/leonardo/Pictures/pdi/ultimate-spider-man.ppm");
	}
}
