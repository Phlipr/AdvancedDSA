package interviewquestions.tests;

import interviewquestions.EggDrop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EggDropTest {

    private EggDrop eggDropProblem;

    @BeforeEach
    public void setUpEggDropProblem() {
        this.eggDropProblem = new EggDrop(2, 100);
    }

    @Test
    public void testEggDrop() {
        int eggDrops = this.eggDropProblem.solve();

        assertEquals(14, eggDrops);
    }
}
