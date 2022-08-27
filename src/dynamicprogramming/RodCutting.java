package dynamicprogramming;

public class RodCutting {
    private int rodLength;
    private int[] prices;
    int[][] solutions;

    public RodCutting(int rodLength, int[] prices) {
        this.rodLength = rodLength;
        this.prices = prices;

        // initialize dynamic programming table to have base cases of
        // when rodLength = 0 and when prices = 0
        this.solutions = new int[prices.length+1][rodLength+1];
    }

    public void findSolution() {
        for (int priceIdx = 1; priceIdx < this.prices.length; priceIdx++) {
            for (int currRodLength = 1; currRodLength < this.rodLength + 1  ; currRodLength++) {
                if (priceIdx <= currRodLength) {
                    this.solutions[priceIdx][currRodLength] = Math.max(this.solutions[priceIdx-1][currRodLength], this.prices[priceIdx] + this.solutions[priceIdx][currRodLength - priceIdx]);
                } else {
                    this.solutions[priceIdx][currRodLength] = this.solutions[priceIdx - 1][currRodLength];
                }
            }
        }
    }

    public void showSolution() {
        System.out.println("The maximum profit is $" + this.solutions[this.prices.length-1][this.rodLength]);

        int priceIdx = this.prices.length - 1;
        int currLength = this.rodLength;

        while (priceIdx > 0 && currLength > 0) {
            if (this.solutions[priceIdx][currLength] != 0 && this.solutions[priceIdx][currLength] != this.solutions[priceIdx - 1][currLength]) {
                System.out.println("Rod length to include: " + priceIdx + " m");
                currLength = currLength - priceIdx;
            } else {
                priceIdx--;
            }
        }
    }

    public static void main(String[] args) {
        int rodLength = 5;
        int[] prices = {0, 2, 5, 7, 3, 5};

        RodCutting rodCutting = new RodCutting(rodLength, prices);
        rodCutting.findSolution();
        rodCutting.showSolution();
    }
}
