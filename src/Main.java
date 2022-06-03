public class Main {
    public static void main(String[] args) {
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
        System.out.println("\n");
        for (int i = 0; i < numList.length; i++) {
            System.out.println(numList[i]);
        }
        System.out.println("\n");


        BstDup<String> nameTree = new BstDup<>();
        String[] nameList;
        nameTree.add("James");
        nameTree.add("Kid");
        nameTree.add("Hanna");
        nameTree.add("Abe");
        nameTree.add("Ingrid");
        nameTree.add("Maria");
        nameTree.add("Kaleb");
        nameTree.delete("Hanna");
        nameList = nameTree.getAllDataInOrder(new String[0]);
        System.out.println("\n");
        for (int i = 0; i < nameList.length; i++) {
            System.out.println(nameList[i]);
        }

    }
}
