package view;

public enum CollectionCommand {
    SHOW_HAND, SHOW_COLLECTION, PLAY, SELECT, REMOVE;
    private String name;
    private  Menu nextPlayMenu ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getNextPlayMenu() {
        return nextPlayMenu;
    }

    public void setNextPlayMenu(Menu nextPlayMenu) {
        this.nextPlayMenu = nextPlayMenu;
    }
}
