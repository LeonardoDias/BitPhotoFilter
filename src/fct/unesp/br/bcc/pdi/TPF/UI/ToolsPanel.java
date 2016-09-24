/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fct.unesp.br.bcc.pdi.TPF.UI;

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

    /*
        Flip and Rotate
    */
    
    private JButton flipHorizontalButton;
    private JButton flipVerticalButton;
    private JButton rotate90Button;
    private JButton rotateMinus90Button;
    private JButton rotate180Button;
    private JButton rotateMinus180Button;
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
        Transformações Lineares
    */
    private JLabel transformacoesLabel;
    private JButton transformacoesLogaritmaButton;
    private JSpinner transformacoesGamaSpinner;
    private JButton transformacoesGamaButton;
    private JSeparator transformacoesSeparator;
    
    /*
        Botões
    */
    
    private JButton negativoButton;
    private JButton laplace4Button;
    private JButton laplaceMinus4Button;
    private JButton laplace8Button;
    private JButton laplaceMinus8Button;
    
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
        rotateMinus180Button = new JButton("Rotacionar -180º");    
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
        escalaSpinner = new JSpinner(new SpinnerNumberModel(1, 0.1, 99, 0.1));
        escalaButton = new JButton("Aplicar");
        
        escalaSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        
        /*
            Blur
        */
        
        blurLabel = new JLabel("Borrar (Filtro da média)");
        blurSpinner = new JSpinner(new SpinnerNumberModel(1,1,99,1));
        blurButton = new JButton("Aplicar");
        
        blurSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        
        /*
            Transformações Lineares
        */
        
        transformacoesLabel = new JLabel("Transformações Lineares");
        transformacoesLogaritmaButton = new JButton("Log");
        transformacoesGamaSpinner = new JSpinner(new SpinnerNumberModel(1.0, 0.01, 99, 0.01));
        transformacoesGamaButton = new JButton("Gama");
        transformacoesSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        /*
            Botões
        */
        negativoButton = new JButton("Negativo");
        laplace4Button = new JButton("Laplace 4");
        laplaceMinus4Button = new JButton("Laplace -4");
        laplace8Button = new JButton("Laplace 8");
        laplaceMinus8Button = new JButton("Laplace -8");
        
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
            .addComponent(rotate180Button,25,25,25)
            .addComponent(rotateMinus180Button,25,25,25))
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
                
        .addComponent(transformacoesLabel,25,25,25)
        .addComponent(transformacoesLogaritmaButton,25,25,25)
        .addGroup(layout.createParallelGroup()
            .addComponent(transformacoesGamaSpinner,25,25,25)
            .addComponent(transformacoesGamaButton,25,25,25))
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
            .addComponent(rotate180Button)
            .addComponent(rotateMinus180Button))
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
                
        .addComponent(transformacoesLabel)
        .addComponent(transformacoesLogaritmaButton)
        .addGroup(layout.createSequentialGroup()
            .addComponent(transformacoesGamaSpinner,100,100,100)
            .addComponent(transformacoesGamaButton))
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
    
}
