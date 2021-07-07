import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        int maxTreeLevel = 4; // уровни дерева
        int treeCount = 20; // кол-во деревьев
        int maxTreeValue = 100; // максимальное число в дереве
        int maxNodeCount = (int) (Math.pow(2, maxTreeLevel) - 1);
        int imbalancedTreeCount = 0; // счётчик несбалансированных деревьев

        // Создаём деревья
        for (int i = 0; i < treeCount; i++) {
            Tree tree = new TreeImpl(maxTreeLevel);
            for (int j = 0; j < maxNodeCount ; j++) {
                tree.add(new Random().nextInt(maxTreeValue * 2 + 1) - maxTreeValue);
            }
            if(!tree.isBalanced()) {
                imbalancedTreeCount++;
            }
        }

        // Считаем
        System.out.println("Несбалансированных деревьев: "
                + imbalancedTreeCount + " из " + treeCount
                + " (" + (imbalancedTreeCount * 100 / treeCount) + "%)");


    }



}
