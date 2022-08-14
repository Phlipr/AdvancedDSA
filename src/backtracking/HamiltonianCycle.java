package backtracking;

public class HamiltonianCycle {
    private int[][] graph;
    private int[] path;
    private int numOfVertices;

    public HamiltonianCycle(int[][] graph) {
        this.graph = graph;
        this.numOfVertices = graph[0].length;
        this.path = new int[numOfVertices];
    }

    public void solve() {
        this.path[0] = 0;

        if (solveProblem(1)) {
            this.showSolution();
        } else {
            System.out.println("There is no valid Hamiltonian cycle for this graph.");
        }
    }

    private boolean solveProblem(int vertex) {
        // base-case: have considered all vertices
        if (vertex == this.numOfVertices) {
            // if last vertex in path can reach initial vertex: hamiltonian cycle has been found
            if (this.graph[this.path[vertex - 1]][this.path[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }

        // check for next vertex in path by checking all neighbors of vertex
        for (int currNeighbor = 1; currNeighbor < this.numOfVertices; currNeighbor++) {
            // check if currNeighbor is a valid vertex to place in the path
            if (isInValidPath(currNeighbor, vertex)) {
                this.path[vertex] = currNeighbor;

                if (solveProblem(vertex + 1)) {
                    return true;
                }
            }

            // otherwise, backtrack;
        }

        return false;
    }

    private boolean isInValidPath(int currNeighbor, int vertex) {
        // two conditions for vertex to be valid path vertex:
        // 1. must be a neighbor of the last vertex in the path
        if (this.graph[this.path[vertex - 1]][currNeighbor] == 0) {
            return false;
        }

        // 2. must not already be in the path
        for (int i = 0; i < vertex; i++) {
            if (this.path[i] == currNeighbor) {
                return false;
            }
        }

        return true;
    }

    private void showSolution() {
        System.out.println();
        System.out.println("Hamiltonian cycle:");
        for (int i = 0; i < this.path.length; i++) {
            System.out.print(this.path[i] + "-> ");
        }
        System.out.println("0");
    }
}
