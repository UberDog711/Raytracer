import java.util.Arrays;

public class Tester {
    PixelVectors pixelVectors = new PixelVectors(4,6,90,1);
    public void main() {
        System.out.println(Arrays.deepToString(pixelVectors.generatePixelVectorsY()));
    }
}
