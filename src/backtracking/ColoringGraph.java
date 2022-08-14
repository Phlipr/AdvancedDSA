package backtracking;

public class ColoringGraph {
    private int numOfColors;
    private int numOfVertices;
    private int[] colors;
    private int[][] graph;

    public ColoringGraph(int[][] graph, int numOfColors) {
        this.graph = graph;
        this.numOfColors = numOfColors;
        this.numOfVertices = graph[0].length;
        this.colors = new int[numOfVertices];
    }

    public void solve() {
        if (solveProblem(0)) {
            this.showSolution();
        } else {
            System.out.println("There is no way to color this graph with only " + this.numOfColors + " colors.");
        }
    }

    private boolean solveProblem(int nodeIndex) {
        // base case: all nodes have been assigned a color
        if (nodeIndex == this.numOfVertices) {
            return true;
        }

        for (int color = 1; color <= numOfColors; color++) {
            if (isValidColor(nodeIndex, color)) {
                this.colors[nodeIndex] = color;

                if (solveProblem(nodeIndex + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValidColor(int nodeIndex, int color) {
        // color is only valid if no other neighbors have the same color
        for (int neighbor = 0; neighbor < numOfVertices; neighbor++) {
            if (this.graph[neighbor][nodeIndex] == 1 && this.colors[neighbor] == color) {
                return false;
            }
        }

        return true;
    }

    private void showSolution() {
        for (int i = 0; i < numOfVertices; i++) {
            System.out.println("Node " + (i + 1) + " has color index " + this.colors[i]);
        }
    }
}
