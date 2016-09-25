/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fct.unesp.br.bcc.pdi.TPF.UI;

import fct.unesp.br.bcc.pdi.TPF.code.PNMManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 *
 * @author leonardo
 */
public class ToolsPanel extends GeneralJPanel{

    
    private PNMManager manager;
    private Frame mainFrame;
    
    /*
        Flip and Rotate
    */
    
    private JButton flipHorizontalButton;
    private JButton flipVerticalButton;
    private JButton rotate90Button;
    private JButton rotateMinus90Button;
    private JButton rotate180Button;
    private JSeparator rotateSeparator;
    
    /*
        Binarizar
    */
    
    private JLabel binarizarLabel;
    private JSpinner binarizarSpinner;
    private JSeparator binarizarSeparator;
    private JButton binarizarButton;
    /*
        Brilho
    */
    
    private JLabel brilhoLabel;
    private JSpinner brilhoSpinner;
    private JButton brilhoButton;
    private JRadioButton radioBrilhoAdicionar;
    private JRadioButton radioBrilhoMultiplicar;   
    private ButtonGroup radioGroupBrilho;    
    private JSeparator brilhoSeparator;
    
    /*
        Escala
    */
    
    private JLabel escalaLabel;
    private JSpinner escalaSpinner;
    private JButton escalaButton;
    private JSeparator escalaSeparator;
    
    /*
        Blur
    */
    
    private JLabel blurLabel;
    private JSpinner blurSpinner;
    private JButton blurButton;
    private JSeparator blurSeparator;
    
    /*
        Botões
    */
    
    private JButton negativoButton;
    private JButton laplace4Button;
    private JButton laplaceMinus4Button;
    private JButton laplace8Button;
    private JButton laplaceMinus8Button;
    
    
    public ToolsPanel(PNMManager manager, Frame mainFrame){
        super();
        this.manager = manager;
        this.mainFrame = mainFrame;
    }
    
    @Override
    public void init() {
        
    }

