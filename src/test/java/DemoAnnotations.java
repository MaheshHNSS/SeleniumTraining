import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAnnotations {

    @Test
    public void testGrapes(){
        System.out.println("grapes");

    }

    @Test(priority=5)
    public void testApple(){
       System.out.println("apple");
    }

    @Test(priority=-5)
    public void testOrange(){
        System.out.println("orange");

    }

    @Test(timeOut=5000,enabled=false)
    public void testTimeout() throws InterruptedException {
       Thread.sleep(9000);
    }

    @Test(description="This test case for demoing timeout attribute")
    public void testDescriptationattribute() throws InterruptedException {

    }

    @Test
    public void testLogin(){
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods={"testLogin"})
    public void myAccount(){

    }


}
