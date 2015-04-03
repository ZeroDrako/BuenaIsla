
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ZeroDrako
 */
public class Util {
    
    public void ObtenerClipBoard(JTextField tLink) {
        try {
            String url = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
            tLink.setText(url);
        } catch (UnsupportedFlavorException | IOException ex) {
            Logger.getLogger(DownloadImages.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean VerificarURL(String tmp) {
        Pattern pattern = Pattern.compile("^(https?://)?[^/]+/([^/]+)/.*$");
        Matcher matcher = pattern.matcher(tmp);
        return matcher.find();
    }

    public void Vaciar(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int aux = modelo.getRowCount();
        for (int i = 0; aux > i; i++) {
            try {
                modelo.removeRow(0);
            } catch (Exception e) {
            }
        }
    }

    public void Eliminar(int row, JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        try {
            modelo.removeRow(row);
        } catch (Exception e) {
            System.out.println("No se elimino "+row+" debido a: "+e.getMessage());
        }
    }

    public Object[][] Contenido(JTable tabla) {
        int row = tabla.getRowCount();
        Object[][] info = new Object[row][2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 2; j++) {
                info[i][j] = tabla.getValueAt(i, j);
            }
        }
        return info;
    }

}
