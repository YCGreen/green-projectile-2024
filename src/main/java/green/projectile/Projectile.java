package green.projectile;

public class Projectile {
    final double BASE_CASE = 0;
    final double GRAVITY = 9.8;
    final double HALF = 0.5;
    double angle, velocity, seconds = BASE_CASE;

    public Projectile(double angle, double velocity, double seconds) {
        this.angle = Math.toRadians(angle);
        this.velocity = velocity;
        this.seconds = seconds;
    }

    public double findX() {
        return Math.cos(angle) * velocity * seconds;
    }

    public double findY() {
        return Math.sin(angle) * velocity * seconds - (HALF * GRAVITY * seconds * seconds);
    }

    public double getApexTime() {
        return (velocity * Math.sin(angle)) / GRAVITY;
    }




}
