
public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		// TODO add to constructor as needed
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		// TODO implement find
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		if (this.Find(hte.GetKey()) != null){
			throw  new KeyAlreadyExistsException(hte);
		}
		else {
			int i = 0;
			boolean inPlace = false;
			while(i<table.length && ! inPlace){
				int index = Hash(hte.GetKey(), i);
				if (table[index] == null) {
					table[index] = hte;
					inPlace = true;
				}
			}
			if (i==table.length && !inPlace){
				throw new TableIsFullException(hte);
			}
		}
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		// TODO implement deletion
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
