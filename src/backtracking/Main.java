package backtracking;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        NQueens nqueen1 = new NQueens(8);
//        nqueen1.solve();

        int[][] graph = {
                {0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0}
        };

//        HamiltonianCycle hamilton1 = new HamiltonianCycle(graph);
//        hamilton1.solve();
        ColoringGraph colorGraph = new ColoringGraph(graph, 4);
        colorGraph.solve();
    }
}
