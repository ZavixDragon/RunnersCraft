package com.game.zavixdragon.runnerscraft;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import java.util.Arrays;
import java.util.List;

public final class Grid {
    private final AppCompatActivity activity;
    private final List<GridItem> items;

    public Grid(AppCompatActivity activity, GridItem... items) {
        this.activity = activity;
        this.items = Arrays.asList(items);
    }

    public void apply() {
        int totalWidth = totalWidth();
        int totalHeight = totalHeight();
        int columns = columns();
        int rows = rows();
        double columnWidth = columnWidth(totalWidth, columns);
        double rowHeight = rowHeight(totalHeight, rows);
        for(GridItem item : items) {
            FrameLayout.LayoutParams itemParams = new FrameLayout.LayoutParams((int)(columnWidth * item.ColumnSpan), (int)(rowHeight * item.RowSpan));
            itemParams.leftMargin = (int)(item.Column * columnWidth);
            itemParams.topMargin = (int)(item.Row * rowHeight);
            activity.findViewById(item.Id).setLayoutParams(itemParams);
        }
    }

    private int totalWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public int totalHeight() {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.height();
    }

    private int columns() {
        int columns = 0;
        for (GridItem item : items)
            if (item.Column + item.ColumnSpan > columns)
                columns = item.Column + item.ColumnSpan;
        return columns;
    }

    public int rows() {
        int rows = 0;
        for (GridItem item : items)
            if (item.Row + item.RowSpan > rows)
                rows = item.Row + item.RowSpan;
        return rows;
    }

    private double columnWidth(int totalWidth, int columns) {
        return (double)totalWidth / (double)columns;
    }

    private double rowHeight(int totalRow, int rows) {
        return (double)totalRow / (double)rows;
    }


}
