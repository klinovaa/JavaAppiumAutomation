import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    MainClass Main = new MainClass();

    @Test
    public void testGetClassNumber() {
        if (Main.getClassNumber() < 45) {
            Assert.fail("Variable getClassNumber is less than 45");
        }
    }
}
