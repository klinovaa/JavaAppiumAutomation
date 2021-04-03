import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    MainClass Main = new MainClass();

    @Test
    public void testGetLocalNumber(){
       int expected = 14;
       if (Main.getLocalNumber() != expected) {
           Assert.fail("Variable getLocalNumber doesn't equal 14");
       }
    }
}
