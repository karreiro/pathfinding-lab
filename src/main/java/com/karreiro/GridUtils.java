package com.karreiro;

class GridUtils {

    static void addGoal(final Grid grid,
                        final int x,
                        final int y) {
        grid.getNodes().add(new Node(new Position(x,
                                                  y),
                                     Node.Type.GOAL));
    }

    static void addObstacles(final Grid grid) {
        addBigObstacle(grid,
                       20,
                       20);
        addBigObstacle(grid,
                       4,
                       8);
        addBigObstacle(grid,
                       33,
                       31);
        addBigObstacle(grid,
                       42,
                       40);
        addBigObstacle(grid,
                       44,
                       40);
        addSmallObstacle(grid,
                         40,
                         10);
        addSmallObstacle(grid,
                         45,
                         10);
        addSmallObstacle(grid,
                         46,
                         10);
        addSmallObstacle(grid,
                         47,
                         10);
        addSmallObstacle(grid,
                         48,
                         10);
        addSmallObstacle(grid,
                         32,
                         14);
        addSmallObstacle(grid,
                         31,
                         24);
        addSmallObstacle(grid,
                         32,
                         24);
        addSmallObstacle(grid,
                         20,
                         41);
        addSmallObstacle(grid,
                         21,
                         36);
        addSmallObstacle(grid,
                         17,
                         23);
        addSmallObstacle(grid,
                         17,
                         24);
        addSmallObstacle(grid,
                         17,
                         25);
        addSmallObstacle(grid,
                         12,
                         32);
        addSmallObstacle(grid,
                         13,
                         32);
        addSmallObstacle(grid,
                         14,
                         32);
        addSmallObstacle(grid,
                         9,
                         12);
        addSmallObstacle(grid,
                         43,
                         32);
        addSmallObstacle(grid,
                         44,
                         32);
        addSmallObstacle(grid,
                         45,
                         32);
        addSmallObstacle(grid,
                         43,
                         23);
        addSmallObstacle(grid,
                         19,
                         12);
        addSmallObstacle(grid,
                         20,
                         12);
        addSmallObstacle(grid,
                         21,
                         12);
        addSmallObstacle(grid,
                         22,
                         12);
        addSmallObstacle(grid,
                         22,
                         20);
        addSmallObstacle(grid,
                         23,
                         20);
        addSmallObstacle(grid,
                         24,
                         20);
        addSmallObstacle(grid,
                         25,
                         20);
        addSmallObstacle(grid,
                         15,
                         20);
        addSmallObstacle(grid,
                         16,
                         20);
        addSmallObstacle(grid,
                         17,
                         20);
        addSmallObstacle(grid,
                         18,
                         20);
        addSmallObstacle(grid,
                         19,
                         20);
        addSmallObstacle(grid,
                         14,
                         20);
        addSmallObstacle(grid,
                         13,
                         20);
        addSmallObstacle(grid,
                         12,
                         20);
        addSmallObstacle(grid,
                         11,
                         20);
        addSmallObstacle(grid,
                         10,
                         20);
        addSmallObstacle(grid,
                         9,
                         20);
        addSmallObstacle(grid,
                         26,
                         20);
        addSmallObstacle(grid,
                         27,
                         20);
        addSmallObstacle(grid,
                         28,
                         20);
        addSmallObstacle(grid,
                         29,
                         20);
        addSmallObstacle(grid,
                         30,
                         20);
        addSmallObstacle(grid,
                         31,
                         20);
    }

    static void addWalls(final Grid grid) {
        for (int i = 0; i < grid.getCols(); i++) {
            final Node topWall = new Node(new Position(0,
                                                       i),
                                          Node.Type.WALL);
            final Node bottomWall = new Node(new Position(grid.getRows() - 1,
                                                          i),
                                             Node.Type.WALL);

            grid.getNodes().add(topWall);
            grid.getNodes().add(bottomWall);
        }

        for (int i = 0; i < grid.getRows(); i++) {
            final Node leftWall = new Node(new Position(i,
                                                        0),
                                           Node.Type.WALL);
            final Node rightWall = new Node(new Position(i,
                                                         grid.getCols() - 1),
                                            Node.Type.WALL);

            grid.getNodes().add(leftWall);
            grid.getNodes().add(rightWall);
        }
    }

    private static void addBigObstacle(final Grid grid,
                                       final int x,
                                       final int y) {
        addSmallObstacle(grid,
                         x,
                         y);
        addSmallObstacle(grid,
                         x + 1,
                         y);
        addSmallObstacle(grid,
                         x,
                         y + 1);
        addSmallObstacle(grid,
                         x + 1,
                         y + 1);
    }

    private static void addSmallObstacle(final Grid grid,
                                         final int x,
                                         final int y) {
        grid.getNodes().add(new Node(new Position(x,
                                                  y),
                                     Node.Type.OBSTACLE));
    }
}
