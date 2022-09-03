package interviewquestions;

public class Main {

    public static void main(String[] args) {
//        int numEggs = 10;
//        int numFloors = 100000;
//
//        EggDrop eggDrop = new EggDrop(numEggs, numFloors);
//
//        System.out.println("It will take " + eggDrop.solve() + " egg drops with " + numEggs + " eggs and " + numFloors + " floors.");

        int[] arrayToSort = {0, 0, 2, 2, 0, 1, 1, 0, 2, 1, 0, 1};
        int pivot = 1;

        DutchFlagProblem problem = new DutchFlagProblem(arrayToSort, pivot);
        problem.solveProblem();
    }
}
