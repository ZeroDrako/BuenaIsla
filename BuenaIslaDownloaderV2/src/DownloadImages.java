
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class DownloadImages extends javax.swing.JFrame {

    Content cont = new Content();
    Downloader down = new Downloader();
    Directorio dire = new Directorio();

    public DownloadImages() {
        initComponents();
        tfRuta.setText(dire.DefaultDirectory());
        setLocationRelativeTo(null);
    }

    public void ObtenerClipBoard() {
        try {
            String url = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
            linkurl.setText(url);
        } catch (UnsupportedFlavorException | IOException ex) {
            Logger.getLogger(DownloadImages.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean VerificarURL(String tmp) {
        Pattern pattern = Pattern.compile("^(https?://)?[^/]+/([^/]+)/.*$");
        Matcher matcher = pattern.matcher(tmp);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMenu = new javax.swing.JPopupMenu();
        iPegar = new javax.swing.JMenuItem();
        iLimpiar = new javax.swing.JMenuItem();
        bDownload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaUrls = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        numImagesTotal = new javax.swing.JLabel();
        bReiniciar = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        barProgreso = new javax.swing.JProgressBar();
        bPegar = new javax.swing.JButton();
        bRuta = new javax.swing.JButton();
        tfRuta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numImagesListas = new javax.swing.JLabel();
        linkurl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nameDown = new javax.swing.JTextField();
        bReiniciar1 = new javax.swing.JButton();

        iPegar.setText("Pegar");
        iPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iPegarActionPerformed(evt);
            }
        });
        pMenu.add(iPegar);

        iLimpiar.setText("Limpiar");
        iLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iLimpiarActionPerformed(evt);
            }
        });
        pMenu.add(iLimpiar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Descargar Imagenes");

        bDownload.setText("Verificar");
        bDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDownloadActionPerformed(evt);
            }
        });

        areaUrls.setColumns(20);
        areaUrls.setRows(5);
        areaUrls.setComponentPopupMenu(pMenu);
        areaUrls.setFocusCycleRoot(true);
        jScrollPane1.setViewportView(areaUrls);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Total:");

        numImagesTotal.setText("00");

        bReiniciar.setText("Descargar");
        bReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReiniciarActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(48, 54, 60));
        title.setText("Donwloader");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoMini.png"))); // NOI18N

        bPegar.setText("Pegar");
        bPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPegarActionPerformed(evt);
            }
        });

        bRuta.setText("Ruta");
        bRuta.setFocusPainted(false);
        bRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRutaActionPerformed(evt);
            }
        });

        tfRuta.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Listo:");

        numImagesListas.setText("00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        bReiniciar1.setText("Limpiar");
        bReiniciar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReiniciar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameDown, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numImagesTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numImagesListas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(bReiniciar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bDownload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(barProgreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(title)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfRuta)
                            .addComponent(linkurl, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bPegar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRuta)
                    .addComponent(tfRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linkurl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPegar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bDownload)
                    .addComponent(jLabel4)
                    .addComponent(nameDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(numImagesTotal)
                        .addComponent(jLabel2)
                        .addComponent(numImagesListas))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bReiniciar)
                        .addComponent(bReiniciar1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDownloadActionPerformed
        if (VerificarURL(linkurl.getText())) {
            nameDown.setText(null);
            areaUrls.setText(null);
            numImagesTotal.setText("0");
            numImagesListas.setText("0");
            cont.Preparar(linkurl.getText(), areaUrls, barProgreso, nameDown);
            Thread thread1 = new Thread(cont);
            thread1.start();
        } else {
            String msj = "La URL es Incorrecta\nVerifica que pertenece a BuenaIsla";
            JOptionPane.showMessageDialog(null, msj, "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bDownloadActionPerformed

    private void bReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReiniciarActionPerformed
        down.Preparar(tfRuta.getText(), numImagesTotal, numImagesListas,
                areaUrls, barProgreso, nameDown.getText());
        Thread thread2 = new Thread(down);
        thread2.start();
    }//GEN-LAST:event_bReiniciarActionPerformed

    private void bRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRutaActionPerformed
        String dirDownloads = dire.ChangeDirectory(tfRuta.getText());
        tfRuta.setText(dirDownloads);
    }//GEN-LAST:event_bRutaActionPerformed

    private void bPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPegarActionPerformed
        ObtenerClipBoard();
    }//GEN-LAST:event_bPegarActionPerformed

    private void iPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iPegarActionPerformed
        ObtenerClipBoard();
    }//GEN-LAST:event_iPegarActionPerformed

    private void iLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iLimpiarActionPerformed
        areaUrls.setText(null);
    }//GEN-LAST:event_iLimpiarActionPerformed

    private void bReiniciar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReiniciar1ActionPerformed
        nameDown.setText(null);
        linkurl.setText(null);
        areaUrls.setText(null);
        numImagesTotal.setText("0");
        numImagesListas.setText("0");
        barProgreso.setValue(0);
        bDownload.setText("Verificar");
    }//GEN-LAST:event_bReiniciar1ActionPerformed

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
            java.util.logging.Logger.getLogger(DownloadImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DownloadImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DownloadImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DownloadImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DownloadImages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaUrls;
    private javax.swing.JButton bDownload;
    private javax.swing.JButton bPegar;
    private javax.swing.JButton bReiniciar;
    private javax.swing.JButton bReiniciar1;
    private javax.swing.JButton bRuta;
    private javax.swing.JProgressBar barProgreso;
    private javax.swing.JMenuItem iLimpiar;
    private javax.swing.JMenuItem iPegar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField linkurl;
    private javax.swing.JTextField nameDown;
    private javax.swing.JLabel numImagesListas;
    private javax.swing.JLabel numImagesTotal;
    private javax.swing.JPopupMenu pMenu;
    private javax.swing.JTextField tfRuta;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
