package fct.unesp.br.bcc.pdi.TPF.code;

import java.io.IOException;
import java.util.ArrayList;

import fct.unesp.br.bcc.pdi.TPF.exceptions.InvalidFileException;
import fct.unesp.br.bcc.pdi.TPF.exceptions.InvalidTypeException;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PGM;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PNM;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PPM;

public class PNMManager {
	
	private ArrayList<PNM> images;
	private int imagesPointer;
	
	public PNMManager(){
		images = new ArrayList<PNM>();
		imagesPointer = -1;
	}
	
	public void openImage(String file){
		images.clear();
		try{
			try{
				images.add(new PGM(file));
			}catch(InvalidFileException e){
				images.add(new PPM(file));
			}
			finally{
				imagesPointer = 0;
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void undo(){
		if(imagesPointer > 0)
			imagesPointer--;
	}
	
	public void redo(){
		if(imagesPointer < images.size() - 1)
			imagesPointer++;
	}
	
	private void addImage(PNM image){
		while(imagesPointer < images.size() - 1)
			images.remove(images.size() - 1);
		imagesPointer++;
		images.add(image);
		
	}
	
	public PNM getImage(){
		return images.get(imagesPointer);
	}
	
	public PNM getOriginalImage() {
		return images.get(0);
	}
	
	public void rotate90Degrees(){
		if(getImage() instanceof PGM)
			addImage(
					DigitalProccessing.rotate90Degrees((PGM)getImage()));
		else
			addImage(
					DigitalProccessing.rotate90Degrees((PPM)getImage()));
	}
	
	public void rotateMinus90Degrees(){
		if(getImage() instanceof PGM)
			addImage(
					DigitalProccessing.rotateMinus90Degrees((PGM)getImage()));
	}
	
	public void rotate180Degrees(){
		if(getImage() instanceof PGM)
			addImage(
					DigitalProccessing.rotate180Degrees((PGM)getImage()));
		else
			addImage(
					DigitalProccessing.rotate180Degrees((PPM)getImage()));
	}
	
	public void flipHorizontal(){
		if(getImage() instanceof PGM)
			addImage(
					DigitalProccessing.flipHorizontal((PGM)getImage()));
		else
			addImage(
					DigitalProccessing.flipHorizontal((PPM)getImage()));
	}
	
	public void flipVertical(){
		if(getImage() instanceof PGM)
			addImage(
					DigitalProccessing.flipVertical((PGM)getImage()));
		else
			addImage(
					DigitalProccessing.flipVertical((PPM)getImage()));
	}
	
	public void negative(){
		if(getImage() instanceof PGM)
			addImage(	
				DigitalProccessing.negative( ((PGM)getImage())) );
		else
			addImage(
				DigitalProccessing.negative( ((PPM)getImage())) );
	}
	
	public void light(int quantity){
		if(getImage() instanceof PGM)
			addImage(	
				DigitalProccessing.light( ((PGM)getImage()), quantity) );
		else
			addImage(	
				DigitalProccessing.light( ((PPM)getImage()), quantity) );
	}
	
	public void light(float quantity){
		if(getImage() instanceof PGM)
			addImage(	
				DigitalProccessing.light( ((PGM)getImage()), quantity) );
		else
			addImage(	
				DigitalProccessing.light( ((PPM)getImage()), quantity) );
	}
	
	public void lightRedChannel(int quantity) throws InvalidTypeException{
		if(getImage() instanceof PGM)
			throw new InvalidTypeException();
		else
			addImage(	
				DigitalProccessing.light( ((PPM)getImage()), quantity, DigitalProccessing.channelR) );	
	}
	
	public void lightRedChannel(float quantity) throws InvalidTypeException{
		if(getImage() instanceof PGM)
			throw new InvalidTypeException();
		else
			addImage(	
				DigitalProccessing.light( ((PPM)getImage()), quantity, DigitalProccessing.channelR) );	
	}
	
	public void lightGreenChannel(int quantity) throws InvalidTypeException{
		if(getImage() instanceof PGM)
			throw new InvalidTypeException();
		else
			addImage(	
				DigitalProccessing.light( ((PPM)getImage()), quantity, DigitalProccessing.channelG) );
		
	}
	
	public void lightGreenChannel(float quantity) throws InvalidTypeException{
		if(getImage() instanceof PGM)
			throw new InvalidTypeException();
		else
			addImage(	
				DigitalProccessing.light( ((PPM)getImage()), quantity, DigitalProccessing.channelG) );
		
	}
	
	public void lightBlueChannel(int quantity) throws InvalidTypeException{
		if(getImage() instanceof PGM)
			throw new InvalidTypeException();
		else
			addImage(	
				DigitalProccessing.light( ((PPM)getImage()), quantity, DigitalProccessing.channelB) );
		
	}
	
	public void lightBlueChannel(float quantity) throws InvalidTypeException{
		if(getImage() instanceof PGM)
			throw new InvalidTypeException();
		else
			addImage(	
				DigitalProccessing.light( ((PPM)getImage()), quantity, DigitalProccessing.channelB) );
		
	}
	
	public void saveImage(String file) throws IOException{
		getImage().saveFile(file);
	}
	
	public void saveRedChannel(String file) throws IOException, InvalidTypeException{
		if(getImage() instanceof PGM)
			throw new InvalidTypeException();
		((PPM)getImage()).saveFileRed(file);
	}
	
	public void saveGreenChannel(String file) throws IOException, InvalidTypeException{
		if(getImage() instanceof PGM)
			throw new InvalidTypeException();
		((PPM)getImage()).saveFileGreen(file);
	}
	
	public void saveBlueChannel(String file) throws IOException, InvalidTypeException{
		if(getImage() instanceof PGM)
			throw new InvalidTypeException();
		((PPM)getImage()).saveFileBlue(file);
	}
	
	public void saveCianChannel(String file) throws IOException, InvalidTypeException{
		if(getImage() instanceof PGM)
			throw new InvalidTypeException();
		((PPM)getImage()).saveFileCian(file);
	}
	
	public void saveYellowChannel(String file) throws IOException, InvalidTypeException{
		if(getImage() instanceof PGM)
			throw new InvalidTypeException();
		((PPM)getImage()).saveFileYellow(file);
	}
	
	public void saveMagentChannel(String file) throws IOException, InvalidTypeException{
		if(getImage() instanceof PGM)
			throw new InvalidTypeException();
		((PPM)getImage()).saveFileMagent(file);
	}

}
