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

    public Projectile(Projectile projectile) {
        this.angle = projectile.angle;
        this.velocity = projectile.velocity;
        this.seconds = projectile.seconds;
    }

    public double getX() {
        return Math.cos(angle) * velocity * seconds;
    }

    public double getY() {
        return Math.sin(angle) * velocity * seconds - (HALF * GRAVITY * seconds * seconds);
    }

    public double getSeconds() {
        return seconds;
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getAngle() {
        return angle;
    }

    public double getPeakTime() {
        return (velocity * Math.sin(angle)) / GRAVITY;
    }

    //formula from https://www.omnicalculator.com/physics/maximum-height-projectile-motion#how-to-find-the-maximum-height-of-a-projectile
    public double getPeakY() {
        return ((velocity * Math.sin(angle)) * (velocity * Math.sin(angle))) / (2 * GRAVITY);
    }

    public double getInterceptX() {
        return getHorizontalVelocity() * getTotalFlightTime();
    }

    private double getHorizontalVelocity() {
        return velocity * Math.cos(angle);
    }

    private double getVerticalVelocity() {
        return velocity * Math.sin(angle);
    }

    public double getTotalFlightTime() {
        return (2 * velocity * Math.sin(angle) / GRAVITY);
    }

}
