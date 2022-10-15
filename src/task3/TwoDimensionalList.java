package task3;

import java.util.ArrayList;
import java.util.List;

public class TwoDimensionalList {

    private static final List<List<String>> biDemArrList = new ArrayList<>();

    private static final int HEIGHT = 8;
    private static final int WIDTH = 8;

    public static void main(String[] args) {
        example();
    }

    private static void example() {

        for (int i = 0; i < HEIGHT; i++) {
            biDemArrList.add(i, new ArrayList<>());
            for (int j = 0; j < WIDTH; j++) {
                biDemArrList.get(i).add(j, (i + j) % 2 == 1 ? "◯" : "●");
            }
        }

        for (List<String> line : biDemArrList) {
            for (String element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }


}
