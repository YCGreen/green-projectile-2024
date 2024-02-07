package green.projectile;

public class Projectile {
    private static final double GRAVITY = 9.8;
    private static final double HALF = 0.5;
    private double angle;
    private double velocity;
    private double seconds;

    public Projectile(double angle, double velocity) {
        this.angle = Math.toRadians(angle);
        this.velocity = velocity;
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getX() {
        return Math.cos(angle) * velocity * seconds;
    }

    public double getY() {
        return Math.sin(angle) * velocity * seconds - (HALF * GRAVITY * seconds * seconds);
    }

    public double getApexTime() {
        return (velocity * Math.sin(angle)) / GRAVITY;
    }

    //formula from https://www.omnicalculator.com/physics/maximum-height-projectile-motion#how-to-find-the-maximum-height-of-a-projectile
    public double getPeakY() {
        return ((velocity * Math.sin(angle)) * (velocity * Math.sin(angle))) / (2 * GRAVITY);
    }


}
