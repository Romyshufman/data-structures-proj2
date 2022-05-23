import java.sql.SQLOutput;
import java.util.Random;

public class test {

    public static void main (String[] args) {
        System.out.println("n is almost 1 ");
        q4(9500018);
        System.out.println("n is not close to 1");
        q4(5000009);
    }

    public static void q3_1(){
        IHashTable table = new DoubleHashTable(6571, 6571);
        int count = 0;
        for (int i = 0; i <= 6571; i++) {
            //long key= (long) Math.pow(i, 2);
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
        for (int i=0; i<100; i++) {
            System.out.println("round number:"+ i);
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
        System.out.println("****************************************************");
        for (int i=0; i<100; i++) {
            System.out.println("round number:"+ i);
            AQPHashTable aqp = new AQPHashTable(6571, 1000000007);
            for (int j=0; j<6571; j++){
                int b = rand.nextInt(100);
                try {
                    aqp.Insert(new HashTableElement(b+100*j,j));
                }
                catch (IHashTable.TableIsFullException e) {
                    e.printStackTrace();
                } catch (IHashTable.KeyAlreadyExistsException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void q4(int n){
        int m=10000019;
        long p=1000000007;
        IHashTable[] t ={new DoubleHashTable(m,p),new LPHashTable(m,p), new QPHashTable(m,p), new AQPHashTable(m,p)};
        Random rand = new Random();
        for(int j=0; j<4; j++){
            System.out.println("j="+ j);
            long startTime = System.nanoTime();
            for(int i=0; i<n; i++){
                int b = rand.nextInt(100);
                int a= 100*i+b;
                try {
                    t[j].Insert(new HashTableElement(a,i));
                }
                catch (IHashTable.TableIsFullException e) {
                    e.printStackTrace();
                } catch (IHashTable.KeyAlreadyExistsException e) {
                    e.printStackTrace();
                }
            }
            long endTime = System.nanoTime();
            double totalTime = (endTime-startTime)*Math.pow(10,-9);
            System.out.println("time "+ totalTime);
        }
    }


}
