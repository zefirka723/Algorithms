import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> rootNode;
    private int maxLevel;

    public TreeImpl(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public TreeImpl() {
        this(0);
    }

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (isEmpty()) { // дерево пустое
            rootNode = newNode;
            rootNode.setLevel(1);
            return;
        }
        Node<E> current = rootNode;
        Node<E> previous = null;
        // Ищем, где должен быть элемент
        while (current != null) {
            previous = current;
            if (current.getValue().equals(value)) {
                return;
            }
            if (current.shouldLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        // Проверяем, можно ли добавить новый элемент на полученный уровень
        newNode.setLevel(previous.getLevel() + 1);
        if (newNode.getLevel() > maxLevel) {
            return;
        }
        // Добавляем новый элемент
        if (previous.shouldLeftChild(value)) {
            previous.setLeftChild(newNode);
        } else {
            previous.setRightChild(newNode);
        }
    }


    @Override
    public boolean remove(E value) {
        Node<E> current = rootNode;
        Node<E> parent = null;
        while (current != null) {
            if (current.getValue().equals(value)) {
                break;
            }
            parent = current;
            if (current.shouldLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        if (current == null) { // элемент не найден
            return false;
        }
        if (isLeaf(current)) { // элемент - лист?
            if (current == rootNode) {
                rootNode = null;
            } else if (parent.getLeftChild() != null && parent.getLeftChild().equals(current)) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }

        } else if (hasOnlySingleChildElement(current)) { // только 1 потомок?
            Node<E> childNode = current.getLeftChild() != null
                    ? current.getLeftChild()
                    : current.getRightChild();
            if (current == rootNode) {
                rootNode = childNode;
            } else if (parent.getLeftChild() != null && parent.getLeftChild().equals(current)) {
                parent.setLeftChild(childNode);
            } else {
                parent.setRightChild(childNode);
            }
        } else { // 2 потомка
            Node<E> successor = getSuccessor(current);
            if (current == rootNode) {
                rootNode = successor;
            } else if (parent.getLeftChild() != null && parent.getLeftChild().equals(current)) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        return false;
    }


    // Поиск подходящего элемента на место удаляемого, имеющего 2 потомка
    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }
        return successor;
    }


    private boolean hasOnlySingleChildElement(Node<E> current) {
        return current.getLeftChild() == null || current.getRightChild() == null;
    }


    private boolean isLeaf(Node<E> current) {
        return current.getLeftChild() == null && current.getRightChild() == null;
    }


    @Override
    public boolean find(E value) {
        Node<E> current = rootNode;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            if (current.shouldLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return rootNode == null;
    }

    @Override
    public void traverse(TraverseMode traverseMode) {
        switch (traverseMode) {
            case IN_ORDER:
                inOrder(rootNode);
                break;
            case PRE_ORDER:
                preOrder(rootNode);
                break;
            case POST_ORDER:
                postOrder(rootNode);
                break;
            default:
                throw new IllegalArgumentException("Режим не определён: " + traverseMode);
        }
    }

    private void inOrder(Node<E> node) {
        if (node == null)
            return;

        inOrder(node.getLeftChild());
        System.out.println(node);
        inOrder(node.getRightChild());
    }

    private void preOrder(Node<E> node) {
        if (node == null)
            return;

        System.out.println(node);
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    private void postOrder(Node<E> node) {
        if (node == null)
            return;

        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.println(node);
    }


    public boolean isBalanced() {
        return isBalanced(rootNode);
    }

    private boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}

