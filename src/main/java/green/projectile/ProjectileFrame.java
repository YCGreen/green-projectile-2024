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

        west.setLayout(new GridLayout(8,2));

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

        JSlider angleSlider = new JSlider(0, 90);
        angleSlider.setPaintTicks(true);
        angleSlider.setMajorTickSpacing(15);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintLabels(true);

        west.add(velocityLabel);
        west.add(velocityField);

        west.add(angleLabel);
        west.add(angleSlider);

        west.add(secondsLabel);
        west.add(secondsField);

        west.add(xLabel);
        west.add(xField);

        west.add(yLabel);
        west.add(yField);

        west.add(peakYLabel);
        west.add(peakYField);

        west.add(interceptXLabel);
        west.add(interceptXField);

        west.add(blankLabel);

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

        ChangeListener changeListener = e -> updateFields(angleSlider, velocityField, secondsField, xField,
                     yField, peakYField, interceptXField );

        velocityField.getDocument().addDocumentListener(docListener);
        secondsField.getDocument().addDocumentListener(docListener);
        angleSlider.addChangeListener(changeListener);


        main.add(graph, BorderLayout.CENTER);



    }

    private void updateFields(JSlider angleSlider, JTextField velocityField, JTextField secondsField,
                              JTextField xField, JTextField yField, JTextField peakYField, JTextField interceptXField) {
        Projectile projectile = new Projectile(
                angleSlider.getValue(),
                Double.parseDouble(velocityField.getText())
        );

        double seconds = Double.parseDouble(secondsField.getText());
        projectile.setSeconds(seconds);
        xField.setText(Double.toString(projectile.getX()));
        yField.setText(Double.toString(projectile.getY()));
        peakYField.setText(Double.toString(projectile.getPeakY()));
        interceptXField.setText(Double.toString(projectile.getInterceptX()));

        graph.setProjectile(projectile);

    }


}
