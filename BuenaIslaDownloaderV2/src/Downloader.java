
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ZeroDrako
 */
public class Downloader implements Runnable {

    Util util = new Util();
    
    JLabel numImagesListas;
    String nameDown, rutaDescargas;
    JTable tabImgs;
    JProgressBar barProgreso;
    int numImgDown = 1;
    Object[][] info = null;
    JButton  bVerificar,bDescargar;

    @Override
    public void run() {
        this.info = util.Contenido(tabImgs);
        Proceso(info);
    }

    public void Preparar(String rutaDescargas, JLabel numImagesListas,
            JTable tabla, JProgressBar barProgreso, String named, JButton bVe, JButton bDes) {
        this.rutaDescargas = rutaDescargas;
        this.numImagesListas = numImagesListas;
        this.tabImgs = tabla;
        this.barProgreso = barProgreso;
        this.nameDown = named;
        this.bVerificar = bVe;
        this.bDescargar = bDes;
        numImgDown = 1;
    }

    public void Proceso(Object[][] info) {
        String fileName;
        rutaDescargas += File.separator + nameDown;
        for (int i = 0; i < info.length; i++) {
            String urlImage = info[i][0].toString();
            String format = Format(urlImage);
            if (info.length > 99) {
                if (i < 10) {
                    fileName = "00" + i + "." + format;
                } else {
                    fileName = "0" + i + "." + format;
                }
            } else {
                if (i < 10) {
                    fileName = "0" + i + "." + format;
                } else {
                    fileName = "" + i + "." + format;
                }
            }
            Download(urlImage, fileName, rutaDescargas, i);
        }
        bVerificar.setEnabled(true);
        bDescargar.setEnabled(false);
    }

    public void Download(String fileURL, String fileName, String fileFolder, int row) {
        OutputStream out = null;
        URLConnection conn;
        InputStream in = null;
        File comp = new File(fileFolder + File.separator + fileName);
        if (comp.exists()) {
            tabImgs.setValueAt("Omitido", row, 1);
        } else {
            try {
                new File(fileFolder).mkdir();
                URL url = new URL(fileURL);
                out = new BufferedOutputStream(new FileOutputStream(fileFolder + File.separator + fileName));
                conn = url.openConnection();
                in = conn.getInputStream();
                int length = conn.getContentLength();
                byte[] buffer = new byte[1024];
                int numRead;
                int current = 0;
                barProgreso.setMinimum(0);
                barProgreso.setMaximum(length);
                while ((numRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, numRead);
                    barProgreso.setValue(current);
                    current += numRead;
                }
                numImagesListas.setText("" + numImgDown);
                numImgDown++;
                barProgreso.setValue(length);
                tabImgs.setValueAt("Descargado", row, 1);
            } catch (Exception e) {
                tabImgs.setValueAt("Error", row, 1);
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException ioe) {
                }
            }
        }
    }

    public String Format(String address) {
        int lastSlashIndex = address.lastIndexOf('.');
        if (lastSlashIndex >= 0 && lastSlashIndex < address.length() - 1) {
            return address.substring(lastSlashIndex + 1);
        } else {
            System.err.println("Could not figure out local file name for " + address);
            return null;
        }
    }
}
