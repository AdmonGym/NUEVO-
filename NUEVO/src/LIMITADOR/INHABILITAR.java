
package LIMITADOR;

import javax.swing.text.PlainDocument;

public class INHABILITAR extends PlainDocument {

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

    public INHABILITAR() {
        textCALLE.setEnabled(false);
        textCOL.setEnabled(false);
        textCP.setEnabled(false);
        textELIMINAR.setEnabled(false);
        textID.setEnabled(false);
        textMATERNO.setEnabled(false);
        textNOMBRES.setEnabled(false);
        textNUM.setEnabled(false);
        textPATERNO.setEnabled(false);
        textTEL.setEnabled(false);
        textDELG.setEnabled(false);
    }
}