package oop.dz3;

public class Circle  extends Figure{

    private final Integer radius;

    public Circle(Integer radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Нарисовали круг радиусом " + radius);
    }
}
