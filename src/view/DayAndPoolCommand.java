package view;

public enum DayAndPoolCommand {
 END_TURN , SHOW_HAND , SHOW_LAWN , SELECT, REMOVE, PLANT ;
 private int row ;
 private int column ;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
