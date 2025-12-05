import java.util.Scanner;

public class ShapeArray {

    // ==============================
    // Abstract Base Class: Shape
    // ==============================
    abstract static class Shape {
        public abstract double surface_area();
        public abstract double volume();
    }

    // ==============================
    // Sphere Class
    // ==============================
    static class Sphere extends Shape {
        private double radius;

        public Sphere(double radius) {
            this.radius = radius;
        }

        @Override
        public double surface_area() {
            return 4 * Math.PI * radius * radius;
        }

        @Override
        public double volume() {
            return (4.0 / 3.0) * Math.PI * radius * radius * radius;
        }

        @Override
        public String toString() {
            return String.format(
                "Sphere%nRadius: %.2f%nSurface Area: %.4f%nVolume: %.4f%n",
                radius, surface_area(), volume()
            );
        }
    }

    // ==============================
    // Cylinder Class
    // ==============================
    static class Cylinder extends Shape {
        private double radius;
        private double height;

        public Cylinder(double radius, double height) {
            this.radius = radius;
            this.height = height;
        }

        @Override
        public double surface_area() {
            return 2 * Math.PI * radius * radius + 2 * Math.PI * radius * height;
        }

        @Override
        public double volume() {
            return Math.PI * radius * radius * height;
        }

        @Override
        public String toString() {
            return String.format(
                "Cylinder%nRadius: %.2f%nHeight: %.2f%nSurface Area: %.4f%nVolume: %.4f%n",
                radius, height, surface_area(), volume()
            );
        }
    }

    // ==============================
    // Cone Class
    // ==============================
    static class Cone extends Shape {
        private double radius;
        private double height;

        public Cone(double radius, double height) {
            this.radius = radius;
            this.height = height;
        }

        @Override
        public double surface_area() {
            double slantHeight = Math.sqrt(radius * radius + height * height);
            return Math.PI * radius * radius + Math.PI * radius * slantHeight;
        }

        @Override
        public double volume() {
            return (1.0 / 3.0) * Math.PI * radius * radius * height;
        }

        @Override
        public String toString() {
            return String.format(
                "Cone%nRadius: %.2f%nHeight: %.2f%nSurface Area: %.4f%nVolume: %.4f%n",
                radius, height, surface_area(), volume()
            );
        }
    }

    // ==============================
    // Helper method to read a positive double
    // ==============================
    private static double readPositiveDouble(Scanner scanner, String prompt) {
        double value = -1;
        while (value <= 0) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value <= 0) {
                    System.out.println("Please enter a value greater than 0.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // clear invalid token
            }
        }
        return value;
    }

    // ==============================
    // Main Method (Driver)
    // ==============================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Shape Calculator ===");

        // Sphere input
        double sphereRadius = readPositiveDouble(scanner, "Enter radius for the sphere: ");

        // Cylinder input
        double cylinderRadius = readPositiveDouble(scanner, "Enter radius for the cylinder: ");
        double cylinderHeight = readPositiveDouble(scanner, "Enter height for the cylinder: ");

        // Cone input
        double coneRadius = readPositiveDouble(scanner, "Enter radius for the cone: ");
        double coneHeight = readPositiveDouble(scanner, "Enter height for the cone: ");

        // Instantiate the shapes
        Sphere sphere = new Sphere(sphereRadius);
        Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight);
        Cone cone = new Cone(coneRadius, coneHeight);

        // Store in array
        Shape[] shapeArray = { sphere, cylinder, cone };

        System.out.println();
        System.out.println("=== Results ===");
        // Print each shape
        for (Shape shape : shapeArray) {
            System.out.println(shape);
        }

        scanner.close();
    }
}
