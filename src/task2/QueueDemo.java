package task2;

import task2.names.Names;
import task2.names.RandomName;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class QueueDemo {

    public static List<Queue<String>> queues = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            queues.add(SupermarketQueue.generateRandom());
        }

        queues.forEach(System.out::println);
        printDelimiter();

        while (SupermarketQueue.addToFreeQueue("+" + RandomName.getRandomName(Names.getFemaleLastNames()), queues)) {
            queues.forEach(System.out::println);
            printDelimiter();
        }

        while (!queues.isEmpty()) {
            SupermarketQueue.removeFromRandomQueue(queues);
            queues.forEach(System.out::println);
            printDelimiter();
        }

    }

    private static void printDelimiter() {
        System.out.println("___________________________________________________________");
    }
}
