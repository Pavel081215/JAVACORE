// highArray.java
// Класс массива с высокоуровневым интерфейсом
// Запуск программы: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray {
    private long[] a;                 // Ссылка на массив a
    private int nElems;               // Количество элементов в массиве

    //-----------------------------------------------------------
    public HighArray(int max)         // Конструктор
    {
        a = new long[max];             // Создание массива
        nElems = 0;                    // Пока нет ни одного элемента
    }

    //-----------------------------------------------------------
    public boolean find(long searchKey) {                              // Поиск заданного значения
        int j;
        for (j = 0; j < nElems; j++)        // Для каждого элемента
            if (a[j] == searchKey)       // Значение найдено?
                break;                   // Да - выход из цикла
        if (j == nElems)                // Достигнут последний элемент?
            return false;               // Да
        else
            return true;                // Нет
    }

    //-----------------------------------------------------------
    public void insert(long value)    // Вставка элемента в массив
    {
        a[nElems] = value;             // Собственно вставка
        nElems++;                      // Увеличение размера
    }

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)        // Поиск заданного значения
            if (value == a[j])
                break;
        if (j == nElems)                  // Найти не удалось
            return false;
        else                           // Значение найдено
        {
            for (int k = j; k < nElems; k++) // Сдвиг последующих элементов
                a[k] = a[k + 1];
            nElems--;                   // Уменьшение размера
            return true;
        }
    }

    //-----------------------------------------------------------
    public void display()             // Вывод содержимого массива
    {
        for (int j = 0; j < nElems; j++)    // Для каждого элемента
            System.out.print(a[j] + " ");  // Вывод
        System.out.println("");
    }

    //-----------------------------------------------------------
    public void getMax() {

        if (nElems == 0) {
            System.out.println("Max = is not " + -1);
        } else {
            long max = a[0];
            for (int i = 0; i < nElems; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            System.out.println("Max =" + max);
        }
    }

    //-----------------------------------------------------------

    public long removeMax() {
        long max = a[0];
        if (nElems == 0) {
            System.out.println("Max = is not " + -1);
        } else {
            int maxIndex = 0;

            for (int i = 0; i < nElems; i++) {
                if (a[i] > max) {
                    max = a[i];
                    maxIndex = i;
                }
            }
            //  System.out.println("Max = index" + maxIndex);
            for (int j = maxIndex; j < nElems; j++) {
                a[j] = a[j + 1];
            }
            nElems = nElems - 1;
        }
        return max;
    }

    //-----------------------------------------------------------
    public void deleteIndex(int value) {
        for (int k = value; k < nElems; k++) { // Сдвиг последующих элементов
            a[k] = a[k + 1];
        }
        System.out.println("Удален 1 объект" + value);
        nElems--;                   // Уменьшение размера
    }

    //-----------------------------------------------------------
    public int size() {
        return nElems;
    }

    //-----------------------------------------------------------
    public void noDups() {
        for (int i = 0; i < nElems; i++) {
            for (int j =i+1; j < nElems; j++) {
                if (a[i] == a[j]) {
                    deleteIndex(j);

                }
            }
        }

    }
    //-----------------------------------------------------------

}  // Конец класса HighArray

////////////////////////////////////////////////////////////////
class HighArrayApp {
    public static void HighArrayAppMain(String[] args) {
        int maxSize = 100;            // Размер массива

        HighArray arr;                // Ссылка на массив
        arr = new HighArray(maxSize); // Создание массива
        arr.insert(22);               // Вставка 10 элементов
        arr.insert(99);
        arr.insert(44);
        arr.insert(898);
        arr.insert(22);
        arr.insert(88);
        arr.insert(22);
        arr.insert(00);
        arr.insert(66);
        arr.insert(22);
        arr.display();


        arr.noDups();
        arr.display();

    }
}  // Конец класса HighArrayApp
////////////////////////////////////////////////////////////////