
package utils;

import java.awt.Component;

/**
 *
 * @author qphan
 */
public class SizeUtils {

    private SizeUtils() {
    }

    public static int getPreWidth(Component comp) {
        return (int) comp.getPreferredSize().getWidth();
    }

    public static int getPreHeight(Component comp) {
        return (int) comp.getPreferredSize().getHeight();
    }

    public static int getWidth(Component comp) {
        return (int) comp.getSize().getWidth();
    }
}
