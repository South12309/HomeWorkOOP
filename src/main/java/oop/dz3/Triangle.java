package oop.dz3;

public class Triangle extends Figure{
    private final Integer side1Size;
    private final Integer side2Size;
    private final Integer side3Size;

    public Triangle(Integer side1Size, Integer side2Size, Integer side3Size) {
        this.side1Size = side1Size;
        this.side2Size = side2Size;
        this.side3Size = side3Size;
    }

    @Override
    public void draw() {
        System.out.println("Нарисовали треугольник со сторонами " + side1Size + ", " + side2Size + ", " + side3Size);
    }
}
