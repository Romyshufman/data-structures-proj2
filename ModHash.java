import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ModHash {

	private long a;
	private long b;

	public ModHash(long a, long b){
		this.a=a;
		this.b=b;
	}
	
	public static ModHash GetFunc(int m, long p){
		Random rand= new Random();
		long a= ThreadLocalRandom.current().nextLong(1, p);
		long b=  ThreadLocalRandom.current().nextLong(0, p);
		return new ModHash(a,b);
	}
	
	public int Hash(long key) {
		// TODO implement hash function
		return 0;
	}
}
