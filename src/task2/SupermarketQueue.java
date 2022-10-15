package task2;

import task2.names.Names;
import task2.names.RandomName;

import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;


public class SupermarketQueue {

    private static final Random random = new Random();

    private static final int MAX_SIZE = 5;

    public static Queue<String> generateRandom() {
        int size = random.nextInt(MAX_SIZE + 1);
        Queue<String> queue = new ArrayBlockingQueue<>(MAX_SIZE);
        for (int i = 0; i < size; i++) {
            queue.offer(RandomName.getRandomName(Names.getMaleLastNames()));
        }
        return queue;
    }

    @SafeVarargs
    private static int getLessFilledQueue(Queue<String>... queues) {
        int minSize = MAX_SIZE;
        int index = -1;

        for (int i = 0; i < queues.length; i++) {
            if (queues[i] != null) {
                if (minSize > queues[i].size()) {
                    minSize = queues[i].size();
                    index = i;
                }
            }
        }

        return index;
    }

    private static int getLessFilledQueue(List<Queue<String>> queues) {
        int minSize = MAX_SIZE;
        int index = -1;

        for (int i = 0; i < queues.size(); i++) {
            if (queues.get(i) != null) {
                if (minSize > queues.get(i).size()) {
                    minSize = queues.get(i).size();
                    index = i;
                }
            }
        }

        return index;
    }


    @SafeVarargs
    public static boolean addToFreeQueue(String item, Queue<String>... queues) {

        int index = getLessFilledQueue(queues);

        if (index < 0) {
            System.out.println("Нужно вызвать Галю");
            return false;
        }

        queues[index].offer(item);

        return true;
    }

    public static boolean addToFreeQueue(String item, List<Queue<String>> queues) {

        int index = getLessFilledQueue(queues);

        if (index < 0) {
            System.out.println("Нужно вызвать Галю");
            return false;
        }

        queues.get(index).offer(item);

        return true;
    }

    @SafeVarargs
    public static boolean removeFromRandomQueue(Queue<String>... queues) {

        int index = random.nextInt(queues.length);

        Queue<String> q = queues[index];

        if (q == null || q.isEmpty()) {
            return false;
        } else {
            q.poll();
            return true;
        }
    }

    public static boolean removeFromRandomQueue(List<Queue<String>> queues) {

        if (queues.isEmpty()) {
            return false;
        }

        int index = random.nextInt(queues.size());

        Queue<String> q = queues.get(index);

        if (q == null || q.isEmpty()) {
            queues.remove(index);
            removeFromRandomQueue(queues);
        } else {
            q.poll();
            return true;
        }

        return false;
    }

}
