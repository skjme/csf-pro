package dubboimpl.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

public class DubboSPITest {

    @Test
    public void sayHello() throws Exception {
        ExtensionLoader<Robot> extensionLoader =
            ExtensionLoader.getExtensionLoader(Robot.class);
        System.out.println("Dubbo SPI");

        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();

        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}