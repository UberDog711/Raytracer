public class PixelVectors {
    int widthPixels;
    int heightPixels;
    int halfWidthPixels;
    int halfHeightPixels;


    double fovDegrees;
    double distancePerPixel;

    double distanceFromNP;
    double halfWidthNP;



    public PixelVectors(int width, int height, double fov, double nearPlane) {
        this.widthPixels = width;
        this.heightPixels = height;
        this.halfWidthPixels = width/2;
        this.halfHeightPixels = heightPixels /2;
        this.fovDegrees = fov;

        this.distanceFromNP = nearPlane;
        this.halfWidthNP = Math.tan(fov / 2) * nearPlane;

        this.distancePerPixel = (halfWidthNP * 2) / widthPixels;
    }

    public double[][] generatePixelVectorsY() {
        double[][] out = new double[widthPixels][3];
        double angle;

        for (int pixelsX = 0; pixelsX < halfWidthPixels; pixelsX++) {
            angle = Math.toDegrees(Math.atan((pixelsX + 0.5)/distanceFromNP));
            out[halfWidthPixels + pixelsX][1] = angle;
            out[halfWidthPixels - pixelsX - 1][1] = angle;
        }

        return out;
    }
    /*
    Notes:
        With & Height - Have to be even
        Center 4 pixels touching vertices are 0,0,0;

     */
}
