// orderedArray.java
// ������ � ������� �������������� �������
// ������ ���������: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray {
    private long[] a;                 // ������ �� ������ a
    private int nElems;               // ���������� ��������� ������

    //-----------------------------------------------------------
    public OrdArray(int max)          // �����������
    {
        a = new long[max];             // �������� �������
        nElems = 0;
    }
    //-----------------------------------------------------------

    public int size() {
        return nElems;
    }

    //-----------------------------------------------------------
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;              // ������� ������
            else if (lowerBound > upperBound)
                return nElems;             // ������� �� ������
            else                          // ������� ���������
            {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; // � ������� ��������
                else
                    upperBound = curIn - 1; // � ������ ��������
            }
        }
    }

    //-----------------------------------------------------------
    public void insert(long value)    // ������� �������� � ������
    {
        int j;
        for (j = 0; j < nElems; j++)        // ����������� ������� �������
            if (a[j] > value)            // (�������� �����)
                break;
        for (int k = nElems; k > j; k--)    // ����������� ����������� ���������
            a[k] = a[k - 1];
        a[j] = value;                  // �������
        nElems++;                      // ���������� �������
    }

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems)                  // ����� �� �������
            return false;
        else                           // ������� ������
        {
            for (int k = j; k < nElems; k++) // ����������� ����������� ���������
                a[k] = a[k + 1];
            nElems--;                   // ���������� ����������������� �������������� ������� �� ����� Java    71
            return true;
        }
    }

    //-----------------------------------------------------------
    public void display()             // ����� ����������� �������
    {
        for (int j = 0; j < nElems; j++)       // ������� ���� ���������
            System.out.print(a[j] + " ");  // ����� �������� ��������
        System.out.println("");
    }

    //-----------------------------------------------------------
    public long get(int index) {
        return a[index];
    }

    //-----------------------------------------------------------
    public OrdArray mergeTemp(OrdArray a, OrdArray b) {
        OrdArray new1 = new OrdArray(a.size());
        for (int i = 0; i < a.size(); i++) {
            if (i > b.size() - 1) {
                new1.insert(a.get(i));
            } else {
                if (a.get(i) >= b.get(i)) {
                    new1.insert(a.get(i));
                } else {
                    new1.insert(b.get(i));
                }
            }
        }

        return new1;
    }
    //-----------------------------------------------------------
    public OrdArray merge(OrdArray b) {

        if (b.size() < size()) {
            return mergeTemp(this, b);
        } else {
            return mergeTemp(b, this);
        }

    }

    //-----------------------------------------------------------
}
////////////////////////////////////////////////////////////////
class OrderedApp {
    public static void OrderedAppMain(String[] args) {
        int maxSize = 10;
        int maxSize1 = 25;
        OrdArray arr = new OrdArray(maxSize);
        OrdArray arr1 = new OrdArray(maxSize1);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);


        arr1.insert(5);
        arr1.insert(6);
        arr1.insert(7);
        arr1.insert(8);
        arr1.insert(29);
        arr1.insert(75);
        arr1.insert(333);
        arr1.insert(2);
        arr1.insert(43);
        arr1.insert(84);
        arr1.insert(37);
        arr1.insert(75);
        arr1.insert(438);
        arr1.insert(4);
        arr1.insert(4);
        arr1.insert(3);
        arr1.insert(0);
        arr1.insert(4);
        arr1.insert(64);
        arr1.insert(6);

        arr.display();
        arr1.display();

        arr.merge(arr1).display();

    }
}
////////////////////////////////////////////////////////////////
