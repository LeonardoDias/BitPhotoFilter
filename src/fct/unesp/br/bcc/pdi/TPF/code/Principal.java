package fct.unesp.br.bcc.pdi.TPF.code;

import java.io.IOException;

import javax.swing.JFrame;

import fct.unesp.br.bcc.pdi.TPF.exceptions.InvalidTypeException;

public class Principal extends JFrame{
	
	PNMManager manager;
	
	public Principal() throws Exception{
		manager = new PNMManager();
		teste();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -7648928320164024442L;

	public void teste() throws InvalidTypeException{
		
		String supergirlPPM = "/home/leonardo/Pictures/pdi/supergirl.ppm";
		String supergirlPGM = "/home/leonardo/Pictures/pdi/supergirl.pgm";
		
		String supergirlPPMOutput = "/home/leonardo/Pictures/pdi/supergirlOutput.ppm";
		String supergirlPGMOutput = "/home/leonardo/Pictures/pdi/supergirlOutput.pgm";
		//manager.openImage(supergirlPGM);
		manager.openImage(supergirlPPM);
		manager.compressScaleResolutionIn(1.7f);
		try {
			manager.saveImage(supergirlPPMOutput);
			//manager.saveImage(supergirlPGMOutput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		manager.negative();
		manager.saveImage("/home/leonardo/Pictures/pdi/perfil[negative].ppm");
		manager.undo();
		manager.lightGreenChannel(60);
		manager.saveImage("/home/leonardo/Pictures/pdi/perfil[light-green-60].ppm");
		manager.undo();
		manager.lightBlueChannel(60);
		manager.saveImage("/home/leonardo/Pictures/pdi/perfil[light-blue-60].ppm");
		manager.undo();
		manager.lightRedChannel(60);
		manager.saveImage("/home/leonardo/Pictures/pdi/perfil[light-red-60].ppm");
		manager.undo();
		manager.saveBlueChannel("/home/leonardo/Pictures/pdi/perfil[export-blue-channel].pgm");
		manager.saveRedChannel("/home/leonardo/Pictures/pdi/perfil[export-red-channel].pgm");
		manager.saveGreenChannel("/home/leonardo/Pictures/pdi/perfil[export-green-channel].pgm");
		manager.saveCianChannel("/home/leonardo/Pictures/pdi/perfil[export-cian-channel].pgm");
		manager.saveYellowChannel("/home/leonardo/Pictures/pdi/perfil[export-yellow-channel].pgm");
		manager.saveMagentChannel("/home/leonardo/Pictures/pdi/perfil[export-magent-channel].pgm");*/
	}
	
	public static void main(String args[]){
		try {
			new Principal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
