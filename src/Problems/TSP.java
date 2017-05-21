package Problems;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import algorithmes.HillClimbing;
import algorithmes.SimulatedAnnealing;
import helpers.ReadMatrixFromFile;

public class TSP extends Problem<TSPState, TSPAction> {

    private int[] city_map;
    private int[][] map;
    private int map_size;

    public TSP() {
        ReadMatrixFromFile reader = new ReadMatrixFromFile("src/TSPMap.txt");
        reader.readMatrix();
        int[][] map = reader.getResultMatrix();
        this.map_size = reader.getSize();

        for(int i = 0; i < map_size; i++){
            for(int j = 0; j < map_size; j++){
                System.out.printf("%d  ", map[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public TSPState initiallState() {
        int[] initial_path = new int[map_size];
        for(int i = 0; i < map_size; i++){
            initial_path[i] = i;
        }
        TSPState initial_state = new TSPState(initial_path);
        return initial_state;
    }

    @Override
    public Vector<TSPAction> actions(TSPState state) {
        Vector<TSPAction> actions = new Vector<>(0);

        for(int i = 0; i < map_size; i++) {
            for(int j = i+1; j < map_size; j++){
                actions.addElement(new TSPAction(i, j));
            }
        }
        return actions;
    }

    @Override
    public TSPState result(TSPState state, TSPAction action) {
        int[] cur_path = state.getPath();
        int city_i = action.getCity_i();
        int city_j = action.getCity_j();
        int size = cur_path.length;
        int[] next_path = new int[size];
        for(int i = 0; i <size; i++){
            next_path[i] = cur_path[i];
        }
        next_path[city_i] = cur_path[city_j];
        next_path[city_j] = cur_path[city_i];

        TSPState next_state = new TSPState(next_path);
        return next_state;
    }

    @Override
    public boolean goal(TSPState state) {
        return false;
    }

    public static void main(String[] args) {
        TSP TSPProblem = new TSP();

        HillClimbing<TSPState, TSPAction> hillClimbing = new HillClimbing<>(TSPProblem);

//        hillClimbing.first_choice();
         hillClimbing.simple();
//         hillClimbing.Stochastic();
//         hillClimbing.random_restart();

//        SimulatedAnnealing<TSPState, TSPAction> simulatedAnnealing;
//        simulatedAnnealing = new SimulatedAnnealing<>(TSPProblem);
//        simulatedAnnealing.search(1);// the input value is for choosing the simulatedAnnealing method from 0,1,2
    }

    @Override
    public void print(TSPState state) {
        for (int i = 0; i < state.getPath().length; i++)
            System.out.print(state.getPath()[i] + "\t");
        System.out.println();
    }

    @Override
    public double objective_function(TSPState state) {
        if(state != null) {
            int[] cur_path = state.getPath();
            int result = 0;

            for (int i = 0; i < cur_path.length - 1; i++) {
                result += map[cur_path[i]][cur_path[i + 1]];
            }
            return result;
        } else {
            return 0;
        }
    }

    @Override
    public TSPState randomState() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random randomGenerator = new Random();

        while (numbers.size() < map_size) {
            int random = randomGenerator .nextInt(map_size);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        int[] path = new int[map_size];
        for(int i = 0; i < map_size; i++){
            path[i] = numbers.get(i);
        }

        TSPState result = new TSPState(path);
        return result;
    }

    @Override
    public TSPState crossOver(TSPState x, TSPState y) {
        return null;
    }

    @Override
    public TSPState mutation(TSPState x) {
        return null;
    }
}

class TSPState {

    private int[] path;

    public TSPState(int[] path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object arg0) {
        TSPState other = (TSPState) arg0;
        for (int i = 0; i < other.path.length; i++) {
            if (path[i] != other.path[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] getPath() {
        return path;
    }
}

class TSPAction {
    private int city_i;
    private int city_j;

    public TSPAction(int city_i, int city_j) {
        this.city_i = city_i;
        this.city_j = city_j;
    }

    public int getCity_i() {
        return city_i;
    }

    public int getCity_j() {
        return city_j;
    }
}