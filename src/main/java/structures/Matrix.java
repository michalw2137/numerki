package structures;

public class Matrix {
    private final double[][] fields;
    private int size;

    public int getSize () {
        return size;
    }

    public double getAt (int x, int y) {
        return fields[x][y];
    }

    public void setAd (int x, int y, double value) {
        fields[x][y] = value;
    }

    public Matrix (double[][] fields) {
        this.fields = fields;
        this.size = fields.length;
    }

    public void print() {
        for (double[] row : fields) {
            for (double value : row) {
                System.out.printf("%10.8s", value);
            }
            System.out.println();
        }
        System.out.println();
    }


}
