import java.util.Random;

public class DoubleHashTable extends OAHashTable {

	private ModHash modHash1;
	private ModHash modHash2;


	public DoubleHashTable(int m, long p) {
		super(m);
		this.modHash1=ModHash.GetFunc(m,p);
		this.modHash2=ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) { //hash(x,i)=(modhash1(x)+i*modhash2(x))mod m
		int result  = (int) ((modHash1.Hash(x)+i*modHash2.secHash(x))%m);
		if (result<0)      //this line makes sure we result>=0
			result+=m;
		return result;
	}
}
