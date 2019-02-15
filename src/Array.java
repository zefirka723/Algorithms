public interface Array  <E extends Comparable<?super E>>{



    // Удаление
    boolean remove(E value);
    void remove(int index);

    // Добавление
    void add(E value);

    // Поиск
    boolean contains(E value);
    int indexOf(E value);

    //Сортировки
    void sortBubble();
    void sortSelection();
    void sortInsert();

    int getSize();
}
