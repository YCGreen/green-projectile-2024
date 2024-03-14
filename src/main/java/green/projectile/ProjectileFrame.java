package green.projectile;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;


public class ProjectileFrame extends JFrame {
    ProjectileGraph graph = new ProjectileGraph();
    public ProjectileFrame() {
        setSize(800, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        west.setLayout(new GridLayout(10,2));

        JLabel velocityLabel = new JLabel("Velocity");
        JLabel velocityAnsLabel = new JLabel();
        JLabel angleLabel = new JLabel("Angle");
        JLabel angleAnsLabel = new JLabel();
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel xLabel = new JLabel("X");
        JLabel yLabel = new JLabel("Y");
        JLabel blankLabel = new JLabel("");
        JLabel peakYLabel = new JLabel("Peak Y:");
        JLabel peakYAnsLabel = new JLabel();
        JLabel interceptXLabel = new JLabel("X Intercept:");
        JLabel interceptXAnsLabel = new JLabel();
        JLabel emptyField1 = new JLabel("");
        JLabel emptyField2 = new JLabel("");

        JTextField secondsField = new JTextField("2.7");
        JTextField xField = new JTextField();
        JTextField yField = new JTextField();

        JSlider velocitySlider = new JSlider(0, 100);
        velocitySlider.setPaintTicks(true);
        velocitySlider.setMajorTickSpacing(15);
        velocitySlider.setMinorTickSpacing(5);
        velocitySlider.setPaintLabels(true);
        velocitySlider.setValue(65);

        JSlider angleSlider = new JSlider(0, 90);
        angleSlider.setPaintTicks(true);
        angleSlider.setMajorTickSpacing(15);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintLabels(true);
        angleSlider.setValue(31);

        west.add(velocityLabel);
        west.add(velocitySlider);
        west.add(emptyField1);
        west.add(velocityAnsLabel);

        west.add(angleLabel);
        west.add(angleSlider);
        west.add(emptyField2);
        west.add(angleAnsLabel);

        west.add(secondsLabel);
        west.add(secondsField);

        west.add(xLabel);
        west.add(xField);

        west.add(yLabel);
        west.add(yField);

        west.add(peakYLabel);
        west.add(peakYAnsLabel);

        west.add(interceptXLabel);
        west.add(interceptXAnsLabel);

        west.add(blankLabel);

        updateFields(angleSlider, angleAnsLabel, velocitySlider, velocityAnsLabel, secondsField, xField,
                yField, peakYAnsLabel, interceptXAnsLabel );

        DocumentListener docListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFields(angleSlider, angleAnsLabel, velocitySlider, velocityAnsLabel, secondsField, xField,
                        yField, peakYAnsLabel, interceptXAnsLabel );
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        };

        ChangeListener changeListener = e -> updateFields(angleSlider, angleAnsLabel, velocitySlider, velocityAnsLabel, secondsField, xField,
                     yField, peakYAnsLabel, interceptXAnsLabel );

        velocitySlider.addChangeListener(changeListener);//.addDocumentListener(docListener);
        secondsField.getDocument().addDocumentListener(docListener);
        angleSlider.addChangeListener(changeListener);


        main.add(graph, BorderLayout.CENTER);

    }

    private void updateFields(JSlider angleSlider, JLabel angleAnsLabel, JSlider velocitySlider, JLabel velocityAnsLabel, JTextField secondsField,
                              JTextField xField, JTextField yField, JLabel peakYAnsLabel, JLabel interceptXAnsLabel) {
        Projectile projectile = new Projectile(
                angleSlider.getValue(),
                velocitySlider.getValue()
        );

        double seconds = Double.parseDouble(secondsField.getText());
        projectile.setSeconds(seconds);
        angleAnsLabel.setText(Double.toString(angleSlider.getValue()));
        velocityAnsLabel.setText(Double.toString(velocitySlider.getValue()));
        xField.setText(Double.toString(projectile.getX()));
        yField.setText(Double.toString(projectile.getY()));
        peakYAnsLabel.setText(Double.toString(projectile.getPeakY()));
        interceptXAnsLabel.setText(Double.toString(projectile.getInterceptX()));

        graph.setProjectile(projectile);

    }


}
