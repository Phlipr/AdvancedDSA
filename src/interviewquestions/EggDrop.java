package interviewquestions;

public class EggDrop {
    private int numEggs;
    private int numFloors;
    private int[][] subSolutions;

    public EggDrop(int numEggs, int numFloors) {
        this.numEggs = numEggs;
        this.numFloors = numFloors;

        // initialize the subSolutions table
        // rows = number of eggs
        // columns = number of floors
        this.subSolutions = new int[numEggs + 1][numFloors + 1];

        // initialize row 1 of table
        // row 1 represents number of drops if you only have one egg to test
        // with only 1 egg, you must do a linear search with the drops
        // this means the worst-case scenario would be that you check every floor and the egg breaks
        // on the last one
        // Therefore, number of required drops = number of floors
        for (int i = 0; i < numFloors + 1; i++) {
            this.subSolutions[1][i] = i;
        }

        // initialize column 1 of table
        // in this case, you only have one floor, so it will only take 1 drop
        for (int i = 0; i < numEggs + 1; i++) {
            this.subSolutions[i][1] = 1;
        }
    }

    public int solve() {
        for (int currEggNum = 2; currEggNum <= this.numEggs; currEggNum++) {
            for (int currMaxFloor = 2; currMaxFloor <= this.numFloors; currMaxFloor++) {
                this.subSolutions[currEggNum][currMaxFloor] = Integer.MAX_VALUE;

                for (int currFloor = 1; currFloor <= currMaxFloor; currFloor++) {
                    // determine worst-case scenario for number of drops
                    // two cases:
                    // Case 1: The egg broke when dropped from the floor, and you have to consider the case with
                    //          currEggNum - 1 and currMaxFloor - 1
                    // Case 2: The egg did not break when dropped, and you have to consider
                    //          the floors numFloors - currFloor with currNumEggs
                    // you need to take the max drops from these two cases + the current drop
                    int maxDrops = 1 + Math.max(this.subSolutions[currEggNum - 1][currFloor - 1],
                            this.subSolutions[currEggNum][currMaxFloor - currFloor]);

                    // update the number of drops
                    if (maxDrops < this.subSolutions[currEggNum][currMaxFloor]) {
                        this.subSolutions[currEggNum][currMaxFloor] = maxDrops;
                    }
                }
            }
        }

        return this.subSolutions[this.numEggs][this.numFloors];
    }
}
