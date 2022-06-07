/**name1: Romy Shufman
 id1: 209365238
 username1: romyshufman
 name2: Noa Hadash
 id2: 316279264
 username2: noahadash
 */

public class DoubleHashTable extends OAHashTable {

	private ModHash modHash1;
	private ModHash modHash2;


	public DoubleHashTable(int m, long p) {
		super(m);
		this.modHash1=ModHash.GetFunc(m,p);
		this.modHash2=ModHash.GetFunc(m-1,p);
	}

	/**
	 *
	 * @return h(k,i)=(h1'(k)+i*h2'(k)) mod m
	 */

	@Override
	public int Hash(long x, int i) {
		long result  =  (modHash1.Hash(x)+ (long) i *(modHash2.Hash(x)+1))%m; //jumps will never be zero
		return (int) (result < 0 ? result+m : result); //makes sure result>=0
	}
}
