package oop.dz3;

public class Square extends Figure{
    private final Integer sideSize;

    public Square(Integer sideSize) {
        this.sideSize = sideSize;
    }

    @Override
    public void draw() {
        System.out.println("Нарисовали квадрат размером " + sideSize);
    }
}
