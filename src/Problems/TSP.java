package Problems;

import java.util.Vector;

import algorithmes.HillClimbing;
import algorithmes.SimulatedAnnealing;

public class TSP extends Problem<TSPState, TSPAction> {

    public TSP() {

    }

    @Override
    public TSPState initiallState() {
        return null;
    }

    @Override
    public Vector<TSPAction> actions(TSPState state) {
        return null;
    }

    @Override
    public TSPState result(TSPState state, TSPAction action) {
        return null;
    }

    @Override
    public boolean goal(TSPState state) {
        return true;
    }

    public static void main(String[] args) {

    }

    @Override
    public void print(TSPState state) {

    }

    @Override
    public double objective_function(TSPState state) {
        return 0;
    }

    @Override
    public TSPState randomState() {
        return null;
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

    public TSPState() {

    }

    @Override
    public boolean equals(Object arg0) {

        return true;
    }
}

class TSPAction {
    public TSPAction() {

    }
}