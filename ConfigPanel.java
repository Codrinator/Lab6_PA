import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JComboBox colorCombo;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 10, 1));
        sidesField.setValue(6);
        String[] culori = {"Red","Black","Yellow","Random Color"};
        colorCombo = new JComboBox(culori);
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
}