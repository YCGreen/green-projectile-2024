package green.projectile;

public class Projectile {
    private static final double GRAVITY = 9.8;
    private static final double HALF = 0.5;
    public double angle;
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

    public double getSeconds() {
        return seconds;
    }

    public double getPeakTime() {
        return (velocity * Math.sin(angle)) / GRAVITY;
    }

    //formula from https://www.omnicalculator.com/physics/maximum-height-projectile-motion#how-to-find-the-maximum-height-of-a-projectile
    public double getPeakY() {
        return ((velocity * Math.sin(angle)) * (velocity * Math.sin(angle))) / (2 * GRAVITY);
    }

    public double getInterceptX() {
        return getHorizontalVelocity() * getTimeAtXInt();
    }

    public double getTimeAtX(double x) {
        return x / getHorizontalVelocity();
    }

    public double getTimeAtY(double y) {
        return y / getVerticalVelocity();
    }

    public double getYAtX(double x) {
        double seconds = getTimeAtX(x);
        return Math.sin(angle) * velocity * seconds - (HALF * GRAVITY * seconds * seconds);
    }

    public double getXAtY(double y) {
        return getHorizontalVelocity() * getTimeAtY(y);
    }

    private double getHorizontalVelocity() {
        return velocity * Math.cos(angle);
    }

    private double getVerticalVelocity() {
        return velocity * Math.sin(angle);
    }

    //method to get time at which the projectile reaches the x intercept
    private double getTimeAtXInt() {
        double vertical = getVerticalVelocity();
        return (vertical + Math.sqrt(vertical * vertical - 2 * GRAVITY * getY())) / GRAVITY;
    }

}
