package structures;

import java.util.Arrays;

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
            System.out.printf("       %-15.13s", value);
            System.out.println();
        }
    }


    public int getSize () {
        return fields.length;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Arrays.equals(fields, vector.fields);
    }

    @Override
    public int hashCode () {
        return Arrays.hashCode(fields);
    }
}
