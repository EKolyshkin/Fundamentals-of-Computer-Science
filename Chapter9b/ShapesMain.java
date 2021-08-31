// Demonstrates shape classes.
public class ShapesMain {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Octagon(7);
        shapes[1] = new Hexagon(5);
        
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("area=" + shapes[i].getArea() +
                               ", perimeter=" + 
                               shapes[i].getPerimeter());
        }
    }
}
