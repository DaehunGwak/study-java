package ch06.item34;

public enum Planet {
    EARTH (5.975e+24, 6.378e6),
    MARS (6.319e+23, 3.393e6),
    ;

    private static final double G = 6.67300E-11;

    private final double mass;
    private final double radius;
    private final double surfaceGravity;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }

    public static void main(String[] args) {
        System.out.println(Planet.EARTH);
        System.out.println(Planet.MARS.surfaceWeight(100_000));
    }
}
