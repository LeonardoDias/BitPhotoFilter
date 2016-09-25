package fct.unesp.br.bcc.pdi.TPF.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import fct.unesp.br.bcc.pdi.TPF.fileTypes.PGM;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PNM;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PPM;

public class ImagePanel extends GeneralJPanel implements Runnable{

	private static final long serialVersionUID = -4292658222164789208L;
	private Graphics2D graphics;
	private BufferedImage image;
	private PNM pnm;
	private boolean hasAlteration;
	private int FPS;
	
	@Override
	public void init() {
		FPS = 60;
		graphics = null;
		image = null;
		pnm = null;
	}

	@Override
	public void initComponents() {}

	@Override
	public void setComponents() {
		setVerticalGroup(layout.createSequentialGroup());
		setHorizontalGroup(layout.createSequentialGroup());
	}
	
	public void setImage(PNM pnm){
		image = new BufferedImage(pnm.getWidth(), pnm.getHeight(), BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D) image.getGraphics();
		this.pnm = pnm;
	}

	public void draw() {
		
		if(hasAlteration){
			
			if(getPreferredSize().getWidth() < getSize().getWidth() || 
					getPreferredSize().getHeight() < getSize().getHeight())
					enlargePanel((int)Math.round(getPreferredSize().getWidth() - getSize().getWidth()), 
							(int)Math.round(getPreferredSize().getHeight() - getSize().getHeight()));
			
			if(getPreferredSize().getWidth() < image.getWidth() || 
					getPreferredSize().getHeight() < image.getHeight()){
				enlargePanel((int)Math.round(image.getWidth() - getPreferredSize().getWidth()), 
						(int)Math.round(image.getHeight() - getPreferredSize().getHeight()));
			}
			
			if(pnm instanceof PGM){
				int matriz[][] = ((PGM) pnm).getMatrix(); 
					for(int i = 0; i < pnm.getHeight(); i++)
						for(int j = 0; j < pnm.getWidth(); j++){
						if(((PGM) pnm).getMaxScale() != 255)
							graphics.setColor(new Color(matriz[i][j]*((PGM) pnm).getMaxScale()/255,
									matriz[i][j]*((PGM) pnm).getMaxScale()/255, 
									matriz[i][j]*((PGM) pnm).getMaxScale()/255));
						else
							graphics.setColor(new Color(matriz[i][j], matriz[i][j], matriz[i][j]));
						graphics.drawRect(j, i, 1, 1);
					}
			}
			else if(pnm instanceof PPM){
				int matriz[][][] = ((PPM) pnm).getMatrix(); 
					for(int i = 0; i < pnm.getHeight(); i++)
						for(int j = 0; j < pnm.getWidth(); j++){
							if(((PPM) pnm).getMaxScale() != 255)
								graphics.setColor(new Color(matriz[0][i][j]*((PPM) pnm).getMaxScale()/255,
										matriz[1][i][j]*((PPM) pnm).getMaxScale()/255, 
										matriz[2][i][j]*((PPM) pnm).getMaxScale()/255));
							else
								graphics.setColor(new Color(matriz[0][i][j], matriz[1][i][j], matriz[2][i][j]));
							graphics.drawRect(j, i, 1, 1);
					}
			}
			hasAlteration = false;
		}
                getGraphics().setColor(Color.WHITE);
                getGraphics().fillRect(0, 0, getSize().width, getSize().height);
		getGraphics().drawImage(image, (getSize().width - image.getWidth())/2, 
				(getSize().height - image.getHeight())/2, 
				null);
	}
	
	private void enlargePanel(int dx, int dy){
		int nx, ny;
		nx = (int)Math.round(getPreferredSize().getWidth());
		ny = (int)Math.round(getPreferredSize().getHeight());
		nx += dx;
		ny += dy;
		setPreferredSize(new Dimension(nx,ny));
		revalidate();
	}	
	
	public void hasAlteration(){
		hasAlteration = true;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep(1000/FPS);
			} catch (InterruptedException e) {}
			draw();
		}
	}
}
