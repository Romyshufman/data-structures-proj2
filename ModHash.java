import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ModHash {

	private long a;
	private long b;
	private long p;
	private int m;

	public ModHash(long a, long b, int m, long p){
		this.a = a;
		this.b = b;
		this.p = p;
		this.m=m;
	}
	
	public static ModHash GetFunc(int m, long p){
		long a= ThreadLocalRandom.current().nextLong(1, p); // 1<=a<p
		long b=  ThreadLocalRandom.current().nextLong(0, p); // 0<=b<p
		return new ModHash(a, b, m, p);
	}
	
	public int Hash(long key) {
		long result = ((a*key+b)%p)%m;
		if (result<0){  // this line makes sure that result >= 0
			result=result+m;
		}
		return (int)result;
	}
	public int secHash(long key) { // specific hash for double hash->if key >=0 : will never return 0
		int result = (int) (((a*key+b)%p)%(m-1)+1);
		if (result<0){
			result=result+m;
		}
		return result;

	}
}