    @Override
    public void initComponents() {
        /*
            Flip and Rotate
        */
        
        flipHorizontalButton = new JButton("Flip Horizontal");
        flipVerticalButton = new JButton("Flip Vertical");
        rotate90Button = new JButton("Rotacionar 90º");
        rotateMinus90Button = new JButton("Rotacionar -90º");
        rotate180Button = new JButton("Rotacionar 180º");   
        rotateSeparator = new JSeparator();
        
        /*
            Binarizar
        */
        
        binarizarLabel = new JLabel("Binarizar");
        binarizarSpinner = new JSpinner(new SpinnerNumberModel(1, -9999, 9999, 1));
        binarizarSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        binarizarButton = new JButton("Aplicar");
        
        /*
            Brilho
        */
        
        brilhoLabel = new JLabel("Intensidade:");
        brilhoSpinner = new JSpinner(new SpinnerNumberModel(0, -9999, 9999, 1));
        brilhoButton = new JButton("Aplicar");
        
        radioBrilhoAdicionar = new JRadioButton("Adicionar");
        radioBrilhoMultiplicar = new JRadioButton("Multiplicar");
        
        radioBrilhoAdicionar.setSelected(true);
        
        radioGroupBrilho = new ButtonGroup();
        
        radioGroupBrilho.add(radioBrilhoAdicionar);
        radioGroupBrilho.add(radioBrilhoMultiplicar);
        
        brilhoSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        
        /*
            Escala
        */
        
        escalaLabel = new JLabel("Escala");
        escalaSpinner = new JSpinner(new SpinnerNumberModel(1, 0.2f, 99, 0.1f));
        escalaButton = new JButton("Aplicar");
        
        escalaSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        
        /*
            Blur
        */
        
        blurLabel = new JLabel("Borrar (Filtro da média)");
        blurSpinner = new JSpinner(new SpinnerNumberModel(3,3,99,2));
        blurButton = new JButton("Aplicar");
        
        blurSeparator = new JSeparator(SwingConstants.HORIZONTAL);
       
        /*
            Botões
        */
        negativoButton = new JButton("Negativo");
        laplace4Button = new JButton("Laplace 4");
        laplaceMinus4Button = new JButton("Laplace -4");
        laplace8Button = new JButton("Laplace 8");
        laplaceMinus8Button = new JButton("Laplace -8");
        
        
        flipHorizontalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.flipHorizontal();
                mainFrame.updateImage();
            }
        });
        
        flipVerticalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.flipVertical();
                mainFrame.updateImage();
            }
        });
        
        rotate90Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.rotate90Degrees();
                mainFrame.updateImage();
            }
        });
        
        rotate180Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.rotate180Degrees();
                mainFrame.updateImage();
            }
        });
        
        rotateMinus90Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.rotateMinus90Degrees();
                mainFrame.updateImage();
            }
        });
        
        binarizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.binarizationByPoint((int)binarizarSpinner.getValue());
                mainFrame.updateImage();
            }
        });
        
        brilhoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((Integer)brilhoSpinner.getValue() >= 0){
                    if(radioBrilhoAdicionar.isSelected()){
                        manager.light((Integer)brilhoSpinner.getValue());
                    }else{
                        manager.light((Integer)brilhoSpinner.getValue()*1f);
                    }
                }else{
                    if(radioBrilhoAdicionar.isSelected()){
                        manager.dark(-(Integer)brilhoSpinner.getValue());
                    }else{
                        manager.dark(-(Integer)brilhoSpinner.getValue()*1f);
                    }
                }
                mainFrame.updateImage();
            }
        });
        
        escalaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((double)escalaSpinner.getValue()>=1)
                    manager.enlargeScaleResolutionIn((float)((double)escalaSpinner.getValue()));
                else
                    manager.compressScaleResolutionIn((float)Math.pow((double)escalaSpinner.getValue(),-1));
                mainFrame.updateImage();
            }
        });
        
        blurButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.spacialFilter((int)blurSpinner.getValue());
                mainFrame.updateImage();
            }
        });
        
        negativoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.negative();
                mainFrame.updateImage();
            }
        });
        
        laplace4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.laplace4();
                mainFrame.updateImage();
            }
        });
        
        laplace8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.laplace8();
                mainFrame.updateImage();
            }
        });
        
        laplaceMinus4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.laplaceMinus4();
                mainFrame.updateImage();
            }
        });
        
        laplaceMinus8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.laplaceMinus8();
                mainFrame.updateImage();
            }
        });
    }

    @Override
    public void setComponents() {
        SequentialGroup verticalGroup = layout.createSequentialGroup();
        ParallelGroup horizontalGroup = layout.createParallelGroup();
        
        verticalGroup.addGap(10)
        .addGroup(layout.createParallelGroup()
            .addComponent(flipHorizontalButton,25,25,25)
            .addComponent(flipVerticalButton,25,25,25))
                
        .addGroup(layout.createParallelGroup()
            .addComponent(rotate90Button,25,25,25)
            .addComponent(rotateMinus90Button,25,25,25)
            .addComponent(rotate180Button,25,25,25))
        .addGap(10)
        .addComponent(rotateSeparator,5,5,5)
        .addGap(10)
        
        .addGroup(layout.createParallelGroup()
            .addComponent(binarizarLabel,25,25,25)
            .addComponent(binarizarSpinner,25,25,25)
            .addComponent(binarizarButton,25,25,25))
        .addGap(10)
        .addComponent(binarizarSeparator,5,5,5)
        .addGap(10)
                
        .addGroup(layout.createParallelGroup()
            .addComponent(brilhoLabel,25,25,25)
            .addComponent(brilhoSpinner,25,25,25)
            .addComponent(brilhoButton,25,25,25))
        .addGroup(layout.createParallelGroup()
            .addComponent(radioBrilhoAdicionar,25,25,25)
            .addComponent(radioBrilhoMultiplicar,25,25,25))
        .addGap(10)
        .addComponent(brilhoSeparator,5,5,5)
        .addGap(10)
                
        .addGroup(layout.createParallelGroup()
            .addComponent(escalaLabel,25,25,25)
            .addComponent(escalaSpinner,25,25,25)
            .addComponent(escalaButton,25,25,25))
        .addGap(10)
        .addComponent(escalaSeparator,5,5,5)
        .addGap(10)
                
        .addGroup(layout.createParallelGroup()
            .addComponent(blurLabel,25,25,25)
            .addComponent(blurSpinner,25,25,25)
            .addComponent(blurButton,25,25,25))
        .addGap(10)        
        .addComponent(blurSeparator,5,5,5)
        .addGap(10)
        
        .addGap(10)
        .addGroup(layout.createParallelGroup()
            .addComponent(negativoButton,25,25,25)
            .addComponent(laplace4Button,25,25,25)
            .addComponent(laplaceMinus4Button,25,25,25)
            .addComponent(laplace8Button,25,25,25)
            .addComponent(laplaceMinus8Button,25,25,25)
        );
        
        
        
        horizontalGroup.addGroup(layout.createSequentialGroup()
            .addComponent(flipHorizontalButton)
            .addComponent(flipVerticalButton))
                
        .addGroup(layout.createSequentialGroup()
            .addComponent(rotate90Button)
            .addComponent(rotateMinus90Button)
            .addComponent(rotate180Button))
        .addComponent(rotateSeparator)
                
        .addGroup(layout.createSequentialGroup()
            .addComponent(binarizarLabel)
            .addGap(5)
            .addComponent(binarizarSpinner,100,100,100)
            .addComponent(binarizarButton))
        .addComponent(binarizarSeparator)
                
        .addGroup(layout.createSequentialGroup()
            .addComponent(brilhoLabel)
            .addGap(5)
            .addComponent(brilhoSpinner,100,100,100)
            .addComponent(brilhoButton))
        .addGroup(layout.createSequentialGroup()
            .addComponent(radioBrilhoAdicionar)
            .addComponent(radioBrilhoMultiplicar))
        .addComponent(brilhoSeparator)
                
        .addGroup(layout.createSequentialGroup()
            .addComponent(escalaLabel)
            .addGap(5)
            .addComponent(escalaSpinner,100,100,100)
            .addComponent(escalaButton))
        .addComponent(escalaSeparator)
                
        .addGroup(layout.createSequentialGroup()
            .addComponent(blurLabel)
            .addGap(5)
            .addComponent(blurSpinner,100,100,100)
            .addComponent(blurButton))
        .addComponent(blurSeparator)
                
        .addGroup(layout.createSequentialGroup()
            .addComponent(negativoButton)                
            .addComponent(laplace4Button)
            .addComponent(laplaceMinus4Button)
            .addComponent(laplace8Button)
            .addComponent(laplaceMinus8Button)    
        );
        
        
        
        setVerticalGroup(verticalGroup);
        setHorizontalGroup(horizontalGroup);
    }
    
    public ToolsPanel setManager(PNMManager manager){
        this.manager = manager;
        return this;
    }
    
}
