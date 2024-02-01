package green.projectile;

public class Main {
    public static void main(String[] args) {
        Projectile myProjectile = new Projectile(31, 20, 2.7);

        System.out.println("x = " + myProjectile.findX() + ", y = " + myProjectile.findY() + "\nTime to apex = " + myProjectile.getApexTime());
    }
}