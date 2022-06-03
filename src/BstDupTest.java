import static org.junit.jupiter.api.Assertions.*;

class BstDupTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testMethods() {
        BstDup<Integer> ageTree = new BstDup<>();
        Integer[] numList;
        ageTree.add(10);
        ageTree.add(13);
        ageTree.add(8);
        ageTree.add(14);
        ageTree.add(5);
        ageTree.add(7);
        ageTree.add(11);
        ageTree.delete(13);
        ageTree.delete(14);
        numList = ageTree.getAllDataInOrder(new Integer[0]);
        assertEquals(10,numList[3]);
        assertEquals(11,numList[4]);
    }


}