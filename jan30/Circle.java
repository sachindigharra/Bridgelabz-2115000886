package jan30;

class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public void displayAreaAndCircumference() {
        double area = calculateArea();
        double circumference = calculateCircumference();
        System.out.println("Circle Details:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area);
        System.out.println("Circumference: " + circumference);
    }
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        circle1.displayAreaAndCircumference();

        Circle circle2 = new Circle(7);
        circle2.displayAreaAndCircumference();
    }
}
