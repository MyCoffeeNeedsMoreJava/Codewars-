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

/*
* The Kata had the following restrictions:
* At least one character("" is not valid).
* Allowed characters are uppercase/lowercase lating letters and digits from 0 to 9
* No whitespaces/underscore
*\
