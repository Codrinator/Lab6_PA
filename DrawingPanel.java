import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import static java.awt.Color.YELLOW;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }
    private void drawShape(int x, int y) {
        String newColor = new String((String) frame.configPanel.colorCombo.getSelectedItem());
        if (newColor.equals("Random Color")) {
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            int radius = rand.nextInt() % 100;
            int sides = (int) frame.configPanel.sidesField.getValue();
            Color color = new Color(r, g, b);
            color.brighter();
            graphics.setColor(color);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        }
        else if(newColor.equals("Red")) {
            Random rand = new Random();
            int radius = rand.nextInt() % 100;
            int sides = (int) frame.configPanel.sidesField.getValue();
            Color color = new Color(253,63,63);
            color.brighter();
            graphics.setColor(color);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        }
        else if(newColor.equals("Yellow")) {
            Random rand = new Random();
            int radius = rand.nextInt() % 100;
            int sides = (int) frame.configPanel.sidesField.getValue();
            Color color = new Color(255,255,0);
            color.brighter();
            graphics.setColor(color);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        }
        else if(newColor.equals("Black")) {
            Random rand = new Random();
            int radius = rand.nextInt() % 100;
            int sides = (int) frame.configPanel.sidesField.getValue();
            Color color = new Color(0,0,0);
            color.brighter();
            graphics.setColor(color);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        }
    }
    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}