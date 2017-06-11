package com.karreiro;

import java.util.HashSet;
import java.util.Set;

class Grid {

    private final int cols;

    private final int rows;

    private final Set<Node> nodes = new HashSet<>();

    private final Node robot = new Node(new Position(20,
                                                     1),
                                        Node.Type.ROBOT) {{
        setF(0);
        setG(0);
        setH(0);
    }};

    Grid(final int cols,
         final int rows) {

        this.cols = cols;
        this.rows = rows;
    }

    int getCols() {
        return cols;
    }

    int getRows() {
        return rows;
    }

    Set<Node> getNodes() {
        return nodes;
    }

    Node getCell(final Position position) {
        return nodes
                .stream()
                .filter(cell -> cell.getPosition().equals(position))
                .findFirst()
                .orElseGet(() -> {
                    final Node node = new Node(position,
                                               Node.Type.FREE);

                    nodes.add(node);

                    return node;
                });
    }

    Node getRobot() {
        return robot;
    }
}
