package structures;

public class Vector {
    private double[] fields;

    public Vector (double[] fields) {
        this.fields = fields;
    }

    public double getAt(int x) {
        return fields[x];
    }

    public void print() {
        for (double value : fields) {
            System.out.println(value);
        }
        System.out.println();
    }


}
