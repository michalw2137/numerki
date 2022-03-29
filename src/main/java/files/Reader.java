package files;

import java.io.*;
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
}
