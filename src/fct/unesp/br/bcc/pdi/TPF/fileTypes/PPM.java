package fct.unesp.br.bcc.pdi.TPF.fileTypes;

import java.io.IOException;
import java.security.InvalidParameterException;

import fct.unesp.br.bcc.pdi.TPF.code.Histogram;
import fct.unesp.br.bcc.pdi.TPF.exceptions.InvalidHistogramException;
import fct.unesp.br.bcc.pdi.TPF.file.FileHandler;

public class PPM extends PNM{

	int maxScale;
	
	private int Matrix[][][] = null;
	private int averageValue[] = new int[]{-1,-1,-1};
	private Histogram histogram;
	
	public PPM(String type, int width, int height, int maxScale) throws InvalidParameterException{
		super(type, width, height);
		if(maxScale < 1 || maxScale > 65535)
			throw new InvalidParameterException("maxScale value must be greater than 0 and lesser than 65536");
		this.maxScale = maxScale;
		Matrix = new int[height][width][3];
	}
	
	public PPM(String file) throws IOException {
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
		Matrix = new int[3][getHeight()][getWidth()];
		for(int j= 0; j < getHeight(); j++)
			for(int i = 0; i < getWidth();i++){
				Matrix[0][j][i] = FH.readInt(3);
				Matrix[1][j][i] = FH.readInt(3);
				Matrix[2][j][i] = FH.readInt(3);
			}
		FH.closeReaderFile();
		histogram = new Histogram(getMaxScale(), Histogram.RGB, getWidth()*getHeight());
		setHistogram();
	}
	
	public void setMatrix(int matrix[][][]){
		this.Matrix = matrix;
	}
	
	public int[][][] getMatrix(){
			return Matrix;
	}
	
	public int[][] getRedMatrix(){
		return Matrix[0];
	}
	
	public int[][] getGreenMatrix(){
		return Matrix[1];
	}
	
	public int[][] getBlueMatrix(){
		return Matrix[2];
	}
	
	public PGM getRedImage(){
		PGM retorno = new PGM(PNM.PGMASCII, getWidth(), getHeight(), getMaxScale());
		retorno.setMatrix(getRedMatrix());
		return retorno;
	}
	
	public PGM getGreenImage(){
		PGM retorno = new PGM(PNM.PGMASCII, getWidth(), getHeight(), getMaxScale());
		retorno.setMatrix(getGreenMatrix());
		return retorno;
	}
	
	public PGM getBlueImage(){
		PGM retorno = new PGM(PNM.PGMASCII, getWidth(), getHeight(), getMaxScale());
		retorno.setMatrix(getBlueMatrix());
		return retorno;
	}
	
	public PGM getCianImage(){
		PGM retorno = new PGM(PNM.PGMASCII, getWidth(), getHeight(), getMaxScale());
		int matrix[][] = new int[getHeight()][getWidth()];
		for(int j = 0; j < getHeight(); j++)
			for(int i = 0; i < getWidth(); i++)
				matrix[j][i] = getMaxScale() - getRedMatrix()[j][i];
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public PGM getMagentImage(){
		PGM retorno = new PGM(PNM.PGMASCII, getWidth(), getHeight(), getMaxScale());
		int matrix[][] = new int[getHeight()][getWidth()];
		for(int j = 0; j < getHeight(); j++)
			for(int i = 0; i < getWidth(); i++)
				matrix[j][i] = getMaxScale() - getGreenMatrix()[j][i];
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public PGM getYellowImage(){
		PGM retorno = new PGM(PNM.PGMASCII, getWidth(), getHeight(), getMaxScale());
		int matrix[][] = new int[getHeight()][getWidth()];
		for(int j = 0; j < getHeight(); j++)
			for(int i = 0; i < getWidth(); i++)
				matrix[j][i] = getMaxScale() - getBlueMatrix()[j][i];
		retorno.setMatrix(matrix);
		return retorno;
	}

	@Override
	public void saveFile(String file) throws IOException {
		FileHandler FH = new FileHandler(file);
		FH.openWriterFile();
		FH.writeLine(getType());
		FH.writeLine(getWidth()+" "+getHeight());
		FH.writeLine(String.valueOf(getMaxScale()));
		for(int j = 0; j < getHeight(); j++){
			for(int i = 0; i < getWidth(); i++){
				FH.write(String.valueOf(Matrix[0][j][i])+" ");
				FH.write(String.valueOf(Matrix[1][j][i])+" ");
				FH.write(String.valueOf(Matrix[2][j][i])+" ");
			}
			FH.writeLine("");
		}
		FH.closeWriterFile();
	}
	
	public void saveFileRed(String file) throws IOException {
		getRedImage().saveFile(file);
	}
	
	public void saveFileGreen(String file) throws IOException {
		getGreenImage().saveFile(file);
	}
	
	public void saveFileBlue(String file) throws IOException {
		getBlueImage().saveFile(file);
	}
	
	public void saveFileCian(String file) throws IOException {
		getCianImage().saveFile(file);
	}
	
	public void saveFileYellow(String file) throws IOException {
		getYellowImage().saveFile(file);
	}
	
	public void saveFileMagent(String file) throws IOException {
		getMagentImage().saveFile(file);
	}

	public void setHistogram() {
		int tempHistogram[][] = new int [getMaxScale()+1][3];
		for(int j = 0; j < getHeight(); j++)
			for(int i = 0; i < getWidth(); i++){
				tempHistogram[Matrix[0][j][i]][0]++;
				tempHistogram[Matrix[1][j][i]][1]++;
				tempHistogram[Matrix[2][j][i]][2]++;
			}
		try{
			histogram.setHistogram(tempHistogram);
		}catch(InvalidHistogramException e){
			e.printStackTrace();
		}
	}

	public void setAverageValue(){
		averageValue[0] = 0 ;
		averageValue[1] = 0 ;
		averageValue[2] = 0 ;
		for(int j = 0; j < getHeight(); j++)
			for(int i = 0; i < getWidth(); i++){
				averageValue[0] += Matrix[0][j][i];
				averageValue[1] += Matrix[1][j][i];
				averageValue[2] += Matrix[2][j][i];
			}
			
		averageValue[0] = Math.round((float) averageValue[0] / (float) (getWidth()*getHeight()));
		averageValue[1] = Math.round((float) averageValue[1] / (float) (getWidth()*getHeight()));
		averageValue[2] = Math.round((float) averageValue[2] / (float) (getWidth()*getHeight()));
	}
	
	public int[] getAverageValue(){
		if(averageValue[0] == -1){
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
