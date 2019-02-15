import java.util.concurrent.TimeUnit;

public class hw {

    public static void main(String[] args) {
        int testSize = 1000000;
        ArrayImpl<Integer> arr = new ArrayImpl(testSize);
        for (int i = 0; i < testSize - 1; i++) {
            arr.add((int) Math.random() * 100);
        }

        System.out.println("Сортировка пузырьком:");
        ArrayImpl<Integer> testCopy = arr;
        long startTime = System.nanoTime();
        testCopy.sortBubble();
        System.out.println("Время выполнения: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));

        System.out.println("Сортировка выбором:");
        testCopy = arr;
        startTime = System.nanoTime();
        testCopy.sortSelection();
        System.out.println("Время выполнения: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));

        System.out.println("Сортировка вставкой:");
        startTime = System.nanoTime();
        arr.sortInsert();
        System.out.println("Время выполнения: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));
    }
}
