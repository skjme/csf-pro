package nio.selector;

import java.nio.channels.spi.SelectorProvider;

public class Test19 {

    public static void main(String[] args) {
        SelectorProvider provider1 = SelectorProvider.provider();
        SelectorProvider provider2 = SelectorProvider.provider();

        System.out.println(provider1);
        System.out.println(provider2);
        System.out.println(provider1 == provider2);
    }
}
