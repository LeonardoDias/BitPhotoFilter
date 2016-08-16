package fct.unesp.br.bcc.pdi.TPF.fileTypes;

import java.io.IOException;
import java.security.InvalidParameterException;

/*
 * Create by Leonardo Dias Conceição
 * Specifies a generic PNM Class for PBM, PGM and PPM files
 */

public abstract class PNM {
	
	/*
	 * Static content for format type
	 */
	
	public static final String PBMASCII = "P1";
	public static final String PGMASCII = "P2";
	public static final String PPMASCII = "P3";
	public static final String PBMBinary = "P4";
	public static final String PGMBinary = "P5";
	public static final String PPMBinary = "P6";
	
	/*
	 * Private attributes for header's field
	 */
	
	private String type;
	private int width;
	private int height;
	
	public PNM(){
		
	}
	
	public PNM(String type, int width, int height) throws InvalidParameterException{
		if(!(type.equals(PBMASCII) || type.equals(PGMASCII) || type.equals(PPMASCII) || 
			type.equals(PBMBinary) || type.equals(PGMBinary) || type.equals(PPMBinary)))
			throw new InvalidParameterException("Invalid type format");
		if(width <= 0)
			throw new InvalidParameterException("Width value must be greater than 0");
		if(height <= 0)
			throw new InvalidParameterException("Height value must be greater than 0");
	
		this.type = type;
		this.width = width;
		this.height = height;			
	}

	public String getTypeName(){
		switch(type){
			case "P1":
				return "PBM ASCII";
			case "P2":
				return "PGM ASCII";
			case "P3":
				return "PPM ASCII";
			case "P4":
				return "PBM Binary";
			case "P5":
				return "PGM Binary";
			case "P6":
				return "PPM Binary";
			default:
				return "Unknown";
		}
	}
	
	public abstract void saveFile(String file) throws IOException;
	public abstract void setHistogram();
	public abstract void setAverageValue();
	
	/*
	 * Getters and Setters
	 */

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
