package fct.unesp.br.bcc.pdi.TPF.code;

import java.security.InvalidParameterException;

import fct.unesp.br.bcc.pdi.TPF.fileTypes.PGM;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PNM;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PPM;

public class DigitalProccessing {
	
	public static final int channelR = 0;
	public static final int channelG = 1;
	public static final int channelB = 2;
	
	public static PGM rotate90Degrees(PGM image){
		int matrix[][] = new int[image.getWidth()][image.getHeight()];
		int widthBound = image.getWidth()-1;
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++)
				matrix[widthBound-i][j] = image.getMatrix()[j][i];
		PGM retorno = new PGM(image.getType(), image.getHeight(), image.getWidth(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM rotate90Degrees(PPM image){
		int matrix[][][] = new int[3][image.getWidth()][image.getHeight()];
		int redMatrix[][] = matrix[0];
		int greenMatrix[][] = matrix[1];
		int blueMatrix[][] = matrix[2];
		int widthBound = image.getWidth()-1;
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				redMatrix[widthBound-i][j] = image.getRedMatrix()[j][i];
				greenMatrix[widthBound-i][j] = image.getGreenMatrix()[j][i];
				blueMatrix[widthBound-i][j] = image.getBlueMatrix()[j][i];
			}
		PPM retorno = new PPM(image.getType(), image.getHeight(), image.getWidth(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PGM rotate180Degrees(PGM image){
		int matrix[][] = new int[image.getHeight()][image.getWidth()];
		int heightBound = image.getHeight()-1;
		int widthBound = image.getWidth()-1;

		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++)
				matrix[heightBound-j][widthBound-i] = image.getMatrix()[j][i];
		PGM retorno = new PGM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM rotate180Degrees(PPM image){
		int matrix[][][] = new int[3][image.getHeight()][image.getWidth()];
		int redMatrix[][] = matrix[0];
		int greenMatrix[][] = matrix[1];
		int blueMatrix[][] = matrix[2];
		int widthBound = image.getWidth()-1;
		int heightBound = image.getHeight()-1;
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				redMatrix[heightBound-j][widthBound-i] = image.getRedMatrix()[j][i];
				greenMatrix[heightBound-j][widthBound-i] = image.getGreenMatrix()[j][i];
				blueMatrix[heightBound-j][widthBound-i] = image.getBlueMatrix()[j][i];
			}				
		PPM retorno = new PPM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PGM rotateMinus90Degrees(PGM image){
		int matrix[][] = new int[image.getWidth()][image.getHeight()];
		int heightBound = image.getHeight()-1;
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++)
				matrix[i][heightBound-j] = image.getMatrix()[j][i];
		PGM retorno = new PGM(image.getType(), image.getHeight(), image.getWidth(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM rotateMinus90Degrees(PPM image){
		int matrix[][][] = new int[3][image.getWidth()][image.getHeight()];
		int redMatrix[][] = matrix[0];
		int greenMatrix[][] = matrix[1];
		int blueMatrix[][] = matrix[2];
		int heightBound = image.getHeight()-1;
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				redMatrix[i][heightBound-j] = image.getRedMatrix()[j][i];
				greenMatrix[i][heightBound-j] = image.getGreenMatrix()[j][i];
				blueMatrix[i][heightBound-j] = image.getBlueMatrix()[j][i];
			}
		PPM retorno = new PPM(image.getType(), image.getHeight(), image.getWidth(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PGM flipHorizontal(PGM image){
		int matrix[][] = new int[image.getHeight()][image.getWidth()];
		int widthBound = image.getWidth() - 1;
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++)
				matrix[j][widthBound-i] = image.getMatrix()[j][i];
		PGM retorno = new PGM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM flipHorizontal(PPM image){
		int matrix[][][] = new int[3][image.getHeight()][image.getWidth()];
		int redMatrix[][] = matrix[0];
		int greenMatrix[][] = matrix[1];
		int blueMatrix[][] = matrix[2];
		
		int widthBound = image.getWidth() - 1;
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				redMatrix[j][widthBound-i] = image.getRedMatrix()[j][i];
				greenMatrix[j][widthBound-i] = image.getGreenMatrix()[j][i];
				blueMatrix[j][widthBound-i] = image.getBlueMatrix()[j][i];
			}
		PPM retorno = new PPM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PGM flipVertical(PGM image){
		int matrix[][] = new int[image.getHeight()][image.getWidth()];
		int heightBound = image.getHeight() - 1;
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++)
				matrix[heightBound-j][i] = image.getMatrix()[j][i];
		PGM retorno = new PGM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM flipVertical(PPM image){
		int matrix[][][] = new int[3][image.getHeight()][image.getWidth()];
		int redMatrix[][] = matrix[0];
		int greenMatrix[][] = matrix[1];
		int blueMatrix[][] = matrix[2];
		
		int heightBound = image.getHeight() - 1;
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				redMatrix[heightBound - j][i] = image.getRedMatrix()[j][i];
				greenMatrix[heightBound - j][i] = image.getGreenMatrix()[j][i];
				blueMatrix[heightBound - j][i] = image.getBlueMatrix()[j][i];
			}
		PPM retorno = new PPM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PGM binarizationByPoint(PGM image, int binaryPoint){
		if(binaryPoint < 0 || binaryPoint > image.getMaxScale())
			throw new InvalidParameterException();
		
		int matrix[][] = new int[image.getHeight()][image.getWidth()];
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++)
				matrix[j][i] = (image.getMatrix()[j][i] > binaryPoint)?
						image.getMaxScale():0;
						
		PGM retorno = new PGM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PGM binarizationByPoint(PPM image, int binaryPoint){
		if(binaryPoint < 0 || binaryPoint > image.getMaxScale())
			throw new InvalidParameterException();
		
		int matrix[][] = new int[image.getHeight()][image.getWidth()];
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				int pixelSingleValue = (image.getRedMatrix()[j][i] + image.getGreenMatrix()[j][i] + 
						image.getBlueMatrix()[j][i]) / 3;
				matrix[j][i] = (pixelSingleValue > binaryPoint)?
						image.getMaxScale():0;
			}
						
		PGM retorno = new PGM(PNM.PGMASCII, image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PGM grayScaleReductionTo(PGM image, int newGrayScaleValue){
		if(newGrayScaleValue >  image.getMaxScale())
			throw new InvalidParameterException("The parameter has to be smaller than image grayscale");
		
		int matrix[][] = new int[image.getHeight()][image.getWidth()];
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++)
				matrix[j][i] = Math.round((float)image.getMatrix()[j][i] * (float) newGrayScaleValue / (float)image.getMaxScale());
		
		PGM retorno = new PGM(image.getType(), image.getWidth(), image.getHeight(), newGrayScaleValue);
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM rgbScaleReductionTo(PPM image, int newRGBScaleValue){
		if(newRGBScaleValue >  image.getMaxScale())
			throw new InvalidParameterException("The parameter has to be smaller than image rgbscale");
		
		int matrix[][][] = new int[3][image.getHeight()][image.getWidth()];
		int redMatrix[][] = matrix[0];
		int greenMatrix[][] = matrix[1];
		int blueMatrix[][] = matrix[2];
		
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				redMatrix[j][i] = Math.round((float)image.getRedMatrix()[j][i] * (float) newRGBScaleValue 
						/ (float)image.getMaxScale());
				greenMatrix[j][i] = Math.round((float)image.getGreenMatrix()[j][i] * (float) newRGBScaleValue 
						/ (float)image.getMaxScale());
				blueMatrix[j][i] = Math.round((float)image.getBlueMatrix()[j][i] * (float) newRGBScaleValue 
						/ (float)image.getMaxScale());
			}
		
		PPM retorno = new PPM(image.getType(), image.getWidth(), image.getHeight(), newRGBScaleValue);
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PGM enlargeScaleResolution(PGM image, float scaleValue){
		if(scaleValue < 1)
			throw new InvalidParameterException("Scale must be greater than 1");
		
		int newWidth = Math.round(image.getWidth()*scaleValue);
		int newHeight = Math.round(image.getHeight()*scaleValue);
		int matrix[][] = new int[newHeight][newWidth];
		
		if(scaleValue >= 1)
			for (int j = 0; j < image.getHeight(); j++)
				for(int i = 0; i < image.getWidth(); i++)
					for (int k = 0; k < scaleValue; k++ )
						for(int l = 0; l < scaleValue; l++)
							if((j*scaleValue)+k < newHeight && (i*scaleValue)+l < newWidth)
								matrix[(int)(j*scaleValue)+k][(int)(i*scaleValue)+l] = image.getMatrix()[j][i];
		
		PGM retorno = new PGM(image.getType(), newWidth, newHeight, image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM enlargeScaleResolution(PPM image, float scaleValue){
		if(scaleValue < 1)
			throw new InvalidParameterException("Scale must be greater than 1");
		
		int newWidth = Math.round(image.getWidth()*scaleValue);
		int newHeight = Math.round(image.getHeight()*scaleValue);
		int matrix[][][] = new int[3][newHeight][newWidth];
		int redMatrix[][] = matrix[0];
		int greenMatrix[][] = matrix[1];
		int blueMatrix[][] = matrix[2];
		
		for (int j = 0; j < image.getHeight(); j++)
			for(int i = 0; i < image.getWidth(); i++)
				for (int k = 0; k < scaleValue; k++ )
					for(int l = 0; l < scaleValue; l++)
						if((j*scaleValue)+k < newHeight && (i*scaleValue)+l < newWidth){
							redMatrix[(int)(j*scaleValue)+k][(int)(i*scaleValue)+l] = image.getRedMatrix()[j][i];
							greenMatrix[(int)(j*scaleValue)+k][(int)(i*scaleValue)+l] = image.getGreenMatrix()[j][i];
							blueMatrix[(int)(j*scaleValue)+k][(int)(i*scaleValue)+l] = image.getBlueMatrix()[j][i];
						}
		
		PPM retorno = new PPM(image.getType(), newWidth, newHeight, image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PGM compressScaleResolutionIn(PGM image, float scaleValue){
		if(scaleValue < 1)
			throw new InvalidParameterException("Scale must be greater than 1");
		
		int newWidth = Math.round(image.getWidth()/scaleValue);
		int newHeight = Math.round(image.getHeight()/scaleValue);
		int matrix[][] = new int[newHeight][newWidth];
		int media;
		int pixelsCounted;
		
		for (int j = 0; j < image.getHeight(); j+=scaleValue)
			for(int i = 0; i < image.getWidth(); i+=scaleValue){
				media = 0;
				pixelsCounted = 0;
				for (int k = 0; k < scaleValue; k++ )
					for(int l = 0; l < scaleValue; l++){
						if(j+k < newHeight && i+l < newWidth){
							media += image.getMatrix()[j+k][i+l];
							pixelsCounted++;
						}else if(j+k < newHeight){
							media += image.getMatrix()[j+k][i];
							pixelsCounted++;
						}else if(i+l < newWidth){
							media += image.getMatrix()[j][i+l];
							pixelsCounted++;
						}
						else{
							media += image.getMatrix()[j][i];
							pixelsCounted++;
						}
							
					}
				if(pixelsCounted>0)
					media = media/pixelsCounted;
				
				matrix[(int) (j/scaleValue)][((int)(i/scaleValue))] = media;
			}
		
		PGM retorno = new PGM(image.getType(), newWidth, newHeight, image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
	public static PPM compressScaleResolutionIn(PPM image, float scaleValue){
		if(scaleValue < 1)
			throw new InvalidParameterException("Scale must be greater than 1");
		
		int newWidth = Math.round(image.getWidth()/scaleValue);
		int newHeight = Math.round(image.getHeight()/scaleValue);
		int matrix[][][] = new int[3][newHeight][newWidth];
		int redMatrix[][] = matrix[0];
		int greenMatrix[][] = matrix[1];
		int blueMatrix[][] = matrix[2];
		int mediaRedChannel;
		int mediaGreenChannel;
		int mediaBlueChannel;
		int pixelsCounted;
		
		for (int j = 0; j < image.getHeight(); j+=scaleValue)
			for(int i = 0; i < image.getWidth(); i+=scaleValue){
				mediaRedChannel = 0;
				mediaGreenChannel = 0;
				mediaBlueChannel = 0;
				pixelsCounted = 0;
				for (int k = 0; k < scaleValue; k++ )
					for(int l = 0; l < scaleValue; l++){
						if(j+k < newHeight && i+l < newWidth){
							mediaRedChannel += image.getRedMatrix()[j+k][i+l];
							mediaGreenChannel += image.getGreenMatrix()[j+k][i+l];
							mediaBlueChannel += image.getBlueMatrix()[j+k][i+l];
							pixelsCounted++;
						}else if(j+k < newHeight){
							mediaRedChannel += image.getRedMatrix()[j+k][i];
							mediaGreenChannel += image.getGreenMatrix()[j+k][i];
							mediaBlueChannel += image.getBlueMatrix()[j+k][i];
							pixelsCounted++;
						}else if(i+l < newWidth){
							mediaRedChannel += image.getRedMatrix()[j][i+l];
							mediaGreenChannel += image.getGreenMatrix()[j][i+l];
							mediaBlueChannel += image.getBlueMatrix()[j][i+l];
							pixelsCounted++;
						}
						else{
							mediaRedChannel += image.getRedMatrix()[j][i];
							mediaGreenChannel += image.getGreenMatrix()[j][i];
							mediaBlueChannel += image.getBlueMatrix()[j][i];
							pixelsCounted++;
						}
							
					}
				if(pixelsCounted>0){
					mediaRedChannel = mediaRedChannel/pixelsCounted;
					mediaGreenChannel = mediaGreenChannel/pixelsCounted;
					mediaBlueChannel = mediaBlueChannel/pixelsCounted;
				}
				
				redMatrix[(int) (j/scaleValue)][((int)(i/scaleValue))] = mediaRedChannel;
				greenMatrix[(int) (j/scaleValue)][((int)(i/scaleValue))] = mediaGreenChannel;
				blueMatrix[(int) (j/scaleValue)][((int)(i/scaleValue))] = mediaBlueChannel;
			}
		
		PPM retorno = new PPM(image.getType(), newWidth, newHeight, image.getMaxScale());
		retorno.setMatrix(matrix);
		return retorno;
	}
	
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
        
        public static PGM dark(PGM image, int quantity){
		int matrix[][] = new int[image.getHeight()][image.getWidth()];
		int new_value;
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				new_value = image.getMatrix()[j][i] - quantity;
				matrix[j][i] = new_value<0?0:new_value;
			}
                
		PGM retorno = new PGM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
                
                return retorno;
	}
	
	public static PPM dark(PPM image, int quantity){
		int matrix[][][] = new int[image.getHeight()][image.getWidth()][3];
		int new_value;
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				new_value = image.getMatrix()[j][i][0] - quantity;
				matrix[j][i][0] = new_value<0?0:new_value;
				new_value = image.getMatrix()[j][i][1] - quantity;
				matrix[j][i][1] = new_value<0?0:new_value;
				new_value = image.getMatrix()[j][i][2] - quantity;
				matrix[j][i][2] = new_value<0?0:new_value;
			}
                
		PPM retorno = new PPM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
                
                return retorno;
	}
	
	public static PPM dark(PPM image, int quantity, int channel){
		int matrix[][][] = image.getMatrix();
		int new_value;
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++){
				new_value = image.getMatrix()[j][i][channel] - quantity;
				matrix[j][i][channel] = new_value<0?0:new_value;
			}
                
		PPM retorno = new PPM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
                
                return retorno;
	}
	
	public static PGM dark(PGM image, float quantity){
		int matrix[][] = new int[image.getHeight()][image.getWidth()];
		for (int j = 0; j < image.getHeight(); j++ )
			for(int i = 0; i < image.getWidth(); i++)
				matrix[j][i] = Math.round(image.getMatrix()[j][i] / quantity);
                
		PGM retorno = new PGM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
                
                return retorno;
	}
        
        public static PGM spacialFilter(PGM image, int[][] matrixSpace){
		int matrix[][] = new int[image.getHeight()][image.getWidth()];//image.getMatrix();
		int matrixSpaceValue = matrixSpace.length;
		//float filterScale = (float) Math.pow(matrixSpaceValue, (-2));
		int pixelsReaden;
		//center of the matrixSpace
		int center = matrixSpaceValue/2;
		
		//value for the newPixel
		float pixelValue;
		
		for (int j = 0; j < image.getHeight(); j++ ){
			for(int i = 0; i < image.getWidth(); i++){
				pixelValue = 0;
				pixelsReaden = 0;
				for(int k = 0; k < center+1; k++)
					for(int l = 0; l < center+1; l++){
						if(l != 0 && k != 0){
							if(i + l < image.getWidth() && j + k < image.getHeight()){
								pixelValue += image.getMatrix()[j+k][i+l] * matrixSpace[center+k][center+l];
								pixelsReaden++;
							}
							if(i - l >= 0 && j + k < image.getHeight()){
								pixelValue += image.getMatrix()[j+k][i-l] * matrixSpace[center+k][center-l];
								pixelsReaden++;
							}
							if(j - k >= 0 && i + l < image.getWidth()){
								pixelValue += image.getMatrix()[j-k][i+l] * matrixSpace[center-k][center+l];
								pixelsReaden++;
							}
							if(i - l >= 0 && j - k >= 0 ){
								pixelValue += image.getMatrix()[j-k][i-l] * matrixSpace[center-k][center-l];
								pixelsReaden++;
							}
						}
							
						else if(k != 0){
							if(j + k < image.getHeight()){
								pixelValue += image.getMatrix()[j+k][i] * matrixSpace[center+k][center];
								pixelsReaden++;
							}
							if(j - k >= 0){
								pixelValue += image.getMatrix()[j-k][i] * matrixSpace[center-k][center];
								pixelsReaden++;
							}
						}
						
						else if(l != 0){
							if(i + l < image.getWidth()){
								pixelValue += image.getMatrix()[j][i+l] * matrixSpace[center][center+l];
								pixelsReaden++;
							}
							if(i - l >= 0){
								pixelValue += image.getMatrix()[j][i-l] * matrixSpace[center][center-l];
								pixelsReaden++;
							}
						}
						else{
							pixelValue += image.getMatrix()[j][i] * matrixSpace[center][center];
							pixelsReaden++;
						}
					}
				matrix[j][i] = Math.round(pixelValue / (float) pixelsReaden);
				if(matrix[j][i] < 0)
					matrix[j][i] = 0;
			}
		}
		PGM retorno = new PGM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
                
                return retorno;
	}
        
        public static PPM spacialFilter(PPM image, int[][] matrixSpace){
		int matrix[][][] = new int[3][image.getHeight()][image.getWidth()];//image.getMatrix();
		int matrixSpaceValue = matrixSpace.length;
		//float filterScale = (float) Math.pow(matrixSpaceValue, (-2));
		int pixelsReaden;
		//center of the matrixSpace
		int center = matrixSpaceValue/2;
		
		//value for the newPixel
		float pixelValueR;
                float pixelValueG;
                float pixelValueB;
		
		for (int j = 0; j < image.getHeight(); j++ ){
			for(int i = 0; i < image.getWidth(); i++){
				pixelValueR = 0;
                                pixelValueG = 0;
                                pixelValueB = 0;
				pixelsReaden = 0;
				for(int k = 0; k < center+1; k++)
					for(int l = 0; l < center+1; l++){
						if(l != 0 && k != 0){
							if(i + l < image.getWidth() && j + k < image.getHeight()){
								pixelValueR += image.getMatrix()[0][j+k][i+l] * matrixSpace[center+k][center+l];
                                                                pixelValueG += image.getMatrix()[1][j+k][i+l] * matrixSpace[center+k][center+l];
                                                                pixelValueB += image.getMatrix()[2][j+k][i+l] * matrixSpace[center+k][center+l];
								pixelsReaden++;
							}
							if(i - l >= 0 && j + k < image.getHeight()){
								pixelValueR += image.getMatrix()[0][j+k][i-l] * matrixSpace[center+k][center-l];
                                                                pixelValueG += image.getMatrix()[1][j+k][i-l] * matrixSpace[center+k][center-l];
                                                                pixelValueB += image.getMatrix()[2][j+k][i-l] * matrixSpace[center+k][center-l];
								pixelsReaden++;
							}
							if(j - k >= 0 && i + l < image.getWidth()){
								pixelValueR += image.getMatrix()[0][j-k][i+l] * matrixSpace[center-k][center+l];
                                                                pixelValueG += image.getMatrix()[1][j-k][i+l] * matrixSpace[center-k][center+l];
                                                                pixelValueB += image.getMatrix()[2][j-k][i+l] * matrixSpace[center-k][center+l];
								pixelsReaden++;
							}
							if(i - l >= 0 && j - k >= 0 ){
								pixelValueR += image.getMatrix()[0][j-k][i-l] * matrixSpace[center-k][center-l];
                                                                pixelValueG += image.getMatrix()[1][j-k][i-l] * matrixSpace[center-k][center-l];
                                                                pixelValueB += image.getMatrix()[2][j-k][i-l] * matrixSpace[center-k][center-l];
								pixelsReaden++;
							}
						}
							
						else if(k != 0){
							if(j + k < image.getHeight()){
								pixelValueR += image.getMatrix()[0][j+k][i] * matrixSpace[center+k][center];
                                                                pixelValueG += image.getMatrix()[1][j+k][i] * matrixSpace[center+k][center];
                                                                pixelValueB += image.getMatrix()[2][j+k][i] * matrixSpace[center+k][center];
								pixelsReaden++;
							}
							if(j - k >= 0){
								pixelValueR += image.getMatrix()[0][j-k][i] * matrixSpace[center-k][center];
                                                                pixelValueG += image.getMatrix()[1][j-k][i] * matrixSpace[center-k][center];
                                                                pixelValueB += image.getMatrix()[2][j-k][i] * matrixSpace[center-k][center];
								pixelsReaden++;
							}
						}
						
						else if(l != 0){
							if(i + l < image.getWidth()){
								pixelValueR += image.getMatrix()[0][j][i+l] * matrixSpace[center][center+l];
                                                                pixelValueG += image.getMatrix()[1][j][i+l] * matrixSpace[center][center+l];
                                                                pixelValueB += image.getMatrix()[2][j][i+l] * matrixSpace[center][center+l];
								pixelsReaden++;
							}
							if(i - l >= 0){
								pixelValueR += image.getMatrix()[0][j][i-l] * matrixSpace[center][center-l];
                                                                pixelValueG += image.getMatrix()[1][j][i-l] * matrixSpace[center][center-l];
                                                                pixelValueB += image.getMatrix()[2][j][i-l] * matrixSpace[center][center-l];
								pixelsReaden++;
							}
						}
						else{
							pixelValueR += image.getMatrix()[0][j][i] * matrixSpace[center][center];
                                                        pixelValueG += image.getMatrix()[1][j][i] * matrixSpace[center][center];
                                                        pixelValueB += image.getMatrix()[2][j][i] * matrixSpace[center][center];
							pixelsReaden++;
						}
					}
				matrix[0][j][i] = Math.round(pixelValueR / (float) pixelsReaden);
                                matrix[1][j][i] = Math.round(pixelValueG / (float) pixelsReaden);
                                matrix[2][j][i] = Math.round(pixelValueB / (float) pixelsReaden);
				if(matrix[0][j][i] < 0)
					matrix[0][j][i] = 0;
                                if(matrix[1][j][i] < 0)
					matrix[1][j][i] = 0;
                                if(matrix[2][j][i] < 0)
					matrix[2][j][i] = 0;
			}
		}
		PPM retorno = new PPM(image.getType(), image.getWidth(), image.getHeight(), image.getMaxScale());
		retorno.setMatrix(matrix);
                
                return retorno;
	}
	
	public static PGM Laplacian(PGM image, int filtro){
		int matrixSpace[][] = null;
		switch(filtro){
			case 4:
				matrixSpace = new int[][]{
					{0,-1,0},
					{-1,4,-1},
					{0,-1,0}};
				break;
			case -4:
				matrixSpace = new int[][]{
					{0,1,0},
					{1,-4,1},
					{0,1,0}};
				break;
			case 8:
				matrixSpace = new int[][]{
					{-1,-1,-1},
					{-1,8,-1},
					{-1,-1,-1}};
				break;
			case -8:
				matrixSpace = new int[][]{
					{1,1,1},
					{1,8,1},
					{1,1,1}};
				break;
		}
                return spacialFilter(image, matrixSpace);
	}
        
        public static PPM Laplacian(PPM image, int filtro){
		int matrixSpace[][] = null;
		switch(filtro){
			case 4:
				matrixSpace = new int[][]{
					{0,-1,0},
					{-1,4,-1},
					{0,-1,0}};
				break;
			case -4:
				matrixSpace = new int[][]{
					{0,1,0},
					{1,-4,1},
					{0,1,0}};
				break;
			case 8:
				matrixSpace = new int[][]{
					{-1,-1,-1},
					{-1,8,-1},
					{-1,-1,-1}};
				break;
			case -8:
				matrixSpace = new int[][]{
					{1,1,1},
					{1,8,1},
					{1,1,1}};
				break;
		}
                return spacialFilter(image, matrixSpace);
	}

}
