package fct.unesp.br.bcc.pdi.TPF.code;

import java.security.InvalidParameterException;

import fct.unesp.br.bcc.pdi.TPF.fileTypes.PGM;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PPM;

public class DigitalProccessing {
	
	public static final int channelR = 0;
	public static final int channelG = 1;
	public static final int channelB = 2;
	
	public static PGM negative(PGM image){
		int matrix[][] = new int[image.getHeight()][image.getWidth()];
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++)
				matrix[j][i] = image.getMaxScale() - image.getMatrix()[j][i];
		PGM retorno = new PGM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM negative(PPM image){
		int matrix[][][] = new int[3][image.getHeight()][image.getWidth()];
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				matrix[0][j][i] = image.getMaxScale() - image.getMatrix()[0][j][i];
				matrix[1][j][i] = image.getMaxScale() - image.getMatrix()[1][j][i];
				matrix[2][j][i] = image.getMaxScale() - image.getMatrix()[2][j][i];
			}
		PPM retorno = new PPM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PGM light(PGM image, int quantity) throws InvalidParameterException{
		if(quantity < 0)
			throw new InvalidParameterException();
		int matrix[][] = new int[image.getHeight()][image.getWidth()];
		int new_value;
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				new_value = image.getMatrix()[j][i] + quantity;
				matrix[j][i] = new_value>image.getMaxScale()?image.getMaxScale():new_value;
			}
		PGM retorno = new PGM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PGM light(PGM image, float quantity) throws InvalidParameterException{
		if(quantity < 0)
			throw new InvalidParameterException();
		int matrix[][] = new int[image.getHeight()][image.getWidth()];
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				matrix[j][i] = Math.round(image.getMatrix()[j][i] * quantity);
				if(matrix[j][i] > image.getMaxScale()) matrix[j][i] = image.getMaxScale();
			}
		PGM retorno = new PGM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM light(PPM image, int quantity) throws InvalidParameterException{
		if(quantity < 0)
			throw new InvalidParameterException();
		int matrix[][][] = new int[3][image.getHeight()][image.getWidth()];
		int new_value;
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				new_value = image.getMatrix()[0][j][i] + quantity;
				matrix[0][j][i] = new_value>image.getMaxScale()?image.getMaxScale():new_value;
				new_value = image.getMatrix()[1][j][i] + quantity;
				matrix[1][j][i] = new_value>image.getMaxScale()?image.getMaxScale():new_value;
				new_value = image.getMatrix()[2][j][i] + quantity;
				matrix[2][j][i] = new_value>image.getMaxScale()?image.getMaxScale():new_value;
			}
		PPM retorno = new PPM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM light(PPM image, float quantity) throws InvalidParameterException{
		if(quantity < 0)
			throw new InvalidParameterException();
		int matrix[][][] = new int[3][image.getHeight()][image.getWidth()];
		int new_value;
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				new_value = Math.round(image.getMatrix()[0][j][i] * quantity);
				matrix[0][j][i] = new_value>image.getMaxScale()?image.getMaxScale():new_value;
				new_value = Math.round(image.getMatrix()[1][j][i] * quantity);
				matrix[1][j][i] = new_value>image.getMaxScale()?image.getMaxScale():new_value;
				new_value = Math.round(image.getMatrix()[2][j][i] * quantity);
				matrix[2][j][i] = new_value>image.getMaxScale()?image.getMaxScale():new_value;
			}
		PPM retorno = new PPM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM light(PPM image, int quantity, int channel){
		if(quantity < 0 || channel <0 || channel > 2)
			throw new InvalidParameterException();
		int matrix[][][] = image.getMatrix();
		int new_value;
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				new_value = image.getMatrix()[channel][j][i] + quantity;
				matrix[channel][j][i] = new_value>image.getMaxScale()?image.getMaxScale():new_value;
			}
		PPM retorno = new PPM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM light(PPM image, float quantity, int channel){
		if(quantity < 0 || channel <0 || channel > 2)
			throw new InvalidParameterException();
		int matrix[][][] = image.getMatrix();
		int new_value;
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				new_value = Math.round(image.getMatrix()[channel][j][i] * quantity);
				matrix[channel][j][i] = new_value>image.getMaxScale()?image.getMaxScale():new_value;
			}
		PPM retorno = new PPM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}

}
