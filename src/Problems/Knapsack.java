package Problems;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import algorithmes.HillClimbing;
import algorithmes.SimulatedAnnealing;
import helpers.ReadKnapsackMatrix;
import helpers.ReadMatrixFromFile;

public class Knapsack extends Problem<KnapState, KnapAction> {

    private int maxWeight;
    private int objectsNum;
    private int[] costs;
    private int[] weights;

    public Knapsack() {
        ReadKnapsackMatrix reader = new ReadKnapsackMatrix("src/Knapsack.txt");
        reader.readMatrix();
        this.maxWeight = reader.getMaxWeight();
        this.weights = reader.getWeights();
        this.costs = reader.getCosts();
        this.objectsNum = reader.getNumber();
    }

    @Override
    public KnapState initiallState() {
        return null;
    }

    @Override
    public Vector<KnapAction> actions(KnapState state) {
        return null;
    }

    @Override
    public KnapState result(KnapState state, KnapAction action) {
        return null;
    }

    @Override
    public boolean goal(KnapState state) {
        return false;
    }

    public static void main(String[] args) {

    }

    @Override
    public void print(KnapState state) {
    }

    @Override
    public double objective_function(KnapState state) {
        int [] objects = state.getObjects();
        int result = 0;
        for(int i = 0; i < objects.length; i++){
            result += costs[objects[i]];
        }
        return result;
    }

    @Override
    public KnapState randomState() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random randomGenerator = new Random();

        while (numbers.size() < objectsNum) {
            int random = randomGenerator .nextInt(objectsNum);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        int[] objects = new int[objectsNum];
        for(int i = 0; i < objectsNum; i++){
            objects[i] = numbers.get(i);
        }

        KnapState result = new KnapState(objects);
        return result;
    }

    @Override
    public KnapState crossOver(KnapState x, KnapState y) {
        return null;
    }

    @Override
    public KnapState mutation(KnapState x) {
        return null;
    }
}

class KnapState {
    private int[] objects;

    public KnapState(int[] objects) {
        this.objects = objects;
    }

    @Override
    public boolean equals(Object arg0) {
        KnapState other = (KnapState) arg0;
        for (int i = 0; i < other.objects.length; i++) {
            if (objects[i] != other.objects[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] getObjects() {
        return objects;
    }
}

class KnapAction {
    
    public KnapAction() {
        
    }
}