import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton rstBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(rstBtn);
        add(exitBtn);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        rstBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("/home/codrin/Documents/JavaSeminar/output2.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void load(ActionEvent e) {
     try {
         File file = new File("/home/codrin/Documents/JavaSeminar/output2.png");
         frame.canvas.image=ImageIO.read(file);
         frame.canvas.graphics = frame.canvas.image.createGraphics();
       /*  Robot bot = new Robot();
         bot.mouseMove(800,600);
         bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
         bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);*/ //aici practic am facut un bot care da click pe ecran ca sa faca update
         //puteam sa mai adaug cumva o functie care aduce cursorul inapoi, se observa ca | cursorul se va muta la marginea ferestrei :)) sorry
     } catch (IOException ex) /*| /*AWTException ex*/ { System.err.println(ex); }
 }
    private void reset(ActionEvent e) {
        try {

            frame.canvas.graphics.setColor(Color.PINK);
            frame.canvas.graphics.fillRect(0, 0, W, H);
          /*  Robot bot = new Robot();
            bot.mouseMove(800,600);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);*/
        }
        catch (Exception ex) { System.err.println(ex); }
    }
    private void exit(ActionEvent e) {
        try {
            System.exit(0);
        }
        catch (Exception ex) { System.err.println(ex); }
    }
}