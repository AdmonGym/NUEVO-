/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIMITADOR;

import javax.swing.text.PlainDocument;

public class HABILITAR extends PlainDocument {

    private org.edisoncor.gui.textField.TextField textCALLE;
    private org.edisoncor.gui.textField.TextField textCOL;
    private org.edisoncor.gui.textField.TextField textCP;
    private org.edisoncor.gui.textField.TextField textDELG;
    private org.edisoncor.gui.textField.TextField textELIMINAR;
    private org.edisoncor.gui.textField.TextField textID;
    private org.edisoncor.gui.textField.TextField textMATERNO;
    private org.edisoncor.gui.textField.TextField textNOMBRES;
    private org.edisoncor.gui.textField.TextField textNUM;
    private org.edisoncor.gui.textField.TextField textPATERNO;
    private org.edisoncor.gui.textField.TextField textTEL;

    public HABILITAR() {
        textCALLE.setEnabled(true);
        textCOL.setEnabled(true);
        textCP.setEnabled(true);
        textELIMINAR.setEnabled(true);
        textID.setEnabled(true);
        textMATERNO.setEnabled(true);
        textNOMBRES.setEnabled(true);
        textNUM.setEnabled(true);
        textPATERNO.setEnabled(true);
        textTEL.setEnabled(true);
        textDELG.setEnabled(true);
        
    }
}
