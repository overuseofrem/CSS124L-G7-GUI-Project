
// imports
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ScreenSaver extends JFrame implements MouseListener {
    private JLabel label;
    private Timer timer;

    public ScreenSaver() {
        super("Screen Saver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        label = new JLabel();
        add(label, BorderLayout.CENTER);

        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setVisible(true);
            }
        });
        timer.setRepeats(false);

        addMouseListener(this);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);
        
        JMenu aboutMenu = new JMenu("About");
        menuBar.add(aboutMenu);
        
        JMenuItem aboutAppItem = new JMenuItem("About the app");
        aboutAppItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Screen Saver v1049304.01");
            }
        });

        JMenuItem editImageItem = new JMenuItem("Edit Image");
        editImageItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
                fileChooser.setFileFilter(filter);

                int sel_Image = fileChooser.showOpenDialog(null);
                if (sel_Image == JFileChooser.APPROVE_OPTION) {
                    try {
                        File selectedFile = fileChooser.getSelectedFile() ;
                        BufferedImage originalImage = ImageIO.read(selectedFile);
                        int width = getWidth();
                        int height = getHeight();
                        int x = (originalImage.getWidth() - width) / 2;
                        int y = (originalImage.getHeight() - height) / 2;
                        BufferedImage croppedImage = originalImage.getSubimage(x, y, width, height);
                        ImageIcon icon = new ImageIcon(croppedImage);
                        label = new JLabel(icon);
                        setContentPane(label);
                        revalidate();
                        repaint();  
                        label.setVisible(false);
                    } catch (IOException ex) {
                        Logger.getLogger(ScreenSaver.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }  
            }
        });
        editMenu.add(editImageItem);

        JMenu editTimeItem = new JMenu("Edit Time");
        editMenu.add(editTimeItem);

        JMenuItem fiveSecondsItem = new JMenuItem("5 Seconds");
        fiveSecondsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer = new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        label.setVisible(true);
                    }
                });
                timer.setRepeats(false);
            }
        });
        editTimeItem.add(fiveSecondsItem);

        JMenuItem tenSecondsItem = new JMenuItem("10 Seconds");
        tenSecondsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer = new Timer(10000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        label.setVisible(true);
                    }
                });
                timer.setRepeats(false);
            }
        });
        editTimeItem.add(tenSecondsItem);

        JMenuItem fifteenSecondsItem = new JMenuItem("15 Seconds");
        fifteenSecondsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer = new Timer(15000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        label.setVisible(true);
                    }
                });
                timer.setRepeats(false);
            }
        });
        editTimeItem.add(fifteenSecondsItem);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        label.setVisible(false);
        timer.restart();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {} // not used

    @Override
    public void mouseReleased(MouseEvent e) {} // not used

    @Override
    public void mouseEntered(MouseEvent e) {} // not used

    @Override
    public void mouseExited(MouseEvent e) {} // not used

    public static void main(String[] args) {
        ScreenSaver screenSaver = new ScreenSaver();
        screenSaver.setVisible(true);
    }

}
