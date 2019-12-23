package view;

public class Show {
    private static final Show show = new Show();

    private Show() {

    }

    public static Show getInstance() {
        return show;
    }

    public void printAMessage(String message) {
        System.out.println(message);
    }

    public void showMenu(Menu menu) {
        System.out.println(" *** " + menu.name() + " Menu *** ");
    }
}
