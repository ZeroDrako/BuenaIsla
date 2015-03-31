
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZeroDrako
 */
public class Downloader implements Runnable{
    
    JLabel numImagesTotal;
    JLabel numImagesListas;
    JLabel tamImages;
    JTextArea areaUrls;
    JProgressBar barProgreso;
    String rutaDescargas;
    int numImgDown = 1;
    double peso = 0;
    boolean ban = false;
    DecimalFormat formato = new DecimalFormat("#.00");
    
   @Override
    public void run() {
        String[] imagenes = Obtener();
        numImagesTotal.setText("" + (imagenes.length - 1));
        Proceso(imagenes);
    }
    
    
    public void Preparar(String rutaDescargas, JLabel numImagesTotal, JLabel numImagesListas,
            JLabel tamImages, JTextArea areaUrls, JProgressBar barProgreso) {
        this.rutaDescargas = rutaDescargas;
        this.numImagesTotal = numImagesTotal;
        this.numImagesListas = numImagesListas;
        this.tamImages = tamImages;
        this.areaUrls = areaUrls;
        this.barProgreso = barProgreso;
        numImgDown = 1;
    }

    public String[] Obtener() {
        String[] imagenes;
        String datos = areaUrls.getText();
        imagenes = datos.split("\n");
        return imagenes;
    }
    
    public double Redondeo(double este) {
        String myformato = formato.format(este);
        double value = Double.parseDouble(myformato);
        return value;
    }
    
    public void Proceso(String[] imagenes) {
        String aux = "";
        String name = imagenes[0].trim();
        rutaDescargas += File.separator + name; 
        for (int i = 1; i < imagenes.length; i++) {
            String format = Format(imagenes[i]);
            if (imagenes.length > 99) {
                if (i < 10) {
                    aux = "00" + i + "." + format;
                } else {
                    aux = "0" + i + "." + format;
                }
            } else {
                if (i < 10) {
                    aux = "0" + i + "." + format;
                } else {
                    aux = "" + i + "." + format;
                }
            }
            Download(imagenes[i], aux, rutaDescargas);
        }
        tamImages.setText(peso + " Mb");
    }

    public void Download(String fileURL, String fileName, String fileFolder) {
        OutputStream out = null;
        URLConnection conn = null;
        InputStream in = null;
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
            double numWritten = 0;
            while ((numRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, numRead);
                barProgreso.setValue(current);
                numWritten += numRead;
                current += numRead;
            }
            numImagesListas.setText(""+numImgDown);
            numImgDown++;
            barProgreso.setValue(length);
            peso += Redondeo((numWritten / 1024) / 1024);
            peso = Redondeo(peso);
        } catch (Exception exception) {
            exception.printStackTrace();
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
