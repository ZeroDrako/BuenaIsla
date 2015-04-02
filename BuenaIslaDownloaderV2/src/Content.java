
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ZeroDrako
 */
public class Content implements Runnable {

    String url = "";
    JTextField nameDown;
    JTextArea areaurls;
    JProgressBar barra;

    @Override
    public void run() {
        String content;
        try {
            barra.setIndeterminate(true);
            content = GetHTML(url);
            GetImages(content);
            barra.setIndeterminate(false);
        } catch (IOException ex) {
            Logger.getLogger(Content.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Preparar(String turl, JTextArea tarea, JProgressBar barProgreso,
            JTextField named) {
        this.nameDown = named;
        this.areaurls = tarea;
        this.url = turl;
        this.barra = barProgreso;
    }

    public void GetImages(String all) {
        //File input = new File("tmp.html");
        Document doc = Jsoup.parse(all);
        Element content = doc.getElementById("contenido_post");
        Elements links = content.getElementsByTag("img");
        String images = "";
        for (Element link : links) {
            String linkHref = link.attr("src");
            if (linkHref.endsWith("fecha.png") | linkHref.endsWith("visitas.png")) {
            } else {
                if (linkHref.endsWith(".jpg") | linkHref.endsWith(".jpeg") | linkHref.endsWith(".png")) {
                    images += linkHref + "\n";
                }
            }

        }
        Elements content2 = doc.getElementsByClass("titulo");
        String tmp = content2.toString();
        
        Pattern patt1 = Pattern.compile("\"titulo\">.+<span");
        Matcher matc1 = patt1.matcher(tmp);
        Pattern patt2 = Pattern.compile("destacado\\s\">.+<span");
        Matcher matc2 = patt2.matcher(tmp);
        String name = "Sin Titulo";
        if (matc2.find()) {
            name = matc2.group(0);
            name = name.replace("destacado \"> ", "");
            name = name.replace(" <span", "");
        }else if (matc1.find()) {
            name = matc1.group(0);
            name = name.replace("\"titulo\"> ", "");
            name = name.replace(" <span", "");
        }
        this.nameDown.setText(name);
        this.areaurls.setText(images);
    }

    private static String GetHTML(String urlString)
            throws MalformedURLException, IOException {
        if (!urlString.contains("http://")) {
            urlString = "http://" + urlString;
        }
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.addRequestProperty("User-Agent", "Mozilla/4.76");
        InputStream is = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String content = "";
        String linea = br.readLine();
        while (null != linea) {
            content += linea;
            linea = br.readLine();
        }
        return content;
    }

}
