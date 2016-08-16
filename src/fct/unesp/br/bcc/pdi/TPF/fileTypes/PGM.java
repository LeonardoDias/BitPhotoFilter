package fct.unesp.br.bcc.pdi.TPF.fileTypes;

import java.io.IOException;
import java.security.InvalidParameterException;

import fct.unesp.br.bcc.pdi.TPF.code.Histogram;
import fct.unesp.br.bcc.pdi.TPF.exceptions.InvalidFileException;
import fct.unesp.br.bcc.pdi.TPF.exceptions.InvalidHistogramException;
import fct.unesp.br.bcc.pdi.TPF.file.FileHandler;

public class PGM extends PNM{

	private int maxScale;
	private int Matrix[][] = null;
	private int averageValue = -1;
	private Histogram histogram;
	
	public PGM(String type, int width, int height, int maxScale) throws InvalidParameterException{
		super(type, width, height);
		if(maxScale < 1 || maxScale > 65535)
			throw new InvalidParameterException("maxScale value must be greater than 0 and lesser than 65536");
		this.maxScale = maxScale;
		Matrix = new int[height][width];
	}
	
	public PGM(String file) throws IOException, InvalidFileException {
		super();
		FileHandler FH = new FileHandler(file);
		FH.openReaderFile();
		String line = "";
		int readenfields = 0;
		
		while(FH.ready()){
			line = FH.readLine();
			/*
			 * in PNM protocol # means commentary
			 */
			if(!line.startsWith("#")){
				if(readenfields == 0){
					if(!(line.equals(PNM.PGMASCII) || line.equals(PNM.PGMBinary)))
						throw new InvalidFileException();
					setType(line);
					readenfields++;
				}
				else if(readenfields == 1){
					if(line.contains(" ")){
						setWidth(Integer.parseInt(line.split(" ")[0]));
						setHeight(Integer.parseInt(line.split(" ")[1]));
					}
					else{
						setWidth(Integer.parseInt(line));
						line = FH.readLine();
						setHeight(Integer.parseInt(line));
					}
					readenfields++;
					FH.mark();
				}
				else if(readenfields == 2){
					setMaxScale(Integer.parseInt(line));
					readenfields++;
					FH.mark();
				}
				else{
					FH.resetOnMark();
					break;
				}
			}
		}
		Matrix = new int[getHeight()][getWidth()];
		for(int j= 0; j < getHeight(); j++)
			for(int i = 0; i < getWidth();i++){
				Matrix[j][i] = FH.readInt(3);
			}
		FH.closeReaderFile();
		histogram = new Histogram(getMaxScale(), Histogram.GRAY, getWidth()*getHeight());
		setHistogram();
	}
	
	public int[][] getMatrix(){
			return Matrix;
	}
	
	public void setMatrix(int[][] Matrix){
		this.Matrix = Matrix;
	}

	@Override
	public void saveFile(String file) throws IOException {
		FileHandler FH = new FileHandler(file);
		FH.openWriterFile();
		FH.writeLine(getType());
		FH.writeLine(getWidth()+" "+getHeight());
		FH.writeLine(String.valueOf(getMaxScale()));
		for(int j = 0; j < getHeight(); j++){
			for(int i = 0; i < getWidth(); i++)
				FH.write(String.valueOf(Matrix[j][i])+" ");
			FH.writeLine("");
		}
		FH.closeWriterFile();
	}

	public void setHistogram() {
		int tempHistogram[] = new int [getMaxScale()+1];
		for(int j = 0; j < getHeight(); j++)
			for(int i = 0; i < getWidth(); i++)
				tempHistogram[Matrix[j][i]]++;
		try{
			histogram.setHistogram(tempHistogram);
		}catch(InvalidHistogramException e){
			e.printStackTrace();
		}
	}
	
	public int[] getHistogram(){
		try{
		return histogram.getGrayHistogram();
		}catch(InvalidHistogramException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public int[] getHistogramEqualizationVector(){
		try{
		return histogram.getGrayHistogramEqualization();
		}catch(InvalidHistogramException e){
			e.printStackTrace();
			return null;
		}
	}

	public void setAverageValue(){
		averageValue = 0 ;
		for(int j = 0; j < getHeight(); j++)
			for(int i = 0; i < getWidth(); i++)
				averageValue += Matrix[j][i];
			
		averageValue = Math.round((float) averageValue / (float) (getWidth()*getHeight()));
	}
	
	public int getAverageValue(){
		if(averageValue == -1){
			setAverageValue();
		}
		return averageValue;
	}
	
	public int getMaxScale() {
		return maxScale;
	}

	public void setMaxScale(int maxScale) {
		this.maxScale = maxScale;
	}
	
}
