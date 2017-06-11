package com.karreiro;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

class GridUI extends JPanel {

    private final Grid grid;

    GridUI(final Grid grid) {
        this.grid = grid;
    }

    void refresh() {
        removeAll();

        setLayout(new GridLayout(getRows(),
                                 getCols()));

        for (int x = 0; x < getCols(); x++) {
            for (int y = 0; y < getRows(); y++) {
                Position position = new Position(x,
                                                 y);

                if(position.equals(grid.getRobot().getPosition())) {
                    add(makeCell(grid.getRobot()));
                } else {
                    add(makeCell(grid.getCell(position)));
                }
            }
        }

        updateUI();
    }

    private JPanel makeCell(final Node node) {
        final Border border = BorderFactory.createLineBorder(Color.lightGray);

        return new JPanel() {{
            setBackground(getColor(node));
            setBorder(border);
        }};
    }

    private Color getColor(final Node node) {
        switch (node.getType()) {
            case FREE:
                return Color.white;
            case WALL:
                return Color.black;
            case OBSTACLE:
                return Color.darkGray;
            case PLANT:
                return Color.green;
            case ROBOT:
                return Color.red;
            case GOAL:
                return Color.blue;
            case PATH:
                return Color.orange;
            case SUB_GOAL:
                return Color.magenta;
            default:
                return Color.pink;
        }
    }

    private int getCols() {
        return grid.getCols();
    }

    private int getRows() {
        return grid.getRows();
    }
}
