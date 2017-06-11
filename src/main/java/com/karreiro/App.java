package com.karreiro;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;

import static com.karreiro.GridUtils.addGoal;
import static com.karreiro.GridUtils.addObstacles;
import static com.karreiro.GridUtils.addWalls;

public class App {

    public static void main(final String[] args) {
        final Grid grid = new Grid(50,
                                   50);

        addWalls(grid);
        addObstacles(grid);
        addGoal(grid,
                20,
                45);

        final GridUI gridUI = new GridUI(grid);

        gridUI.refresh();

        AStar aStar = new AStar(grid);

        System.out.println("Starting...");

        List<Node> nodes = aStar.find();

        for (int i = 0; i < nodes.size(); i++) {
            final Node n = nodes.get(i);

            Node parent = n.getParent();

            if (parent == null) {
                n.setType(Node.Type.SUB_GOAL);
            } else {
                try {
                    final Node prevNode = nodes.get(i - 1);
                    double variation1 = variation(n.getPosition().getX() - prevNode.getPosition().getX(),
                                                  n.getPosition().getY() - prevNode.getPosition().getY());
                    double variation2 = variation(parent.getPosition().getX() - n.getPosition().getX(),
                                                  parent.getPosition().getY() - n.getPosition().getY());

                    if ((variation1 - variation2) != 0) {
                        n.setType(Node.Type.SUB_GOAL);
                    } else {
                        n.setType(Node.Type.PATH);
                    }
                } catch (Exception e) {
                    n.setType(Node.Type.SUB_GOAL);
                }
            }
        }

        gridUI.refresh();

        System.out.println("Done!");

//        loop(() -> {
//            final Node robot = grid.getRobot();
//            final Position robotPosition = robot.getPosition();
//            final Position position = new Position(robotPosition.getX(),
//                                                   robotPosition.getY() + 1);
//
//            robot.setPosition(position);
//
//            gridUI.refresh();
//        }, 1000);

        new JFrame() {{
            setTitle("GridUI");
            setContentPane(gridUI);
            setVisible(true);
            setSize(new Dimension(800,
                                  800));
        }};
    }

    private static double variation(final int deltaX,
                                    final int deltaY) {
        double atan = Math.atan(deltaX / deltaY);

        if (atan < 0) {
            atan = atan * -1;
        }

        return Math.toDegrees(atan);
    }
}
