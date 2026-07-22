public class PixelVectors {
    int widthPixels;
    int heightPixels;
    int halfWidthPixels;
    int halfHeightPixels;


    double fovDegrees;
    double distancePerPixel;

    double distanceFromNP;
    double halfWidthNP;

    double[][][] pixelVectors;

    public PixelVectors(int width, int height, double fov, double nearPlane) {
        this.widthPixels = width;
        this.heightPixels = height;
        this.halfWidthPixels = width/2;
        this.halfHeightPixels = heightPixels /2;
        this.fovDegrees = fov;

        this.distanceFromNP = nearPlane;
        this.halfWidthNP = Math.tan(fov / 2) * nearPlane;

        this.distancePerPixel = (halfWidthNP * 2) / widthPixels;
        this.pixelVectors = generateVectors();

    }
    public double[][][] generateVectors() {
        double[][][] out = new double[widthPixels][heightPixels][3];
        for (int x = 0; x < widthPixels; x++) {
            for (int y = 0; y < heightPixels; y++) {
                // Side to side
                out[x][y][0] = distancePerPixel * (x - (double) widthPixels / 2);
                // Up and down
                out[x][y][1] = distancePerPixel * (y - (double) heightPixels / 2);
                // Forward and back
                out[x][y][2] = -distanceFromNP;
            }
        }
        return out;
    }


    /*
    Notes:
        With & Height - Have to be even
        Center 4 pixels touching vertices are 0,0,0;

     */
}
