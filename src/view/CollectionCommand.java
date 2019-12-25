package view;

public enum CollectionCommand {
    SHOW_HAND, SHOW_COLLECTION, PLAY, SELECT, REMOVE;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
