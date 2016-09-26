package fct.unesp.br.bcc.pdi.TPF.code;
import java.security.InvalidParameterException;

import fct.unesp.br.bcc.pdi.TPF.exceptions.InvalidHistogramException;

public class Histogram {
	
	public static final int RGB = 0;
	public static final int GRAY = 1;
	
	private int maxScale;
	private int type;
	private int totalPixels;
	
	private int rgb[][];
	private int redChannel[];
	private int greenChannel[];
	private int blueChannel[];
	private int gray[];
	private int maxValue = 0;
	
	private int maxRedValue = 0;
	private int maxGreenValue = 0;
	private int maxBlueValue = 0;
	
	public Histogram(int maxScale, int type, int totalPixels){
		if(type != RGB && type != GRAY)
			throw new InvalidParameterException("Type must be RGB or GRAY");
		this.type = type;
		this.maxScale = maxScale;
		this.totalPixels = totalPixels;
	}
	
	public void setHistogram(int histogram[]) throws InvalidHistogramException{
		if(type == RGB)
			throw new InvalidHistogramException();
		this.gray = histogram;
		for(int i = 0; i < gray.length; i++)
			if(gray[i] > maxValue)
				maxValue = gray[i];
	}
	
	public void setHistogram(int histogram[][]) throws InvalidHistogramException{
		if(type == GRAY)
			throw new InvalidHistogramException();
		this.rgb = histogram;
		this.redChannel = rgb[0];
		this.greenChannel = rgb[1];
		this.blueChannel = rgb[2];
		
		for(int i = 0; i < redChannel.length; i++){
			if(redChannel[i] > maxRedValue)
				maxRedValue = redChannel[i];
			
			if(greenChannel[i] > maxGreenValue)
				maxGreenValue = greenChannel[i];
			
			if(blueChannel[i] > maxBlueValue)
				maxBlueValue = blueChannel[i];
		}
	}
	
	public int[] getGrayHistogram() throws InvalidHistogramException{
		if(type == RGB)
				throw new InvalidHistogramException();
		return gray;
	}
	
	public int[][] getRGBHistogram() throws InvalidHistogramException{
		if(type == GRAY)
			throw new InvalidHistogramException();
		return rgb;
	}
	
	public int[] getRedHistogram() throws InvalidHistogramException{
		if(type == GRAY)
			throw new InvalidHistogramException();
		return redChannel;
	}
	
	public int[] getGreenHistogram() throws InvalidHistogramException{
		if(type == GRAY)
			throw new InvalidHistogramException();
		return greenChannel;
	}
	
	public int[] getBlueHistogram() throws InvalidHistogramException{
		if(type == GRAY)
			throw new InvalidHistogramException();
		return blueChannel;
	}
	
	public int[] getGrayHistogramEqualization() throws InvalidHistogramException{
		if(type == RGB)
			throw new InvalidHistogramException();
                int maxScale = this.maxScale+1;
		double[] equalization = new double[maxScale];
		equalization[0] = ((double)(maxScale-1) * ((double)gray[0]/(double)totalPixels));
		for(int i = 1; i < maxScale; i++){
			equalization[i] = equalization[i-1] + ((double)(maxScale-1) * ((double)gray[i]/(double)totalPixels));
			if(equalization[i] >= maxScale)
				equalization[i] = maxScale-1;
		}
		int[] equalizationReturn = new int[maxScale];
		for(int i = 0; i < maxScale; i++){
			equalizationReturn[i] = (int) Math.round(equalization[i]);
		}
		return equalizationReturn;
	}
	
	public int[] getRedHistogramEqualization() throws InvalidHistogramException{
		if(type == GRAY)
			throw new InvalidHistogramException();
                int maxScale = this.maxScale+1;
		double[] equalization = new double[maxScale];
		equalization[0] = ((double)(maxScale-1) * ((double)rgb[0][0]/(double)totalPixels));
		for(int i = 1; i < maxScale; i++){
			equalization[i] = equalization[i-1] + ((double)(maxScale-1) * ((double)rgb[0][i]/(double)totalPixels));
			if(equalization[i] >= maxScale)
				equalization[i] = maxScale-1;
		}
		int[] equalizationReturn = new int[maxScale];
		for(int i = 0; i < maxScale; i++){
			equalizationReturn[i] = (int) Math.round(equalization[i]);
		}
		return equalizationReturn;
	}
	
	public int[] getGreenHistogramEqualization() throws InvalidHistogramException{
		if(type == GRAY)
			throw new InvalidHistogramException();
		double[] equalization = new double[maxScale];
		equalization[0] = ((double)(maxScale-1) * ((double)rgb[1][0]/(double)totalPixels));
		for(int i = 1; i < maxScale; i++){
			equalization[i] = equalization[i-1] + ((double)(maxScale-1) * ((double)rgb[1][i]/(double)totalPixels));
			if(equalization[i] >= maxScale)
				equalization[i] = maxScale-1;
		}
		int[] equalizationReturn = new int[maxScale];
		for(int i = 0; i < maxScale; i++){
			equalizationReturn[i] = (int) Math.round(equalization[i]);
		}
		return equalizationReturn;
	}
	
	public int[] getBlueHistogramEqualization() throws InvalidHistogramException{
		if(type == GRAY)
			throw new InvalidHistogramException();
		double[] equalization = new double[maxScale];
		equalization[0] = ((double)(maxScale-1) * ((double)rgb[2][0]/(double)totalPixels));
		for(int i = 1; i < maxScale; i++){
			equalization[i] = equalization[i-1] + ((double)(maxScale-1) * ((double)rgb[2][i]/(double)totalPixels));
			if(equalization[i] >= maxScale)
				equalization[i] = maxScale-1;
		}
		int[] equalizationReturn = new int[maxScale];
		for(int i = 0; i < maxScale; i++){
			equalizationReturn[i] = (int) Math.round(equalization[i]);
		}
		return equalizationReturn;
	}

}
