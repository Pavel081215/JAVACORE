// highArray.java
// ����� ������� � ��������������� �����������
// ������ ���������: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray {
    private long[] a;                 // ������ �� ������ a
    private int nElems;               // ���������� ��������� � �������

    //-----------------------------------------------------------
    public HighArray(int max)         // �����������
    {
        a = new long[max];             // �������� �������
        nElems = 0;                    // ���� ��� �� ������ ��������
    }

    //-----------------------------------------------------------
    public boolean find(long searchKey) {                              // ����� ��������� ��������
        int j;
        for (j = 0; j < nElems; j++)        // ��� ������� ��������
            if (a[j] == searchKey)       // �������� �������?
                break;                   // �� - ����� �� �����
        if (j == nElems)                // ��������� ��������� �������?
            return false;               // ��
        else
            return true;                // ���
    }

    //-----------------------------------------------------------
    public void insert(long value)    // ������� �������� � ������
    {
        a[nElems] = value;             // ���������� �������
        nElems++;                      // ���������� �������
    }

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)        // ����� ��������� ��������
            if (value == a[j])
                break;
        if (j == nElems)                  // ����� �� �������
            return false;
        else                           // �������� �������
        {
            for (int k = j; k < nElems; k++) // ����� ����������� ���������
                a[k] = a[k + 1];
            nElems--;                   // ���������� �������
            return true;
        }
    }

    //-----------------------------------------------------------
    public void display()             // ����� ����������� �������
    {
        for (int j = 0; j < nElems; j++)    // ��� ������� ��������
            System.out.print(a[j] + " ");  // �����
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
    public int size() {
        return nElems;
    }

    //-----------------------------------------------------------
}  // ����� ������ HighArray

////////////////////////////////////////////////////////////////
class HighArrayApp {
    public static void HighArrayAppMain(String[] args) {
        int maxSize = 100;            // ������ �������

        HighArray arr;                // ������ �� ������
        arr = new HighArray(maxSize); // �������� �������
        arr.insert(7);               // ������� 10 ���������
        arr.insert(99);
        arr.insert(44);
        arr.insert(898);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(11);
        arr.display();

        HighArray arr2 = new HighArray(maxSize);
        int sizeArr = arr.size();

        for (int i = 0; i < sizeArr; i++) {
            arr2.insert(arr.removeMax());
        }

        arr2.display();
    }
}  // ����� ������ HighArrayApp
////////////////////////////////////////////////////////////////