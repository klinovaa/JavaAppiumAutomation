import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    MainClass Main = new MainClass();

    @Test
    public void testGetClassString() {
        String sub = "Hello";
        if (Main.getClassString().contains(sub)) {}
        else {
            Assert.fail("String class_string has no text \"Hello\" in it");
        }
    }
}
