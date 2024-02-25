package green.projectile;
import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {
    private final int MAGNIFY = 5;
    private final int POINTS = 10;

    private Projectile projectile = new Projectile(0,0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.translate(0, getHeight());

        g.setColor(Color.BLACK);

        double interval = projectile.getInterceptX()/POINTS;

        double[] xInts = new double[POINTS];
        double[] yInts = new double[POINTS];

        for(int i = 0; i < POINTS; i++) {
            xInts[i] = interval * (i + 1) * MAGNIFY;
            yInts[i] = projectile.getYAtX(xInts[i] / MAGNIFY) * MAGNIFY * -1;
        }

        g.drawLine(0, 0, (int)xInts[0], (int)yInts[0]);

        for(int i = 0; i < POINTS - 1; i++) {
            g.drawLine((int)xInts[i], (int)yInts[i], (int)xInts[i + 1], (int)yInts[i + 1]);
        }

        g.setColor(Color.BLUE);

        double peakY = projectile.getPeakY()*MAGNIFY;
        double xMid = projectile.getInterceptX()*MAGNIFY/2;
        g.fillOval((int)xMid, -(int)peakY, 20, 20);

    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        repaint();
    }


}
