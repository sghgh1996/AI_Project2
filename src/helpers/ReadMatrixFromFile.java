package helpers;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadMatrixFromFile {

    private DataInputStream dis;
    private int[][] resultMatrix;
    private String fileName;
    private int size;

    public ReadMatrixFromFile(String file_name) {
        this.fileName = file_name;
    }

    public void readMatrix() {
        try{
            dis = new DataInputStream(new FileInputStream(fileName));

            size = Integer.parseInt(dis.readLine());
            resultMatrix = new int[size][size];

            String[] tempt1;
            for (int i = 0; i < size; i++) {
                String s = dis.readLine();
                tempt1 = s.split(" ");

                for (int j = 0; j < size; j += 1) {
                    resultMatrix[i][j] = Integer.parseInt(tempt1[j]);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int[][] getResultMatrix() {
        return resultMatrix;
    }

    public int getSize() {
        return size;
    }
}