import linkedList.*;
import linkedList.twoside.LinkedQueueImpl;


public class MainTest {

    public static void main(String[] args) {

        // Проверки для LinkedStackImpl
        LinkedStackImpl<Integer> linkedStack = new LinkedStackImpl<>();
        System.out.println("isEmpty? " + linkedStack.isEmpty()); // должно вернуть true
        System.out.println("isFull? " + linkedStack.isFull()); // всегда false
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        System.out.println("size = " + linkedStack.size()); // должно быть 4
        System.out.println("peek = " + linkedStack.peek()); // ожидаем 1
        System.out.println("pop = " + linkedStack.pop()); // удаляем последний (4)
        System.out.println("size = " + linkedStack.size()); // должно стать 3

        // Проверки для LinkedQueueImpl
        LinkedQueueImpl<Integer> linkedQueue = new LinkedQueueImpl<>();
        System.out.println("isEmpty? " + linkedQueue.isEmpty()); // должно вернуть true
        System.out.println("isFull? " + linkedQueue.isFull()); // всегда false
        linkedQueue.insert(1);
        linkedQueue.insert(2);
        linkedQueue.insert(3);
        linkedQueue.insert(4);
        linkedQueue.insert(5);
        System.out.println("size = " + linkedQueue.size()); // должно быть 5
        System.out.println("peek = " + linkedQueue.peek()); // ожидаем 1
        System.out.println("remove = " + linkedQueue.remove()); // удаляем (1)
        System.out.println("size = " + linkedQueue.size()); // должно стать 3


    }
}
