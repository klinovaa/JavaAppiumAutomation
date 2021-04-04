import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {
    MainClass Main = new MainClass();

    @Test
    public void testGetClassString() {
        String sub = "Hello";
        String sub2 = "hello";
        if (Main.getClassString().contains(sub) | Main.getClassString().contains(sub2)) {}
        else {
            Assert.fail("String class_string has no text \"Hello\" or \"hello\" in it");
        }
    }
}
