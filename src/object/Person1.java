package object;
// objectSort.java
// Сортировка объектов (с применением сортировки методом вставки)
// Запуск программы: C>java ObjectSortApp
////////////////////////////////////////////////////////////////
class Person1 {
    private String lastName;
    private String firstName;
    private int age;

    //-----------------------------------------------------------
    public Person1(String last, String first, int a) {                               // Конструктор
        lastName = last;
        firstName = first;
        age = a;
    }

    //-----------------------------------------------------------
    public void displayPerson() {
        System.out.print("   Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }

    //-----------------------------------------------------------
    public String getLast()           // Получение фамилии
    {
        return lastName;
    }
}  // Конец класса Person

////////////////////////////////////////////////////////////////
class ArrayInOb {
    private Person1[] a;               // Ссылка на массив aСортировка объектов    113
    private int nElems;               // Количество элементов данных

    //--------------------------------------------------------------
    public ArrayInOb(int max)         // Конструктор
    {
        a = new Person1[max];           // Создание массива
        nElems = 0;                    // Пока нет ни одного элемента
    }

    //--------------------------------------------------------------
    // Включение записи в массив
    public void insert(String last, String first, int age) {
        a[nElems] = new Person1(last, first, age);
        nElems++;                          // Увеличение размера
    }

    //--------------------------------------------------------------
    public void display()                // Вывод содержимого массива
    {
        for (int j = 0; j < nElems; j++)       // Для каждого элемента
            a[j].displayPerson();          // Вывод
        System.out.println("");
    }

    //--------------------------------------------------------------
    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++)  // out - разделительный маркер
        {
            Person1 temp = a[out];       // Скопировать помеченный элемент
            in = out;                   // Начать перемещения с out
            while (in > 0 &&               // Пока не найден меньший элемент
                    a[in - 1].getLast().compareTo(temp.getLast()) > 0) {
                a[in] = a[in - 1];         // Сдвинуть элемент вправо
                --in;                    // Перейти на одну позицию влево
            }
            a[in] = temp;               // Вставить помеченный элемент
        }
    }
//--------------------------------------------------------------
}  // Конец класса ArrayInOb

////////////////////////////////////////////////////////////////
class ObjectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;             // Размер массива
        ArrayInOb arr;                 // Ссылка на массив

        arr = new ArrayInOb(maxSize);  // Создание массива
        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);
        System.out.println("Before sorting:");
        arr.display();                 // Вывод содержимого
        arr.insertionSort();           // Сортировка методом вставки
        System.out.println("After sorting:");
        arr.display();                 // Повторный вывод
    }
}  // Конец класса ObjectSortApp
////////////////////////////////////////////////////////////////