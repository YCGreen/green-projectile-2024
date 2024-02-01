package green.projectile;

import org.junit.Test;
import static org.junit.Assert.assertEquals; //because assertEquals wasn't recognized and this was Intellij's solution

public class ProjectileTest {
    Projectile projectile = new Projectile(31, 20, 2.7);

    @Test
    public void findX() {
        //when
        double actual = projectile.findX();

        //then
        assertEquals(46.28703423791407, actual, .2);
    }

    @Test
    public void findY() {
        //when
        double actual = projectile.findY();

        //then
        assertEquals(-7.908943954857083, actual, .2);
    }

    @Test
    public void getApexTime() {
        //when
        double actual = projectile.findY();

        //then
        assertEquals(1.051098112061335, actual, .2);
    }

}