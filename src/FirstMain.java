


public class FirstMain {

    public static void FirstMainmain(String[] args) {
        // System.out.println("Hello World!");
////        /**
//         * Это первый пример программы в главе 3 данного тома
//         * @version 1.0. 1997-03-22
//         */
////        int d = 2147483647;
//        short f = 32767;
//        long j = 9223372036854775807l;
//        byte b = 127;
//        float v = 5.464F;
//        double k = 7.780707078989;
//        char c = 'h';
//       boolean t = true;
////        System.out.println(Character.isJavaIdentifierPart(55555));




        {
            long[] arr;                  // Ссылка на массив
            arr = new long[100];         // Создание массива
            int nElems = 0;              // Количество элементов
            int j;                       // Счетчик цикла
            long searchKey;              // Ключи искомого элемента
//--------------------------------------------------------------
            arr[0] = 77;                 // Вставка 10 элементов
            arr[1] = 99;
            arr[2] = 44;
            arr[3] = 55;
            arr[4] = 22;
            arr[5] = 88;
            arr[6] = 11;
            arr[7] = 00;
            arr[8] = 66;
            arr[9] = 33;
            arr[10] = 133;
            nElems = 11;                 // Массив содержит 10 элементов
//--------------------------------------------------------------
            for (j = 0; j < nElems; j++)      // Вывод элементов
                System.out.print(arr[j] + " ");
            System.out.println("");
//--------------------------------------------------------------
            searchKey = 67;              // Поиск элемента с ключом 66
            for (j = 0; j < nElems; j++)          // Для каждого элемента
                if (arr[j] == searchKey)       // Значение найдено?
                    break;                     // Да - выход из цикла
            if (j == nElems)                  // Достигнут последний элемент?
                System.out.println("Can't find " + searchKey); // Да
            else
                System.out.println("Found " + searchKey);      // Нет
//--------------------------------------------------------------
            searchKey = 55;                     // Удаление элемента с ключом 55
            for (j = 0; j < nElems; j++)             // Поиск удаляемого элемента
                if (arr[j] == searchKey)
                    break;
            for (int k = j; k < nElems - 1; k++)       // Сдвиг последующих элементов
                arr[k] = arr[k + 1];
            nElems--;                           // Уменьшение размера
//--------------------------------------------------------------
            for (j = 0; j < nElems; j++)             // Вывод элементов
                System.out.print(arr[j] + " ");
            System.out.println("");
        }


    }
}
