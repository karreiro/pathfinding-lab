package com.karreiro;

import java.util.Optional;

class Node {

    private Node parent;

    private Position position;

    private Type type;

    private double f = Double.MAX_VALUE;

    private double g = Double.MAX_VALUE;

    private double h = Double.MAX_VALUE;

    Node(final Position position,
         final Type type) {
        this.position = position;
        this.type = type;
    }

    Position getPosition() {
        return position;
    }

    void setPosition(final Position position) {
        this.position = position;
    }

    Type getType() {
        return type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Node node = (Node) o;

        return position != null ? position.equals(node.position) : node.position == null;
    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }

    Node getParent() {
        return parent;
    }

    boolean hasParent() {
        return Optional.ofNullable(parent).isPresent();
    }

    public double getF() {
        return f;
    }

    public void setF(final double f) {
        this.f = f;
    }

    public double getG() {
        return g;
    }

    public void setG(final double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(final double h) {
        this.h = h;
    }

    public void setParent(final Node parent) {
        this.parent = parent;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Node{" +
                "position=" + position +
                ", type=" + type +
                '}';
    }

    enum Type {
        FREE,
        WALL,
        OBSTACLE,
        PLANT,
        ROBOT,
        PATH,
        SUB_GOAL,
        GOAL
    }
}
