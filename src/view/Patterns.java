package view;

import java.util.regex.Pattern;

public class Patterns {

    static Pattern[] majorLoginPatterns = new Pattern[]{
            Pattern.compile("^(?i)leaderboard\\s*$"),
            Pattern.compile("^(?i)create account\\s*$"),
            Pattern.compile("^(?i)login\\s*$"),
    };
    static Pattern[] loginPattern = new Pattern[]{
            Pattern.compile("^(?i)(\\S+) (\\S+)\\s*$"),
    };
    static Pattern[] shopPatterns = new Pattern[]{
            Pattern.compile("^(?i)money\\s*$"),
            Pattern.compile("^(?i)show shop\\s*$"),
            Pattern.compile("^(?i)show collection\\s*$"),
            Pattern.compile("^(?i)buy (\\S+)\\s*$"),
    };
    static Pattern[] signUpPatterns = new Pattern[]{
            Pattern.compile("^(?i)(\\S+) (\\S+)\\s*$"),
    };
    static Pattern[] collectionPatterns = new Pattern[]{
            Pattern.compile("^(?i)show hand\\s*$"),
            Pattern.compile("^(?i)show collection\\s*$"),
            Pattern.compile("^(?i)select (\\S+)\\s*$"),
            Pattern.compile("^(?i)remove (\\S+)\\s*$"),
            Pattern.compile("^(?i)play\\s*$"),
    };

    static Pattern[] profilePatterns = new Pattern[]{
            Pattern.compile("^(?i)change (\\S+) (\\S+)\\s*$"),
            Pattern.compile("^(?i)delete (\\S+) (\\S+)\\s*$"),
            Pattern.compile("^(?i)create (\\S+) (\\S+)\\s*$"),
            Pattern.compile("^(?i)rename (\\S+)\\s*$"),
            Pattern.compile("^(?i)show\\s*$"),
    };
    static Pattern[] mainPatterns = new Pattern[]{
            Pattern.compile("^(?i)play\\s*$"),
            Pattern.compile("^(?i)profile\\s*$"),
            Pattern.compile("^(?i)shop\\s*$"),

    };
    static Pattern[] playPatterns = new Pattern[]{
            Pattern.compile("^(?i)day\\s*$"),
            Pattern.compile("^(?i)water\\s*$"),
            Pattern.compile("^(?i)rail\\s*$"),
            Pattern.compile("^(?i)zombie\\s*$"),
            Pattern.compile("^(?i)pvp\\s*$"),
    };

    static Pattern[] dayAndPoolPlayPatterns = new Pattern[]{
            Pattern.compile("^(?i)end turn\\s*$"),
            Pattern.compile("^(?i)show hand\\s*$"),
            Pattern.compile("^(?i)show lawn\\s*$"),
            Pattern.compile("^(?i)select (\\S+)\\s*$"),
            Pattern.compile("^(?i)remove (\\d+) (\\d+)\\s*$"),
            Pattern.compile("^(?i)plant (\\d+) (\\d+)\\s*$"),
    };
    static Pattern[] railPlayPatterns = new Pattern[]{
            Pattern.compile("^(?i)list\\s*$"),
            Pattern.compile("^(?i)record\\s*$"),
            Pattern.compile("^(?i)end turn\\s*$"),
            Pattern.compile("^(?i)show lawn\\s*$"),
            Pattern.compile("^(?i)select (\\d+)\\s*$"),
            Pattern.compile("^(?i)plant (\\d+),(\\d+)\\s*$"),
            Pattern.compile("^(?i)remove (\\d+),(\\d+)\\s*$"),
    };

    static Pattern[] zombiePlayPatterns = new Pattern[]{
            Pattern.compile("^(?i)show hand\\s*$"),
            Pattern.compile("^(?i)show lanes\\s*$"),
            Pattern.compile("^(?i)start\\s*$"),
            Pattern.compile("^(?i)end turn\\s*$"),
            Pattern.compile("^(?i)show lawn\\s*$"),
            Pattern.compile("^(?i)put (\\s+),(\\d+) in row (\\d+)\\s*$"),
    };
    static Pattern[] pVpPlayPatterns = new Pattern[]{
         //todo
    };
}