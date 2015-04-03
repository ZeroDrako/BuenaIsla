

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ZeroDrako
 */
public class Otros {
    
    public void Licencia() {
        String msj = "Liberado bajo la licencia:\nGNU General Public License v.3.0\n\nSe permite"
                + " la modificacion total o parcial \ndel codigo, extraccion de las funciones e"
                + " \nimplementacion del mismo en terceros.";
        JOptionPane.showMessageDialog(null, msj, "Licencia de Uso", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void AcercaDe() {
        String msj = "Buena Isla Dowloader\n\n"
                + "\nVersion: 2.3"
                + "\nCodigo Fuente:   ZeroDrako";
        JOptionPane.showMessageDialog(null, msj, "Acerca de...", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
