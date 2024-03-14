package green.projectile;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ProjectileGraph extends JComponent {

    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");
    private Projectile projectile = new Projectile(0, 0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.translate(0, getHeight());

        g.setColor(Color.WHITE);

        g.fillRect(0, -getHeight(), getWidth(), getHeight());

        g.setColor(Color.LIGHT_GRAY);

        int maxArea = Math.max(getHeight(), getWidth());
        for (int i = 0; i < maxArea; i += 30) {
            g.drawLine(0, -i, getWidth(), -i);
            g.drawLine(i, 0, i, -getHeight());
        }

        g.setColor(Color.BLACK);

        g.drawLine(30, -getHeight(), 30, getHeight());
        g.drawLine(0, -30, getWidth(), -30);

        g.translate(30, -30);

        double secondsOnEnter = projectile.getSeconds();
        double totalTime = projectile.getTotalFlightTime();
        projectile.setSeconds(0);

        for (double i = 0; i <= totalTime; i += .1) {
            double currX = projectile.getX();
            double currY = projectile.getY();

            projectile.setSeconds(i);

            g.drawLine((int) currX, -(int) currY, (int) projectile.getX(), -(int) projectile.getY());
        }

        g.setColor(Color.BLUE);

        projectile.setSeconds(totalTime / 2);
        double peakX = projectile.getX();
        double peakY = -projectile.getY();

        String peakXStr = FORMAT.format(peakX);
        String peakYStr = FORMAT.format(-peakY);

        g.fillOval((int) peakX - 5, (int) peakY - 5, 10, 10);
        g.drawString("(" + peakXStr + ", " + peakYStr + ")", (int) peakX, (int) peakY - 10);

        g.setColor(Color.RED);

        Projectile secProjectile = new Projectile(projectile);
        secProjectile.setSeconds(secondsOnEnter);
        double xAtSec = secProjectile.getX();
        double yAtSec = secProjectile.getY();
        String xStr = FORMAT.format(xAtSec);
        String yStr = FORMAT.format(yAtSec);

        g.fillOval((int) xAtSec - 5, -(int) yAtSec - 5, 10, 10);
        g.drawString("(" + xStr + ", " + yStr + ")", (int) xAtSec, -(int) yAtSec - 10);

    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        repaint();
    }


}
