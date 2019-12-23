package view;

public enum ProfileMenuCommand {
    CHANGE, DELETE, CREATE, RENAME, SHOW, HELP;

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public static void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        this.password = password;
    }
    }
