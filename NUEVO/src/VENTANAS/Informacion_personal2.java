/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VENTANAS;

import BASE_DE_DATOS.ConexionMysql;
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
public class Informacion_personal2 extends javax.swing.JDialog {

    private DefaultTableModel modelo;

    /**
     * Creates new form Informacion_cliente
     */
    public Informacion_personal2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargartabla();
        HABILITAR();
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
        textTEL.setDocument(new LIMITARCARACTER(textTEL, 11));
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
    void Busqueda(String valor) {
        String[] titulos = {"ID", "Nombre", "ApellidoP", "ApellidoM", "Calle", "#", "Col", "Del", "CP", "Tel", "Cargo"};
        String[] registro = new String[10];
        String sSQL = "";
        modelo = new DefaultTableModel(null, titulos);

        ConexionMysql mysql = new ConexionMysql();
        com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) mysql.Conectar();

        sSQL = "SELECT IDEmpleado,Nombres,ApellidoPaterno,ApellidoMaterno,Calle,Numero,Colonia,Delegacion,CP,Telefono,Cargo FROM empleado "
                + "WHERE CONCAT(Nombres, ' ',ApellidoPaterno) LIKE '%" + valor + "%'";
        try {
            com.mysql.jdbc.Statement st = (com.mysql.jdbc.Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("IDEmpleado");
                registro[1] = rs.getString("Nombres");
                registro[2] = rs.getString("ApellidoPaterno");
                registro[3] = rs.getString("ApellidoMaterno");
                registro[4] = rs.getString("Calle");
                registro[5] = rs.getString("Numero");
                registro[6] = rs.getString("Colonia");
                registro[7] = rs.getString("Delegacion");
                registro[8] = rs.getString("CP");
                registro[9] = rs.getString("Telefono");
                registro[10] = rs.getString("Cargo");
                modelo.addRow(registro);
            }
            tblDatos.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    void cargartabla() {
        String[] titulos = {"ID", "Nombre", "ApellidoP", "ApellidoM", "Calle", "#", "Col", "Del", "CP", "TEL,CARGO"};
        String[] registro = new String[11];
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);
        ConexionMysql mysql = new ConexionMysql();
        Connection cn = mysql.Conectar();
        try {

            PreparedStatement pst = (PreparedStatement) cn.prepareStatement("SELECT IDEmpleado,Nombres,ApellidoPaterno,ApellidoMaterno,Calle,Numero,Colonia,Delegacion,CP,Telefono,Cargo FROM empleado");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                registro[0] = res.getString("IDEmpleado");
                registro[1] = res.getString("Nombres");
                registro[2] = res.getString("ApellidoPaterno");
                registro[3] = res.getString("ApellidoMaterno");
                registro[4] = res.getString("Calle");
                registro[5] = res.getString("Numero");
                registro[6] = res.getString("Colonia");
                registro[7] = res.getString("Delegacion");
                registro[8] = res.getString("CP");
                registro[9] = res.getString("Telefono");
                registro[10] = res.getString("Cargo");

                modelo.addRow(registro);
            }
            tblDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        btnCANCELAR = new javax.swing.JButton();
        btnELIMINAR = new javax.swing.JButton();
        btnMODIFICAR = new javax.swing.JButton();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
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
        btnGUARDAR = new javax.swing.JButton();
        textELIMINAR = new org.edisoncor.gui.textField.TextField();
        btnNUEVO = new javax.swing.JButton();
        btnCERRAR = new javax.swing.JButton();
        textCARGO = new org.edisoncor.gui.textField.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(50, 119, 255));
        panel1.setColorSecundario(new java.awt.Color(200, 216, 252));

        btnCANCELAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/CANCELAR-NORM.png"))); // NOI18N
        btnCANCELAR.setBorder(null);
        btnCANCELAR.setBorderPainted(false);
        btnCANCELAR.setContentAreaFilled(false);
        btnCANCELAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        btnELIMINAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/BOTONES/ELIMINAR-NORM.png"))); // NOI18N
        btnELIMINAR.setBorder(null);
        btnELIMINAR.setBorderPainted(false);
        btnELIMINAR.setContentAreaFilled(false);
        btnELIMINAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnELIMINAR.setDefaultCapable(false);
        btnELIMINAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnELIMINAR.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/BOTONES/ELIMINAR-PRESS.png"))); // NOI18N
        btnELIMINAR.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/BOTONES/ELIMINAR-ROLL.png"))); // NOI18N
        btnELIMINAR.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnELIMINAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnELIMINARActionPerformed(evt);
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

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/LETRERO-PERSONAL.png"))); // NOI18N

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

        textNOMBRES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNOMBRESActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(200, 216, 252));
        jLabel14.setText(org.openide.util.NbBundle.getMessage(Informacion_personal2.class, "MODCLI.jLabel14.text")); // NOI18N

        textPATERNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPATERNOActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(200, 216, 252));
        jLabel12.setText(org.openide.util.NbBundle.getMessage(Informacion_personal2.class, "MODCLI.jLabel12.text")); // NOI18N

        textMATERNO.setText(org.openide.util.NbBundle.getMessage(Informacion_personal2.class, "MODCLI.textMATERNO.text")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(200, 216, 252));
        jLabel6.setText(org.openide.util.NbBundle.getMessage(Informacion_personal2.class, "MODCLI.jLabel6.text")); // NOI18N

        textCALLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCALLEActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(200, 216, 252));
        jLabel15.setText(org.openide.util.NbBundle.getMessage(Informacion_personal2.class, "MODCLI.jLabel15.text")); // NOI18N

        textNUM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNUMActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(200, 216, 252));
        jLabel16.setText(org.openide.util.NbBundle.getMessage(Informacion_personal2.class, "MODCLI.jLabel16.text")); // NOI18N

        textCOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCOLActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(200, 216, 252));
        jLabel11.setText(org.openide.util.NbBundle.getMessage(Informacion_personal2.class, "MODCLI.jLabel11.text")); // NOI18N

        textDELG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDELGActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(200, 216, 252));
        jLabel17.setText(org.openide.util.NbBundle.getMessage(Informacion_personal2.class, "MODCLI.jLabel17.text")); // NOI18N

        textCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCPActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(200, 216, 252));
        jLabel5.setText(org.openide.util.NbBundle.getMessage(Informacion_personal2.class, "MODCLI.jLabel5.text")); // NOI18N

        textTEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTELActionPerformed(evt);
            }
        });

        btnGUARDAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/GUARDAR-NORM.png"))); // NOI18N
        btnGUARDAR.setBorder(null);
        btnGUARDAR.setBorderPainted(false);
        btnGUARDAR.setContentAreaFilled(false);
        btnGUARDAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGUARDAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGUARDAR.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/GUARDAR-PRESS.png"))); // NOI18N
        btnGUARDAR.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/GUARDAR-ROLL.png"))); // NOI18N
        btnGUARDAR.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnGUARDAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGUARDARActionPerformed(evt);
            }
        });

        textELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textELIMINARActionPerformed(evt);
            }
        });

        btnNUEVO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/NUEVO-NORM.png"))); // NOI18N
        btnNUEVO.setBorder(null);
        btnNUEVO.setBorderPainted(false);
        btnNUEVO.setContentAreaFilled(false);
        btnNUEVO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNUEVO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNUEVO.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/NUEVO-PRESS.png"))); // NOI18N
        btnNUEVO.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES_REDISEÑO/NUEVO-ROLL.png"))); // NOI18N
        btnNUEVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNUEVOActionPerformed(evt);
            }
        });

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

        textCARGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCARGOActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(200, 216, 252));
        jLabel1.setText("Cargo");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(200, 216, 252));
        jLabel3.setText(" Nombre(S)");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(40, 40, 255));
        jLabel8.setText("Ingresa el ID del Registro a Eliminar");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(40, 40, 255));
        jLabel9.setText("Para Modificar y Buscar haga click en el este boton");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textDELG, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(textCALLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textCARGO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textNOMBRES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(60, 60, 60)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textNUM, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                            .addComponent(textPATERNO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(60, 60, 60)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel16)))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(textCP, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textMATERNO, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(textCOL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textTEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(btnNUEVO)
                                .addGap(100, 100, 100)
                                .addComponent(btnGUARDAR)
                                .addGap(100, 100, 100)
                                .addComponent(btnCANCELAR)))))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(212, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGap(36, 36, 36)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnELIMINAR)
                    .addComponent(btnMODIFICAR))
                .addGap(313, 313, 313)
                .addComponent(btnCERRAR)
                .addGap(30, 30, 30))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNOMBRES, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(textPATERNO, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textMATERNO, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12))
                        .addGap(25, 25, 25)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textCARGO, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textCALLE, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textNUM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16)
                                .addComponent(textCOL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textDELG, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(textCP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel5)
                            .addComponent(textTEL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(btnNUEVO)
                                .addGap(2, 2, 2))
                            .addComponent(btnGUARDAR, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCANCELAR, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(224, 224, 224))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel9)
                        .addGap(21, 21, 21))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnELIMINAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(btnMODIFICAR)
                                .addGap(12, 12, 12))
                            .addComponent(btnCERRAR, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCANCELARActionPerformed
        INHABILITAR();
    }//GEN-LAST:event_btnCANCELARActionPerformed

    private void btnELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnELIMINARActionPerformed
        String valor =textELIMINAR.getText();
        String sql = "DELETE FROM empleado WHERE IDEmpleado =("+valor+")" ; 
        ConexionMysql mysql = new ConexionMysql();
        Connection coneccion = (Connection) mysql.Conectar();
        try {
            Statement instruccion  = (Statement) coneccion.createStatement();
           boolean borrado = instruccion.execute(sql);
          
           if(borrado=true) {
              JOptionPane.showMessageDialog(null,"Se Ha Eliminado Exitosamente");
                }
           else {
               JOptionPane.showMessageDialog(null,"El ID Ingresado no Existe");
                 }
            }
        catch (SQLException ex){
        }     
        cargartabla();
    }//GEN-LAST:event_btnELIMINARActionPerformed

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

    private void btnGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGUARDARActionPerformed
        ConexionMysql mysql = new ConexionMysql();
        Connection cn = mysql.Conectar();
        
        String nombres = textNOMBRES.getText();
        String paterno = textPATERNO.getText();
        String materno = textMATERNO.getText();
        String calle = textCALLE.getText();
        String numero = textNUM.getText();
        String colonia = textCOL.getText();
        String delegacion = textDELG.getText();
        String cp = textCP.getText();
        String telefono = textTEL.getText();
        String cargo = textCARGO.getText();
        try {
            PreparedStatement pstm = cn.prepareStatement("insert into empleado(Nombres,ApellidoPaterno,ApellidoMaterno,Calle,Numero,Colonia,Delegacion,CP,Telefono,Cargo) VALUES (?,?,?,?,?,?,?,?,?,?)");
            
            pstm.setString(1, textNOMBRES.getText());
            pstm.setString(2, textPATERNO.getText());
            pstm.setString(3, textMATERNO.getText());
            pstm.setString(4, textCALLE.getText());
            pstm.setString(5, textNUM.getText());
            pstm.setString(6, textCOL.getText());
            pstm.setString(7, textDELG.getText());
            pstm.setString(8, textCP.getText());
            pstm.setString(9, textTEL.getText());
            pstm.setString(10, textCARGO.getText());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Los Datos han sido guardados");
            textCALLE.setText("");
            textCOL.setText("");
            textCP.setText("");
            textELIMINAR.setText("");
            textCARGO.setText("");
            textMATERNO.setText("");
            textNOMBRES.setText("");
            textNUM.setText("");
            textPATERNO.setText("");
            textTEL.setText("");
            textDELG.setText("");

            cargartabla();

        } catch (SQLException e) {
            System.out.print(e.getMessage());

        }
        INHABILITAR();


    }//GEN-LAST:event_btnGUARDARActionPerformed

    private void btnMODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMODIFICARActionPerformed
        cerrar();
        MODPER dialog = new MODPER(new javax.swing.JFrame(), true);
        dialog.setTitle("MODIFICAR DATOS");
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_btnMODIFICARActionPerformed

    private void btnNUEVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNUEVOActionPerformed
        HABILITAR();
    }//GEN-LAST:event_btnNUEVOActionPerformed

    private void btnCERRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCERRARActionPerformed
        cerrar();
        Menu m = new Menu();
        m.setTitle("PERSONAL");
        m.setLocationRelativeTo(null);
        m.setVisible(true);
    }

    private void cerrar() {
        this.setVisible(false);
    }//GEN-LAST:event_btnCERRARActionPerformed

    private void textCARGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCARGOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCARGOActionPerformed

    private void textELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textELIMINARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textELIMINARActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_personal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_personal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_personal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_personal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Informacion_personal2 dialog = new Informacion_personal2(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCANCELAR;
    private javax.swing.JButton btnCERRAR;
    private javax.swing.JButton btnELIMINAR;
    private javax.swing.JButton btnGUARDAR;
    private javax.swing.JButton btnMODIFICAR;
    private javax.swing.JButton btnNUEVO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JTable tblDatos;
    private org.edisoncor.gui.textField.TextField textCALLE;
    private org.edisoncor.gui.textField.TextField textCARGO;
    private org.edisoncor.gui.textField.TextField textCOL;
    private org.edisoncor.gui.textField.TextField textCP;
    private org.edisoncor.gui.textField.TextField textDELG;
    private org.edisoncor.gui.textField.TextField textELIMINAR;
    private org.edisoncor.gui.textField.TextField textMATERNO;
    private org.edisoncor.gui.textField.TextField textNOMBRES;
    private org.edisoncor.gui.textField.TextField textNUM;
    private org.edisoncor.gui.textField.TextField textPATERNO;
    private org.edisoncor.gui.textField.TextField textTEL;
    // End of variables declaration//GEN-END:variables

    

    private void HABILITAR() {
        textCALLE.setEnabled(true);
        textCOL.setEnabled(true);
        textCP.setEnabled(true);
        textELIMINAR.setEnabled(true);
        textCARGO.setEnabled(true);
        textMATERNO.setEnabled(true);
        textNOMBRES.setEnabled(true);
        textNUM.setEnabled(true);
        textPATERNO.setEnabled(true);
        textTEL.setEnabled(true);
        textDELG.setEnabled(true);
        btnNUEVO.setEnabled(false);
        btnGUARDAR.setEnabled(true);
        btnCANCELAR.setEnabled(true);
        textCALLE.setText("");
        textCOL.setText("");
        textCP.setText("");
        textELIMINAR.setText("");
        textCARGO.setText("");
        textMATERNO.setText("");
        textNOMBRES.setText("");
        textNUM.setText("");
        textPATERNO.setText("");
        textTEL.setText("");
        textDELG.setText("");
    }

    private void INHABILITAR() {
         textCALLE.setEnabled(false);
        textCOL.setEnabled(false);
        textCP.setEnabled(false);
        
        textCARGO.setEnabled(false);
        textMATERNO.setEnabled(false);
        textNOMBRES.setEnabled(false);
        textNUM.setEnabled(false);
        textPATERNO.setEnabled(false);
        textTEL.setEnabled(false);
        textDELG.setEnabled(false);
        btnNUEVO.setEnabled(true);
        btnGUARDAR.setEnabled(false);
        btnCANCELAR.setEnabled(false);
        textCALLE.setText("");
        textCOL.setText("");
        textCP.setText("");
        textCARGO.setText("");
        textELIMINAR.setText("");
        
        textMATERNO.setText("");
        textNOMBRES.setText("");
        textNUM.setText("");
        textPATERNO.setText("");
        textTEL.setText("");
        textDELG.setText("");
    }

    
}
