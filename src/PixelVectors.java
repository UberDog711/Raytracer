public class PixelVectors {
    int widthP;
    int heightP;

    double forDegrees;
    double nearPlane;
    double widthNearPlaneHalf;
    double unitsPerPixel;


    public PixelVectors(int width, int height, int fov, int nearPlane) {
        this.widthP = width;
        this.heightP = height;
        this.forDegrees = fov;
        this.nearPlane = nearPlane;
        this.widthNearPlaneHalf = Math.tan(forDegrees / 2) * nearPlane;
        this.unitsPerPixel = (widthNearPlaneHalf * 2) / widthP;
    }
    public double[][] generatePixelVectorsY() {
        double[][] out = new double[widthP][3];
        for (int pixelsX = 0; pixelsX < widthP / 2; pixelsX++) {
            out[pixelsX][1] = pixelsX + (double) 1/2 * unitsPerPixel;
        }

        return out;
    }
    /*
    Notes:
        With & Height - Have to be even
        Center 4 pixels touching vertices are 0,0,0;

     */
}
