package green.projectile;

public class Main {
    public static void main(String[] args) {
        Projectile myProjectile = new Projectile(31, 65);
        myProjectile.setSeconds(2.7);

        System.out.println("x = " + myProjectile.getX() + ", y = " + myProjectile.getY()
                + "\nTime to apex = " + myProjectile.getApexTime());
    }
}