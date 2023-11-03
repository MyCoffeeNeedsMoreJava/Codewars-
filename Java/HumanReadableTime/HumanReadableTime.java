import java.time.Duration;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        Duration dur = Duration.ofSeconds(seconds);
        long hours = dur.toHours();
        long mins = dur.getSeconds() % (60*60) / 60;
        long secs = dur.getSeconds() % 60;
        return String.format("%02d:%02d:%02d", hours, mins, secs);
    }
}


/*
 * After looking at other solutions, it follows the same idea, but could also be done without duration or as a oneline:
 * return String.format("%02d:%02d:%02d", seconds/3600, (seconds/60) % 60, seconds % 60)
 */