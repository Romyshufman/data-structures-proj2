import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test {

    public static void main (String[] args) throws IHashTable.KeyAlreadyExistsException, IHashTable.TableIsFullException{
        int m= 10000019;
        //System.out.println("n is not close to 1");
        //q4(m/2);
        System.out.println("n is almost 1 ");
        q4(19*m/20);
    }

    public static void q3_1_Q1(){
        IHashTable table = new DoubleHashTable(6571, 6571);
        int count = 0;
        for (int i = 0; i <= 6571; i++) {
            long key= (long) Math.pow(i, 2);
            long final_key=  ((key%6571)+6571)%6571;
            HashTableElement elem = new HashTableElement(final_key, i);
            try {
                table.Insert(elem);
                count++;
            } catch (IHashTable.TableIsFullException e) {
                e.printStackTrace();
                System.out.println("should not happen");
            } catch (IHashTable.KeyAlreadyExistsException e) {
            }
        }
        System.out.println(count);
    }
    public static void q3_1_Q2(){
        IHashTable table = new DoubleHashTable(6571, 6571);
        int count = 0;
        for (int i = 0; i <= 6571; i++) {
            long key = (long) (Math.pow(-1,i)*(Math.pow(i, 2)));
            long final_key=  ((key%6571)+6571)%6571;
            HashTableElement elem = new HashTableElement(final_key, i);
            try {
                table.Insert(elem);
                count++;
            } catch (IHashTable.TableIsFullException e) {
                e.printStackTrace();
                System.out.println("should not happen");
            } catch (IHashTable.KeyAlreadyExistsException e) {
            }
        }
        System.out.println(count);
    }
    public static void q3_2(){
        Random rand = new Random();
        System.out.println("**************************  AQP  **************************");
        for (int i=0; i<100; i++) {
            AQPHashTable qp = new AQPHashTable(6571, 1000000007);
            for (int j=0; j<6571; j++){
                int b = rand.nextInt(100);
                try {
                    qp.Insert(new HashTableElement(b+100*j,j));
                }
                catch (IHashTable.TableIsFullException e) {
                    e.printStackTrace();
                } catch (IHashTable.KeyAlreadyExistsException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("**************************  QP  **************************");
        for (int i=0; i<100; i++) {
            QPHashTable qp = new QPHashTable(6571, 1000000007);
            for (int j=0; j<6571; j++){
                int b = rand.nextInt(100);
                try {
                    qp.Insert(new HashTableElement(b+100*j,j));
                }
                catch (IHashTable.TableIsFullException e) {
                    e.printStackTrace();
                } catch (IHashTable.KeyAlreadyExistsException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void q4(int n) throws IHashTable.KeyAlreadyExistsException, IHashTable.TableIsFullException {
        int m=10000019;
        long p=1000000007;
        LPHashTable lp= new LPHashTable(m,p);
        QPHashTable qp = new QPHashTable(m,p);
        AQPHashTable aqp =new AQPHashTable(m,p);
        DoubleHashTable d= new DoubleHashTable(m,p);
        Random rand = new Random();
        List<HashTableElement> arr = new ArrayList<>(n);
        for(int i=0; i<n; i++) {
            int b = rand.nextInt(100);
            int a = 100 * i + b;
            arr.add(new HashTableElement(a,a));
        }

        long startTime1 = System.nanoTime();
        for(HashTableElement h: arr){
            lp.Insert(h);
        }
        long endTime1 = System.nanoTime();
        float totalTime1 = (float) ((endTime1-startTime1)*Math.pow(10,-9));
        System.out.println("lp "+ totalTime1);

        //long startTime2 = System.nanoTime();
        //for(HashTableElement h: arr){
          //  qp.Insert(h);
        //}
        //long endTime2= System.nanoTime();
        //float totalTime2 = (float) ((endTime2-startTime2)*Math.pow(10,-9));
        //System.out.println("qp "+ totalTime1);

        long startTime3 = System.nanoTime();
        for(HashTableElement h: arr){
            aqp.Insert(h);
        }
        long endTime3 = System.nanoTime();
        float totalTime3 = (float) ((endTime3-startTime3)*Math.pow(10,-9));
        System.out.println("aqp "+ totalTime3);

        long startTime4 = System.nanoTime();
        for(HashTableElement h: arr){
            d.Insert(h);
        }
        long endTime4 = System.nanoTime();
        float totalTime4 = (float) ((endTime4-startTime4)*Math.pow(10,-9));
        System.out.println("doublt "+ totalTime4);
    }

    public static void q5(){
        IHashTable doublehash = new DoubleHashTable(10000019, 1000000007);
        Random rand = new Random();
        HashTableElement[] items = new HashTableElement[10000019 / 2];
        for (int j = 0; j < 6; j++) {
            long start= System.nanoTime();
            for (int i = 0; i < 10000019 / 2; i++) {
                int b = rand.nextInt(100);
                items[i] = new HashTableElement(b + 100 * i, i);
                try {
                    doublehash.Insert(new HashTableElement(b + 100 * i, i));
                } catch (IHashTable.TableIsFullException e) {
                    e.printStackTrace();
                } catch (IHashTable.KeyAlreadyExistsException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < 10000019 / 2; i++) {
                try {
                    doublehash.Delete(items[i].GetKey());
                } catch (IHashTable.KeyDoesntExistException e) {
                    e.printStackTrace();
                }
            }
            long end= System.nanoTime();
            double tot= Math.pow(10,-9)*(end-start);
            System.out.println(j+" "+tot);
        }
    }
    public static void ex4_1() throws Exception {
        int m = 10000019;
        long p = 1000000007;
        int n = Math.floorDiv(m,2);
        long a;
        long b;
        Random rand = new Random();
        ArrayList<Long> keys = new ArrayList<Long>();
        // creates array of keys
        for (int i=0 ; i < n ; i++){
            b = (long) rand.nextInt(100);
            a = 100*i + b;
            keys.add(a);
        }
        // create tables
        LPHashTable table1 = new LPHashTable(m, p);
        QPHashTable table2 = new QPHashTable(m, p);
        AQPHashTable table3 = new AQPHashTable(m, p);
        DoubleHashTable table4 = new DoubleHashTable(m, p);
        System.out.println("LP time: " + insertToTable(keys, table1));
        System.out.println("QP time: " + insertToTable(keys, table2));
        System.out.println("AQP time: " + insertToTable(keys, table3));
        System.out.println("DoubleHash time: " + insertToTable(keys, table4));


    }
    public static void ex4_2() throws Exception {
        int m = 10000019;
        long p = 1000000007;
        int n = Math.floorDiv(19*m,20);
        long a;
        long b;
        Random rand = new Random();
        ArrayList<Long> keys = new ArrayList<Long>();
        // creates array of keys
        for (int i=0 ; i < n ; i++){
            b = (long) rand.nextInt(100);
            a = 100*i + b;
            keys.add(a);
        }
        // create tables
        LPHashTable table1 = new LPHashTable(m, p);
        QPHashTable table2 = new QPHashTable(m, p);
        AQPHashTable table3 = new AQPHashTable(m, p);
        DoubleHashTable table4 = new DoubleHashTable(m, p);
        System.out.println("LP time: " + insertToTable(keys, table1));
        System.out.println("QP time: " + insertToTable(keys, table2));
        System.out.println("AQP time: " + insertToTable(keys, table3));
        System.out.println("DoubleHash time: " + insertToTable(keys, table4));


    }
    public static long insertToTable(ArrayList<Long> keys, OAHashTable table) throws Exception{
        long startTime = System.currentTimeMillis();
        for (int i=0 ; i < keys.size() ; i++){
            long key = keys.get(i);
            HashTableElement elementToInsert = new HashTableElement(key, key);
            table.Insert(elementToInsert);
        }
        long endTime   = System.currentTimeMillis();
        return endTime - startTime;
    }
    public static void q4_check_QP(){
        IHashTable table = new DoubleHashTable(10000019,1000000007);
        int count = 0;
        for (int i = 0; i <= 10000019; i++) {
            long key= (long) Math.pow(i, 2);
            long final_key=  ((key%10000019)+10000019)%10000019;
            HashTableElement elem = new HashTableElement(final_key, i);
            try {
                table.Insert(elem);
                count++;
            } catch (IHashTable.TableIsFullException e) {
                e.printStackTrace();
                System.out.println("should not happen");
            } catch (IHashTable.KeyAlreadyExistsException e) {
            }
        }
        System.out.println(count);
    }
}


