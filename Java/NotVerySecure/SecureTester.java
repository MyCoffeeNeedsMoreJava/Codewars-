import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecureTester {
    public static boolean alphanumeric(String s) {
        Pattern p = Pattern.compile("[Â-Za-z0-9]");
        Matcher m = p.matcher(s);
        boolean b = m.find();
        if(b || s.isEmpty()) {
            return false;
        }
        return true;
    }
}