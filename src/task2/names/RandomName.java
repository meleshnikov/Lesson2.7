package task2.names;


import java.util.Random;


public final class RandomName {
    static final Random random = new Random();

    public static int generateRandomInt(int min, int max) {
        max++;
        max -= min;
        return random.nextInt(max) + min;
    }

    public static String getRandomName(String[] names) {
        int index = generateRandomInt(0, names.length - 1);
        return names[index];
    }

}
