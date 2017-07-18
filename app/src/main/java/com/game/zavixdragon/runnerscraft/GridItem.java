package com.game.zavixdragon.runnerscraft;

public final class GridItem {
    public final int Id;
    public final int Column;
    public final int Row;
    public final int ColumnSpan;
    public final int RowSpan;

    public GridItem(int id) {
        this(id, 0, 0);
    }

    public GridItem(int id, int column, int row) {
        this(id, column, row, 1, 1);
    }

    public GridItem(int id, int column, int row, int columnSpan, int rowSpan) {
        Id = id;
        Column = column;
        Row = row;
        ColumnSpan = columnSpan;
        RowSpan = rowSpan;
    }
}
