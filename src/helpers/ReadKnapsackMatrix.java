package helpers;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadKnapsackMatrix {

    private DataInputStream dis;
    private int[] costs;
    private int[] weights;
    private String fileName;
    private int number;
    private int maxWeight;

    public ReadKnapsackMatrix(String file_name) {
        this.fileName = file_name;
    }

    public void readMatrix() {
        try{
            dis = new DataInputStream(new FileInputStream(fileName));

            number = Integer.parseInt(dis.readLine());

            costs = new int[number];
            weights = new int[number];

            String[] tempt1;
            for (int j = 0; j < number; j += 1) {
                String s = dis.readLine();
                tempt1 = s.split(" ");

                weights[j] = Integer.parseInt(tempt1[j]);
            }

            for (int j = 0; j < number; j += 1) {
                String s = dis.readLine();
                tempt1 = s.split(" ");

                costs[j] = Integer.parseInt(tempt1[j]);
            }
            maxWeight = Integer.parseInt(dis.readLine());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int[] getCosts() {
        return costs;
    }

    public int[] getWeights() {
        return weights;
    }

    public int getNumber() {
        return number;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}