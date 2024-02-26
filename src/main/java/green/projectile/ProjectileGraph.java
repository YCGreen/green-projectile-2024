package green.projectile;
import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    private Projectile projectile = new Projectile(0,0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.translate(0, getHeight());

        g.setColor(Color.BLACK);

        double totalTime = projectile.getTotalFlightTime();
        projectile.setSeconds(0);

        for(double i = 0; i <= totalTime; i += .1) {
            double currX = projectile.getX();
            double currY = projectile.getY();

            projectile.setSeconds(i);

            g.drawLine((int)currX, -(int)currY, (int)projectile.getX(), -(int)projectile.getY());
        }

        g.setColor(Color.BLUE);

        double peakY = projectile.getPeakY();
        projectile.setSeconds(totalTime / 2);
        double xMid = projectile.getX();
        g.fillOval((int)xMid - 5, -(int)peakY - 5, 10, 10);

    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        repaint();
    }


}
