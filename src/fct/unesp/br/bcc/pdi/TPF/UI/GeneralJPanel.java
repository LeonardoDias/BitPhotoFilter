package fct.unesp.br.bcc.pdi.TPF.UI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Group;
import javax.swing.JPanel;

public abstract class GeneralJPanel extends JPanel implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6851994937358015620L;

	protected GroupLayout layout;
	protected Group verticalGroup;
	protected Group horizontalGroup;
	protected int FPS;
	
	public GeneralJPanel(){
		super();
		layout = new GroupLayout(this);
		FPS = 60;
		init();
		initComponents();
		setComponents();
		setLayout();
		setVisible(true);
	}
	
	public abstract void init();

	public abstract void initComponents();

	public abstract void setComponents();
	
	public abstract void draw();
	
	private void setLayout(){
		setLayout(layout);
		layout.setHorizontalGroup(horizontalGroup);
		layout.setVerticalGroup(verticalGroup);
	}

	public Group getVerticalGroup() {
		return verticalGroup;
	}

	public void setVerticalGroup(Group verticalGroup) {
		this.verticalGroup = verticalGroup;
	}

	public Group getHorizontalGroup() {
		return horizontalGroup;
	}

	public void setHorizontalGroup(Group horizontalGroup) {
		this.horizontalGroup = horizontalGroup;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep(1000/FPS);
			} catch (InterruptedException e) {
				
			}
			draw();
		}
	}
	
}
