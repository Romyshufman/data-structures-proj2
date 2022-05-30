/**name1: Romy Shufman
 id1: 209365238
 username1: romyshufman
 name2: Noa Hadash
 id2: 316279264
 username2: noahadash
 */
public class QPHashTable extends OAHashTable {
	private ModHash modHash;

	public QPHashTable(int m, long p) {
		super(m);
		this.modHash = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int result= (int) ((this.modHash.Hash(x)+Math.pow(i,2))%m);
		if (result<0)
			result+=m;
		return result;
	}
}
