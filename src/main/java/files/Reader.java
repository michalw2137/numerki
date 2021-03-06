package files;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    public String read(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
        return "2";
    }

    public double[] readVector(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int size = Integer.valueOf(sc.nextLine());
        double[] tab = new double[size];
        int index = 0;
        while (sc.hasNextLine()) {
            tab[index] = Double.valueOf(sc.nextLine());
            index++;
        }
        return tab;
    }

    public String readString(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        return sc.nextLine();
    }

    public double[][] readMatrix(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int xSize = Integer.valueOf(sc.nextLine());
        int ySize = Integer.valueOf(sc.nextLine());
        if (xSize != ySize){
            throw new IOException("MATRIX MUST BE SQUARE");
        }
        double[][] tab = new double[xSize][ySize];
        for (int i=0; i<ySize; i++){
            for (int j=0; j<xSize; j++){
                if(sc.hasNextLine()){
                    tab[i][j] = Double.valueOf(sc.nextLine());
                }
                else break;
            }
        }

        return tab;
    }

    public static ArrayList<Double> readArguments(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        ArrayList<Double> arguments = new ArrayList<>();
        int i = 0;
        while(sc.hasNext()) {
            String value = sc.next();
            if (i % 2 == 0) {
                arguments.add(Double.valueOf(value));
            }
            i++;
        }
        return arguments;
    }

    public static ArrayList<Double> readValues(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        ArrayList<Double> values = new ArrayList<>();
        int i = 0;
        while(sc.hasNext()) {
            String value = sc.next();
            if (i % 2 == 1) {
                values.add(Double.valueOf(value));
            }
            i++;
        }
        return values;
    }

}
