import java.util.List;
import java.util.Random;

public class test_q5 {
    public static void main(String[] args) {
        IHashTable doublehash = new DoubleHashTable(10000019, 1000000007);
        Random rand = new Random();
        HashTableElement[] items = new HashTableElement[10000019 / 2];
        for (int j = 0; j < 6; j++) {
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
    }
    }
}
