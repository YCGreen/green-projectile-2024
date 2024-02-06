package green.projectile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjectileTest {
    Projectile projectile = new Projectile(31, 65);

    @Test
    public void getX() {
        //when
        projectile.setSeconds(2.7);
        double actual = projectile.getX();

        //then
        Assertions.assertEquals(150.43285, actual, .2);
    }

    @Test
    public void getY() {
        //when
        projectile.setSeconds(2.7);
        double actual = projectile.getY();

        //then
        Assertions.assertEquals(54.6681869431, actual, .2);
    }

    @Test
    public void getApexTime() {
        //when
        double actual = projectile.getApexTime();

        //then
        Assertions.assertEquals(3.416, actual, .2);
    }

    @Test
    public void getPeakY() {
        //when
        double actual = projectile.getPeakY();

        //then
        Assertions.assertEquals(57.18068, actual, .1);
    }

}