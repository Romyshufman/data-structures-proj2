import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ModHash {

	private long a;
	private long b;
	private int m;
	private long p;

	public ModHash(long a, long b, int m, long p){
		this.a = a;
		this.b = b;
		this.p = p;
		this.m = m;
	}
	
	public static ModHash GetFunc(int m, long p){
		Random rand= new Random();
		long a= ThreadLocalRandom.current().nextLong(1, p);
		long b=  ThreadLocalRandom.current().nextLong(0, p);
		return new ModHash(a, b, m, p);
	}
	
	public int Hash(long key) {
		int result = (int) (((a*key+b)%p)%m);
		if (result<0){
			result=result+m;
		}
		return result;
	}
	public int secHash(long key) {
		int result = (int) ((a*key+b)%p)%(m-1)+1;
		if (result<0){
			result=result+m;
		}
		return result;

	}
}
