package green.projectile;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ProjectileFrame extends JFrame {
    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel xLabel = new JLabel("X");
        JLabel yLabel = new JLabel("Y");
        JLabel blankLabel = new JLabel("");
        JLabel peakYLabel = new JLabel("Peak Y:");
        JLabel interceptXLabel = new JLabel("X Intercept:");

        JTextField velocityField = new JTextField();
        JTextField secondsField = new JTextField();
        JTextField xField = new JTextField();
        JTextField yField = new JTextField();
        JTextField peakYField = new JTextField();
        JTextField interceptXField = new JTextField();

        JButton calculate = new JButton("Calculate");

        JSlider angleSlider = new JSlider(0, 90);
        angleSlider.setPaintTicks(true);
        angleSlider.setMajorTickSpacing(15);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintLabels(true);

        setLayout(new GridLayout(8,2));

        add(velocityLabel);
        add(velocityField);

        add(angleLabel);
        add(angleSlider);

        add(secondsLabel);
        add(secondsField);

        add(xLabel);
        add(xField);

        add(yLabel);
        add(yField);

        add(peakYLabel);
        add(peakYField);

        add(interceptXLabel);
        add(interceptXField);

        add(blankLabel);
        add(calculate);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFields(angleSlider, velocityField, secondsField, xField,
                        yField, peakYField, interceptXField );

            }
        });



        DocumentListener docListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFields(angleSlider, velocityField, secondsField, xField,
                        yField, peakYField, interceptXField );
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        };

        ChangeListener changeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateFields(angleSlider, velocityField, secondsField, xField,
                             yField, peakYField, interceptXField );
            }
        };

        velocityField.getDocument().addDocumentListener(docListener);
        secondsField.getDocument().addDocumentListener(docListener);
        angleSlider.addChangeListener(changeListener);



    }

    private void updateFields(JSlider angleSlider, JTextField velocityField, JTextField secondsField,
                              JTextField xField, JTextField yField, JTextField peakYField, JTextField interceptXField) {
        Projectile projectile = new Projectile(
                angleSlider.getValue(),
                Double.parseDouble(velocityField.getText())
        );

        projectile.setSeconds(Double.parseDouble(secondsField.getText()));
        xField.setText(Double.toString(projectile.getX()));
        yField.setText(Double.toString(projectile.getY()));
        peakYField.setText(Double.toString(projectile.getPeakY()));
        interceptXField.setText(Double.toString(projectile.getInterceptX()));
    }


}
