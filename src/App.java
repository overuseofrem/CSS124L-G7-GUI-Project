
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class App extends javax.swing.JFrame implements MouseMotionListener {

    /** Creates new form App */
    public App() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menu_Edit = new javax.swing.JMenu();
        mItem_Timer = new javax.swing.JMenu();
        mItem_Timer1 = new javax.swing.JMenuItem();
        mItem_Timer2 = new javax.swing.JMenuItem();
        mItem_Timer3 = new javax.swing.JMenuItem();
        mItem_Image = new javax.swing.JMenuItem();
        menu_About = new javax.swing.JMenu();
        mItem_Version = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Screensaver");
        setResizable(false);

        menu_Edit.setText("Edit");

        mItem_Timer.setText("Edit timer");

        mItem_Timer1.setText("Set timer to 5 seconds");
        mItem_Timer.add(mItem_Timer1);

        mItem_Timer2.setText("Set timer to 10 seconds");
        mItem_Timer.add(mItem_Timer2);

        mItem_Timer3.setText("Set timer to 15 seconds");
        mItem_Timer.add(mItem_Timer3);

        menu_Edit.add(mItem_Timer);

        mItem_Image.setText("Edit image");
        mItem_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItem_ImageActionPerformed(evt);
            }
        });
        menu_Edit.add(mItem_Image);

        jMenuBar1.add(menu_Edit);

        menu_About.setText("About");

        mItem_Version.setText("App version");
        mItem_Version.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItem_VersionActionPerformed(evt);
            }
        });
        menu_About.add(mItem_Version);

        jMenuBar1.add(menu_About);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1153, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 723, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Change background image
    private void mItem_ImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItem_ImageActionPerformed
        
        // open jfilechooser
        JFileChooser fileChooser = new JFileChooser();
        
        // only approve images
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);
        
        int sel_Image = fileChooser.showOpenDialog(null);
        
        // select image
        if (sel_Image == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile() ;
                // apply image
                BufferedImage originalImage = ImageIO.read(selectedFile);
                int width = getWidth();
                int height = getHeight();
                int x = (originalImage.getWidth() - width) / 2;
                int y = (originalImage.getHeight() - height) / 2;
                BufferedImage croppedImage = originalImage.getSubimage(x, y, width, height);
                ImageIcon icon = new ImageIcon(croppedImage);
                JLabel background = new JLabel(icon);
                setContentPane(background);
                revalidate();
                repaint();
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_mItem_ImageActionPerformed

    // about menu
    private void mItem_VersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItem_VersionActionPerformed
        
        JOptionPane.showMessageDialog(null, "Screensaver v1049304.01");
        
    }//GEN-LAST:event_mItem_VersionActionPerformed

    // check mouse
    
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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mItem_Image;
    private javax.swing.JMenu mItem_Timer;
    private javax.swing.JMenuItem mItem_Timer1;
    private javax.swing.JMenuItem mItem_Timer2;
    private javax.swing.JMenuItem mItem_Timer3;
    private javax.swing.JMenuItem mItem_Version;
    private javax.swing.JMenu menu_About;
    private javax.swing.JMenu menu_Edit;
    // End of variables declaration//GEN-END:variables

    // mouse events
    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // reset timer if mouse is moved!
    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
