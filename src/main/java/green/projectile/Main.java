package green.projectile;

public class Main {
    public static void main(String[] args) {
       ProjectileFrame frame = new ProjectileFrame();
       frame.setVisible(true);

       Projectile proj = new Projectile(30, 40);
       proj.setSeconds(2.7);

       System.out.println(proj.getYAtX(3));
        System.out.println(proj.getXAtY(57));

    }
}