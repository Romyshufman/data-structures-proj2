
public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		// TODO add to constructor as needed
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		int result = Find_index(key);
		if (result == -1) {
			return null;
		}
		return table[result];
	}

	public int Find_index(long key) {
		int i=0;
		while(i<table.length){
			int index= Hash(key, i);
			if (table[index] == null){
				return -1;
			}
			else if (table[index].GetKey()==key) {
				return index;
			}
			else{
				i++;
			}
		}
		return -1;
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
				if (table[index] == null  || table[index].GetKey()<0) {
					table[index] = hte;
					inPlace = true;
				}
				i++;
			}
			if (i==table.length && !inPlace){
				throw new TableIsFullException(hte);
			}
		}
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		int index = Find_index(key);
		if (key == -1){
			throw new KeyDoesntExistException(key);
		}
		table[index] = new HashTableElement(-1, -1);
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
