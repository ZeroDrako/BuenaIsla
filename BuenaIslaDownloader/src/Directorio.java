
import java.io.File;
import java.nio.file.Paths;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ZeroDrako
 */
public class Directorio {

    public String DefaultDirectory() {
        java.nio.file.Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        return s;
    }

    public String ChangeDirectory(String root) {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(root));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int ok = fc.showOpenDialog(fc);
        if (ok == JFileChooser.APPROVE_OPTION) {
            File archivoElegido = fc.getSelectedFile();
            return archivoElegido.getAbsolutePath();
        } else {
            return root;
        }
    }

}
