/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VENTANAS;

import BASE_DE_DATOS.ConexionMysql;
import LIMITADOR.BUSCAR;
import LIMITADOR.LIMITARCARACTER;
import com.mysql.jdbc.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paula
 */
public class MODCLI extends javax.swing.JDialog {

    private DefaultTableModel modelo;

    /**
     * Creates new form MODCLI
     */
    public MODCLI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargartabla();
        INHABILITAR();
        LIMITAR();
        SLETRAS(textNOMBRES);
        SLETRAS(textPATERNO);
        SLETRAS(textMATERNO);
        SLETRAS(textCALLE);
        SLETRAS(textCOL);
        SLETRAS(textDELG);
        SNUMEROS(textTEL);
        SNUMEROS(textNUM);
        SNUMEROS(textCP);
    }
    public void LIMITAR() {
        textNOMBRES.setDocument(new LIMITARCARACTER(textNOMBRES, 15));
        textPATERNO.setDocument(new LIMITARCARACTER(textPATERNO, 15));
        textMATERNO.setDocument(new LIMITARCARACTER(textMATERNO, 15));
        textCALLE.setDocument(new LIMITARCARACTER(textCALLE, 15));
        textNUM.setDocument(new LIMITARCARACTER(textNUM, 5));
        textCOL.setDocument(new LIMITARCARACTER(textCOL, 15));
        textDELG.setDocument(new LIMITARCARACTER(textDELG, 25));
        textCP.setDocument(new LIMITARCARACTER(textCP, 5));
        textTEL.setDocument(new LIMITARCARACTER(textTEL, 10));
    }

    public void SLETRAS(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }
     public void SNUMEROS(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        btnCERRAR = new javax.swing.JButton();
        btnBUSCAR = new javax.swing.JButton();
        textBUSCAR1 = new org.edisoncor.gui.textField.TextField();
        btnCANCELAR = new javax.swing.JButton();
        btnMODIFICAR = new javax.swing.JButton();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        textNOMBRES = new org.edisoncor.gui.textField.TextField();
        jLabel14 = new javax.swing.JLabel();
        textPATERNO = new org.edisoncor.gui.textField.TextField();
        jLabel12 = new javax.swing.JLabel();
        textMATERNO = new org.edisoncor.gui.textField.TextField();
        jLabel6 = new javax.swing.JLabel();
        textCALLE = new org.edisoncor.gui.textField.TextField();
        jLabel15 = new javax.swing.JLabel();
        textNUM = new org.edisoncor.gui.textField.TextField();
        jLabel16 = new javax.swing.JLabel();
        textCOL = new org.edisoncor.gui.textField.TextField();
        jLabel11 = new javax.swing.JLabel();
        textDELG = new org.edisoncor.gui.textField.TextField();
        jLabel17 = new javax.swing.JLabel();
        textCP = new org.edisoncor.gui.textField.TextField();
        jLabel5 = new javax.swing.JLabel();
        textTEL = new org.edisoncor.gui.textField.TextField();
        btnSELECCIONAR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(50, 119, 255));
        panel1.setColorSecundario(new java.awt.Color(200, 216, 252));

        btnCERRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/CERRAR-NORM.png"))); // NOI18N
        btnCERRAR.setBorder(null);
        btnCERRAR.setBorderPainted(false);
        btnCERRAR.setContentAreaFilled(false);
        btnCERRAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCERRAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCERRAR.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/CERRAR-PRESS.png"))); // NOI18N
        btnCERRAR.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/CERRAR-ROLL.png"))); // NOI18N
        btnCERRAR.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCERRAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCERRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCERRARActionPerformed(evt);
            }
        });

        btnBUSCAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/BUSCAR-NORM.png"))); // NOI18N
        btnBUSCAR.setBorder(null);
        btnBUSCAR.setBorderPainted(false);
        btnBUSCAR.setContentAreaFilled(false);
        btnBUSCAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBUSCAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBUSCAR.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/BUSCAR-PRESS.png"))); // NOI18N
        btnBUSCAR.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/BUSCAR-ROLL.png"))); // NOI18N
        btnBUSCAR.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBUSCAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBUSCARActionPerformed(evt);
            }
        });

        btnCANCELAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/CANCELAR-NORM.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnCANCELAR, org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.btnCANCELAR.text")); // NOI18N
        btnCANCELAR.setBorder(null);
        btnCANCELAR.setBorderPainted(false);
        btnCANCELAR.setContentAreaFilled(false);
        btnCANCELAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCANCELAR.setDefaultCapable(false);
        btnCANCELAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCANCELAR.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/CANCELAR-PRESS.png"))); // NOI18N
        btnCANCELAR.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/CANCELAR-ROLL.png"))); // NOI18N
        btnCANCELAR.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCANCELAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCANCELARActionPerformed(evt);
            }
        });

        btnMODIFICAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/MOD-NORM.png"))); // NOI18N
        btnMODIFICAR.setBorder(null);
        btnMODIFICAR.setBorderPainted(false);
        btnMODIFICAR.setContentAreaFilled(false);
        btnMODIFICAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMODIFICAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMODIFICAR.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/MOD-PRESS.png"))); // NOI18N
        btnMODIFICAR.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/MOD-ROLL.png"))); // NOI18N
        btnMODIFICAR.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnMODIFICAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMODIFICARActionPerformed(evt);
            }
        });

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/LETRERO-CLIENTES.png"))); // NOI18N

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblDatos);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(200, 216, 252));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.jLabel2.text")); // NOI18N

        textNOMBRES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNOMBRESActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(200, 216, 252));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel14, org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.jLabel14.text")); // NOI18N

        textPATERNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPATERNOActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(200, 216, 252));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.jLabel12.text")); // NOI18N

        textMATERNO.setText(org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.textMATERNO.text")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(200, 216, 252));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.jLabel6.text")); // NOI18N

        textCALLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCALLEActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(200, 216, 252));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel15, org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.jLabel15.text")); // NOI18N

        textNUM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNUMActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(200, 216, 252));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel16, org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.jLabel16.text")); // NOI18N

        textCOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCOLActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(200, 216, 252));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.jLabel11.text")); // NOI18N

        textDELG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDELGActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(200, 216, 252));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel17, org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.jLabel17.text")); // NOI18N

        textCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCPActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(200, 216, 252));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.jLabel5.text")); // NOI18N

        textTEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTELActionPerformed(evt);
            }
        });

        btnSELECCIONAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/SELECCIONAR-NORM.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(btnSELECCIONAR, org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.btnSELECCIONAR.text")); // NOI18N
        btnSELECCIONAR.setToolTipText(org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.btnSELECCIONAR.toolTipText")); // NOI18N
        btnSELECCIONAR.setBorder(null);
        btnSELECCIONAR.setBorderPainted(false);
        btnSELECCIONAR.setContentAreaFilled(false);
        btnSELECCIONAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSELECCIONAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSELECCIONAR.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/SELECCIONAR-PRESS.png"))); // NOI18N
        btnSELECCIONAR.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/SELECCIONAR-ROLL.png"))); // NOI18N
        btnSELECCIONAR.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSELECCIONAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSELECCIONAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSELECCIONARActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 40, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(MODCLI.class, "MODCLI.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCERRAR))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGap(313, 313, 313)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(textPATERNO, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel12))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(textNUM, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel16))))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textNOMBRES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textCALLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textDELG, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(126, 126, 126)
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(btnBUSCAR)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(textCP, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5))))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel1)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnMODIFICAR))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(textBUSCAR1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(252, 252, 252)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnSELECCIONAR)
                                            .addComponent(btnCANCELAR))
                                        .addGap(59, 59, 59)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textMATERNO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textCOL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textTEL, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNOMBRES, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel14)
                            .addComponent(textPATERNO, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMATERNO, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(34, 34, 34)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textCALLE, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(textNUM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(textCOL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(textDELG, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textCP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel5)
                            .addComponent(textTEL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMODIFICAR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCANCELAR))
                        .addGap(34, 34, 34)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(textBUSCAR1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBUSCAR)))
                    .addComponent(btnSELECCIONAR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCERRAR)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCERRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCERRARActionPerformed
        cerrar();
        Menu m = new Menu();
        m.setTitle("CLIENTES");
        m.setLocationRelativeTo(null);
        m.setVisible(true);
    }

    private void cerrar() {
        this.setVisible(false);
    }//GEN-LAST:event_btnCERRARActionPerformed

    private void btnBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBUSCARActionPerformed
        String valor = textBUSCAR1.getText();
        BUSCAR(valor);
    }//GEN-LAST:event_btnBUSCARActionPerformed

    private void btnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCANCELARActionPerformed
        INHABILITAR();
    }//GEN-LAST:event_btnCANCELARActionPerformed

    private void textNOMBRESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNOMBRESActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNOMBRESActionPerformed

    private void textPATERNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPATERNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPATERNOActionPerformed

    private void textCALLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCALLEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCALLEActionPerformed

    private void textNUMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNUMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNUMActionPerformed

    private void textCOLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCOLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCOLActionPerformed

    private void textDELGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDELGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDELGActionPerformed

    private void textCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCPActionPerformed

    private void textTELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTELActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTELActionPerformed
    
    private void btnMODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMODIFICARActionPerformed

        ConexionMysql mysql = new ConexionMysql();
        com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) mysql.Conectar();
        String nom, apep, apem, ca, nu, col, del, cp, tel;
        String sSQL = "";
        String mensaje = "";
        nom = textNOMBRES.getText();
        apep = textPATERNO.getText();
        apem = textMATERNO.getText();
        ca = textCALLE.getText();
        nu = textNUM.getText();
        col = textCOL.getText();
        del = textDELG.getText();
        cp = textCP.getText();
        tel = textTEL.getText();
        sSQL = "UPDATE cliente SET Nombres= ?, ApellidoPaterno = ?, ApellidoMaterno = ?, Calle = ?, Numero= ?, Colonia= ?, Delegacion= ?, CP = ?, Telefono= ? WHERE IDCliente=" + id_actualizar;
        mensaje = "¡Los Datos han sido modificados exitosamente!";
        try {
            com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sSQL);
            pst.setString(1, nom);
            pst.setString(2, apep);
            pst.setString(3, apem);
            pst.setString(4, ca);
            pst.setString(5, nu);
            pst.setString(6, col);
            pst.setString(7, del);
            pst.setString(8, cp);
            pst.setString(9, tel);

            int n = pst.executeUpdate();

            if (n > 0) {
                JOptionPane.showMessageDialog(null, mensaje);
                cargartabla();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        INHABILITAR();
    }//GEN-LAST:event_btnMODIFICARActionPerformed

    private void btnSELECCIONARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSELECCIONARActionPerformed
        int filasel;
        String id;
        try {
            filasel = tblDatos.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila");
            } else {

                modelo = (DefaultTableModel) tblDatos.getModel();
                id = (String) modelo.getValueAt(filasel, 0);
                HABILITAR();
                ModificarUsuarios(id);
                btnSELECCIONAR.setEnabled(true);
            }

        } catch (Exception e) {

        }// TODO add your handling code here:
    }//GEN-LAST:event_btnSELECCIONARActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MODCLI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MODCLI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MODCLI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MODCLI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MODCLI dialog = new MODCLI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBUSCAR;
    private javax.swing.JButton btnCANCELAR;
    private javax.swing.JButton btnCERRAR;
    private javax.swing.JButton btnMODIFICAR;
    private javax.swing.JButton btnSELECCIONAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JTable tblDatos;
    private org.edisoncor.gui.textField.TextField textBUSCAR1;
    private org.edisoncor.gui.textField.TextField textCALLE;
    private org.edisoncor.gui.textField.TextField textCOL;
    private org.edisoncor.gui.textField.TextField textCP;
    private org.edisoncor.gui.textField.TextField textDELG;
    private org.edisoncor.gui.textField.TextField textMATERNO;
    private org.edisoncor.gui.textField.TextField textNOMBRES;
    private org.edisoncor.gui.textField.TextField textNUM;
    private org.edisoncor.gui.textField.TextField textPATERNO;
    private org.edisoncor.gui.textField.TextField textTEL;
    // End of variables declaration//GEN-END:variables

    private void BUSCAR(String valor) {

        String[] titulos = {"ID", "Nombre", "ApellidoP", "ApellidoM", "Calle", "#", "Col", "Del", "CP", "TEL"};
        String[] registro = new String[10];
        String sSQL = "";
        modelo = new DefaultTableModel(null, titulos);

        ConexionMysql mysql = new ConexionMysql();
        com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) mysql.Conectar();

        sSQL = "SELECT IDCliente,Nombres,ApellidoPaterno,ApellidoMaterno,Calle,Numero,Colonia,Delegacion,CP,Telefono FROM cliente "
                + "WHERE CONCAT(Nombres, ' ',ApellidoPaterno) LIKE '%" + valor + "%'";
        try {
            com.mysql.jdbc.Statement st = (com.mysql.jdbc.Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("IDCliente");
                registro[1] = rs.getString("Nombres");
                registro[2] = rs.getString("ApellidoPaterno");
                registro[3] = rs.getString("ApellidoMaterno");
                registro[4] = rs.getString("Calle");
                registro[5] = rs.getString("Numero");
                registro[6] = rs.getString("Colonia");
                registro[7] = rs.getString("Delegacion");
                registro[8] = rs.getString("CP");
                registro[9] = rs.getString("Telefono");
                modelo.addRow(registro);
            }
            tblDatos.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void ELIMINAR(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void HABILITAR() {
        textCALLE.setEnabled(true);
        textCOL.setEnabled(true);
        textCP.setEnabled(true);
        
        textMATERNO.setEnabled(true);
        textNOMBRES.setEnabled(true);
        textNUM.setEnabled(true);
        textPATERNO.setEnabled(true);
        textTEL.setEnabled(true);
        textDELG.setEnabled(true);
        btnSELECCIONAR.setEnabled(true);
        btnCANCELAR.setEnabled(true);
    }
String id_actualizar = "";
     void ModificarUsuarios(String id) {
        
        String sSQL = "";
        String no = "", apep =  "", apem = "", ca = "", nu = "", col = "", del = "", cp = "", tel = "";
        ConexionMysql mysql = new ConexionMysql();
        com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) mysql.Conectar();

        sSQL = "SELECT IDCliente,Nombres,ApellidoPaterno,ApellidoMaterno,Calle,Numero,Colonia,Delegacion,CP,Telefono FROM cliente "
                + "WHERE IDCliente = " + id;

        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                
                no = rs.getString("Nombres");
                apep = rs.getString("ApellidoPaterno");
                apem = rs.getString("ApellidoMaterno");
                ca = rs.getString("Calle");
                nu = rs.getString("Numero");
                col = rs.getString("Colonia");
                del = rs.getString("Delegacion");
                cp = rs.getString("CP");
                tel = rs.getString("Telefono");
            }
            
            textNOMBRES.setText(no);
            textPATERNO.setText(apep);
            textMATERNO.setText(apem);
            textCALLE.setText(ca);
            textNUM.setText(nu);
            textCOL.setText(col);
            textDELG.setText(del);
            textCP.setText(cp);
            textTEL.setText(tel);
            id_actualizar = id;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    void cargartabla() {
        String[] titulos = {"ID", "Nombre", "ApellidoP", "ApellidoM", "Calle", "#", "Col", "Del", "CP", "TEL"};
        String[] registro = new String[10];
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);
        ConexionMysql mysql = new ConexionMysql();
        Connection cn = mysql.Conectar();
        try {

            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("SELECT IDCliente,Nombres,ApellidoPaterno,ApellidoMaterno,Calle,Numero,Colonia,Delegacion,CP,Telefono FROM cliente");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                registro[0] = res.getString("IDCliente");
                registro[1] = res.getString("Nombres");
                registro[2] = res.getString("ApellidoPaterno");
                registro[3] = res.getString("ApellidoMaterno");
                registro[4] = res.getString("Calle");
                registro[5] = res.getString("Numero");
                registro[6] = res.getString("Colonia");
                registro[7] = res.getString("Delegacion");
                registro[8] = res.getString("CP");
                registro[9] = res.getString("Telefono");

                modelo.addRow(registro);
            }
            tblDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    private void INHABILITAR() {
        textCALLE.setEnabled(false);
        textCOL.setEnabled(false);
        textCP.setEnabled(false);
        
        textMATERNO.setEnabled(false);
        textNOMBRES.setEnabled(false);
        textNUM.setEnabled(false);
        textPATERNO.setEnabled(false);
        textTEL.setEnabled(false);
        textDELG.setEnabled(false);
        
        
        textCALLE.setText("");
        textCOL.setText("");
        textCP.setText("");
        
        textMATERNO.setText("");
        textNOMBRES.setText("");
        textNUM.setText("");
        textPATERNO.setText("");
        textTEL.setText("");
        textDELG.setText("");

    }

}
