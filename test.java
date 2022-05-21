import java.sql.SQLOutput;

public class test {

    public static void main (String[] args) {

    }

    public static void q3_1(){
        IHashTable table = new DoubleHashTable(6571, 6571);
        int count = 0;
        for (int i = 0; i <= 6571; i++) {
            long key= (long) Math.pow(i, 2);
            //long key = (long) (Math.pow(-1,i)*(Math.pow(i, 2)));
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
}
