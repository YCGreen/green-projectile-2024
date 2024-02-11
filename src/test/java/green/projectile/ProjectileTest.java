package green.projectile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjectileTest {
    Projectile projectile = new Projectile(31, 65);

    @Test
    public void getX() {
        //given
        projectile.setSeconds(2.7);

        //when
        double actual = projectile.getX();

        //then
        Assertions.assertEquals(150.43285, actual, .01);
    }

    @Test
    public void getY() {
        //given
        projectile.setSeconds(2.7);

        //when
        double actual = projectile.getY();

        //then
        Assertions.assertEquals(54.6681869431, actual, .01);
    }

    @Test
    public void getPeakTime() {
        //when
        double actual = projectile.getPeakTime();

        //then
        Assertions.assertEquals(3.416, actual, .01);
    }

    @Test
    public void getPeakY() {
        //when
        double actual = projectile.getPeakY();

        //then
        Assertions.assertEquals(57.18068, actual, .01);
    }

    @Test
    public void getInterceptX() {
        //when
        double actual = projectile.getInterceptX();

        //then
        Assertions.assertEquals(380.65, actual, .01);
    }

}