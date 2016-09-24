/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fct.unesp.br.bcc.pdi.TPF.UI;

import fct.unesp.br.bcc.pdi.TPF.fileTypes.PGM;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PNM;
import fct.unesp.br.bcc.pdi.TPF.fileTypes.PPM;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author leonardo
 */
class ExportPanel extends JPanel {
    
    private JButton exportGrayButton;
    private JButton exportRedButton;
    private JButton exportGreenButton;
    private JButton exportBlueButton;
    private JButton exportCianButton;
    private JButton exportYellowButton;
    private JButton exportMagentButton;

    public ExportPanel(PNM image) {
        initComponents(image);
    }

    public void initComponents(PNM image) {
        exportGrayButton = new JButton("Exportar cinza");
        exportRedButton = new JButton("Exportar vermelho");
        exportGreenButton = new JButton("Exportar verde");
        exportBlueButton = new JButton("Exportar azul");
        exportCianButton = new JButton("Exportar ciano");
        exportYellowButton = new JButton("Exportar amarelo");
        exportMagentButton = new JButton("Exportar magenta");
        
        exportGrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(image instanceof PGM)
                        JOptionPane.showMessageDialog(null, "Canais podem ser exportados apenas por imagens coloridas", "Erro", JOptionPane.ERROR_MESSAGE);
                    else{
                        JFileChooser JFC = new JFileChooser();
                        FileNameExtensionFilter extensionFilter =
                                new FileNameExtensionFilter("PGM", "pgm");
                        JFC.setFileFilter(extensionFilter);
                        JFC.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        if(JFC.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                            ((PPM)image).saveFileGrey(JFC.getSelectedFile().getAbsolutePath());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ExportPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        exportRedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(image instanceof PGM)
                        JOptionPane.showMessageDialog(null, "Canais podem ser exportados apenas por imagens coloridas", "Erro", JOptionPane.ERROR_MESSAGE);
                    else{
                        JFileChooser JFC = new JFileChooser();
                        FileNameExtensionFilter extensionFilter =
                                new FileNameExtensionFilter("PGM", "pgm");
                        JFC.setFileFilter(extensionFilter);
                        JFC.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        if(JFC.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                            ((PPM)image).saveFileRed(JFC.getSelectedFile().getAbsolutePath());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ExportPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        exportGreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(image instanceof PGM)
                        JOptionPane.showMessageDialog(null, "Canais podem ser exportados apenas por imagens coloridas", "Erro", JOptionPane.ERROR_MESSAGE);
                    else{
                        JFileChooser JFC = new JFileChooser();
                        FileNameExtensionFilter extensionFilter =
                                new FileNameExtensionFilter("PGM", "pgm");
                        JFC.setFileFilter(extensionFilter);
                        JFC.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        if(JFC.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                            ((PPM)image).saveFileGreen(JFC.getSelectedFile().getAbsolutePath());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ExportPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        exportBlueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(image instanceof PGM)
                        JOptionPane.showMessageDialog(null, "Canais podem ser exportados apenas por imagens coloridas", "Erro", JOptionPane.ERROR_MESSAGE);
                    else{
                        JFileChooser JFC = new JFileChooser();
                        FileNameExtensionFilter extensionFilter =
                                new FileNameExtensionFilter("PGM", "pgm");
                        JFC.setFileFilter(extensionFilter);
                        JFC.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        if(JFC.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                            ((PPM)image).saveFileBlue(JFC.getSelectedFile().getAbsolutePath());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ExportPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        exportCianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(image instanceof PGM)
                        JOptionPane.showMessageDialog(null, "Canais podem ser exportados apenas por imagens coloridas", "Erro", JOptionPane.ERROR_MESSAGE);
                    else{
                        JFileChooser JFC = new JFileChooser();
                        FileNameExtensionFilter extensionFilter =
                                new FileNameExtensionFilter("PGM", "pgm");
                        JFC.setFileFilter(extensionFilter);
                        JFC.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        if(JFC.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                            ((PPM)image).saveFileCian(JFC.getSelectedFile().getAbsolutePath());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ExportPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        exportYellowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(image instanceof PGM)
                        JOptionPane.showMessageDialog(null, "Canais podem ser exportados apenas por imagens coloridas", "Erro", JOptionPane.ERROR_MESSAGE);
                    else{
                        JFileChooser JFC = new JFileChooser();
                        FileNameExtensionFilter extensionFilter =
                                new FileNameExtensionFilter("PGM", "pgm");
                        JFC.setFileFilter(extensionFilter);
                        JFC.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        if(JFC.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                            ((PPM)image).saveFileYellow(JFC.getSelectedFile().getAbsolutePath());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ExportPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        exportMagentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(image instanceof PGM)
                        JOptionPane.showMessageDialog(null, "Canais podem ser exportados apenas por imagens coloridas", "Erro", JOptionPane.ERROR_MESSAGE);
                    else{
                        JFileChooser JFC = new JFileChooser();
                        FileNameExtensionFilter extensionFilter =
                                new FileNameExtensionFilter("PGM", "pgm");
                        JFC.setFileFilter(extensionFilter);
                        JFC.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        if(JFC.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                            ((PPM)image).saveFileMagent(JFC.getSelectedFile().getAbsolutePath());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ExportPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
     
        GroupLayout GL = new GroupLayout(this);
        setLayout(GL);
        
        SequentialGroup verticalGroup = GL.createSequentialGroup();
        ParallelGroup horizontalGroup = GL.createParallelGroup();
        
        verticalGroup
                .addGap(5)
                .addComponent(exportGrayButton,25,25,25)
                .addGap(5)
                .addComponent(exportRedButton,25,25,25)
                .addGap(5)
                .addComponent(exportGreenButton,25,25,25)
                .addGap(5)
                .addComponent(exportBlueButton,25,25,25)
                .addGap(5)
                .addComponent(exportCianButton,25,25,25)
                .addGap(5)
                .addComponent(exportYellowButton,25,25,25)
                .addGap(5)
                .addComponent(exportMagentButton,25,25,25);
        
        
        horizontalGroup
            .addGroup(GL.createSequentialGroup()
                .addGap(5)
                .addComponent(exportGrayButton,200,200,200)
                .addGap(5))
            .addGroup(GL.createSequentialGroup()
                .addGap(5)
                .addComponent(exportRedButton,200,200,200)
                .addGap(5))
            .addGroup(GL.createSequentialGroup()
                .addGap(5)
                .addComponent(exportGreenButton,200,200,200)
                .addGap(5))
            .addGroup(GL.createSequentialGroup()
                .addGap(5)    
                .addComponent(exportBlueButton,200,200,200)
                .addGap(5))
            .addGroup(GL.createSequentialGroup()
                .addGap(5)
                .addComponent(exportCianButton,200,200,200)
                .addGap(5))
            .addGroup(GL.createSequentialGroup()
                .addGap(5)
                .addComponent(exportYellowButton,200,200,200)
                .addGap(5))
            .addGroup(GL.createSequentialGroup()
                .addGap(5)
                .addComponent(exportMagentButton,200,200,200)
                .addGap(5));
    
        GL.setVerticalGroup(verticalGroup);
        GL.setHorizontalGroup(horizontalGroup);
        
    }
    
}
