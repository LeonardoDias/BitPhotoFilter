package fct.unesp.br.bcc.pdi.TPF.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Created by Leonardo Dias Conceição
 * File Handler for openning and closing text files 
 */

public class FileHandler {
	
	private File file;
	private BufferedReader BR;
	private BufferedWriter BW;
	
	
	public FileHandler(String path){
		this.file = new File(path);
	}
	
	/*
	 * METHODS
	 */
	
	public void openReaderFile() throws FileNotFoundException{
		BR = new BufferedReader(new FileReader(file));
	}
	
	public void mark() throws NumberFormatException, IOException{
		BR.mark(65535);
	}
	
	public void resetOnMark() throws IOException{
		BR.reset();
	}
	
	public int readInt(int maxDigits) throws IOException{
		char number[] = new char[1];
		short i = 0;
		int return_value = 0;
		int multiply_value = 10;
		do{
			BR.read(number);
			if(number[0] < 48 || number[0] >= 58){
				if(i == 0) continue;
				else break;
			}
			else if(number[0] == -1){
				break;
			}
			else{
				return_value *= multiply_value;
				return_value += number[0]%48;
				i++;
			}
		}while(i < maxDigits);
		return return_value;
	}
	
	public String readLine() throws IOException{
		return BR.readLine();
	}
	
	public boolean ready() throws IOException{
		return BR.ready();
	}
	
	public void closeReaderFile(){
		try {
			BR.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void openWriterFile(){
		try {
			BW = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write(String word) throws IOException{
		BW.write(word);
	}
	
	public void writeLine(String word) throws IOException{
		BW.write(word+"\n");
	}
	
	public void closeWriterFile(){
		try {
			BW.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
