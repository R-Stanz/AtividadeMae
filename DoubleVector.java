public class DoubleVector{

	private Integer size;
	private Integer capacity;
	private Integer head_marker;
	private Integer tail_marker;
	private Integer[] list;

	DoubleVector(){
		this.capacity 		= 16;
		this.size 		= 0 ;
		this.list		= new Integer[this.capacity];
		this.head_marker	= ((this.capacity) / 2) - 1;
		this.tail_marker	= head_marker+1;
	}

	DoubleVector(int n){
		this.capacity		= n;
		this.size 		= 0 ;
		try{
			this.list = new Integer[n];
			if (n == 1){
				this.head_marker = 0;
				this.tail_marker = this.head_marker;
			}
			else{
				this.head_marker = (n / 2);
				if (n % 2 == 0) this.head_marker -= 1;
				this.tail_marker = this.head_marker + 1;
			}
		}
		catch (Exception e){
			System.out.println("Invalid value for \" n \" = " + n);
		}
	}

	public Integer size(){
		return this.size;
	}

	public boolean empty(){
		if (this.size == 0) return true;
		return false;
	}

	public void push_back(Integer value){
		// Method defined on line 62
		sizeCheck();

		try{
			Integer lastPosition = this.tail_marker;
			this.list[lastPosition] = value;
			this.tail_marker += 1;
			this.size += 1;
		}
		catch (Exception e){
			// Method defined next, line 66
			this.shiftToLeft(value);
		}
	}

	private void sizeCheck(){
		if (this.capacity == this.size) this.resize();
	}

	private void shiftToLeft(Integer value){
		try{
			// Moves based on the disposition of free spaces after the shift
			Integer freeSpace 	= (this.capacity - (this.size + 1));
			Integer freeAtEnd 	= freeSpace / 2;
			Integer freeAtIni 	= freeSpace - freeAtEnd;

			for(Integer i = this.head_marker; i < this.capacity; i++){
				if (i > (freeAtIni + this.size)) 	this.list[i] = null;
				else	 				this.list[i-freeAtIni] = this.list[i];
			}
			// Method defined on line 85.
			this.markersAfterShift(freeAtIni, freeAtEnd);
		}
		catch (Exception e){
			System.out.println("Error while shifting the list\n");
		}
	}	

	private void markersAfterShift(Integer freeAtIni, Integer freeAtEnd){
			this.head_marker = freeAtIni - 1;
			this.size += 1;
			this.tail_marker = freeAtIni + this.size;
	}

	public Integer pop_back(){
		try{
			if (this.empty() == true)	return null;
			// Other wise:
			Integer lastPosition		= this.tail_marker - 1;
			Integer save 			= this.list[lastPosition];
			this.list[lastPosition] 	= null;
			this.tail_marker		-= 1;
			this.size 			-= 1;
			return save;
		}
		catch (Exception e){
			System.out.println("Something went wrong with the position of the tail.");
			return null;
		}
	}

	public void push_front(Integer value){
		// Method defined on line 62
		sizeCheck();

		try{
			Integer firstPosition = this.head_marker;
			this.list[firstPosition] = value;
			this.head_marker -= 1;
			this.size += 1;
		}
		catch (Exception e){
			// Method defined next, line 124
			this.shiftToRight(value);
		}
	}

	private void shiftToRight(Integer value){
		try{
			// Moves based on the disposition of free spaces after the shift
			Integer freeSpace 	= (this.capacity - (this.size + 1));
			Integer freeAtEnd 	= freeSpace / 2;
			Integer freeAtIni 	= freeSpace - freeAtEnd;

			for(Integer i = this.head_marker; i < this.capacity; i++){
				if (i > (freeAtIni + this.size)) 	this.list[i] = null;
				else 					this.list[i-freeAtIni] = this.list[i];
			}
			// Method defined on line 85.
			this.markersAfterShift(freeAtIni, freeAtEnd);
		}
		catch (Exception e){
			System.out.println("Error while shifting the list\n");
		}
	}

	public Integer pop_front(){
		try{
			if (this.empty() == true)		return null;
			// Other wise:
			Integer firstPosition		= this.head_marker + 1;
			Integer save 			= this.list[firstPosition];
			this.list[firstPosition] 	= null;
			this.head_marker		+= 1;
			this.size 			-= 1;
			return save;
		}
		catch (Exception e){
			System.out.println("Something went wrong with the position of the tail.");
			return null;
		}
	}

	public Integer at(Integer k){
		// Based on the converted position of k on the array, this.list
		Integer kOnArray = this.head_marker + 1 + k;
		try{
			if ((kOnArray <= this.head_marker) || (kOnArray >= this.tail_marker))
				return -1;
			else return this.list[kOnArray];
		}
		catch (Exception e){
			System.out.println("Something wrong with the values of the markers.");
			return null;
		}
	}

	private void resize(){
		this.capacity *= 2;
		Integer[] tmpArr = new Integer[this.capacity];
		// Moves based on the disposition of free spaces after the resizing
		Integer freeSpace 	= (this.capacity - (this.size + 1));
		Integer freeAtEnd 	= freeSpace / 2;
		Integer freeAtIni 	= freeSpace - freeAtEnd;

		// this.size should be identical to the old capacity
		for(Integer i = 0; i < this.size; i++) tmpArr[freeAtIni + i] = this.list[i];

		// Overwrites the old list array with the new one
		this.list = tmpArr;
	}

	public void remove(Integer k){
		// Based on the converted position of k on the array, this.list
		Integer kOnArray = this.head_marker + 1 + k;
		try{
			Integer freeIni = this.head_marker + 1;
			Integer freeEnd = this.size - this.tail_marker;
			
			// Makes the begining of the list more empty
			if (freeIni+1 <= freeEnd){
				for(Integer i = kOnArray; i < this.capacity; i++){
					if ((i >= this.tail_marker) || (i == capacity - 1)) 	
						this.list[i] = null;
					else						
						this.list[i] = this.list[i+1];
				}
				this.head_marker += 1;
			}

			// Makes the ending of the list more empty
			else{
				for(Integer i = kOnArray; i > 0; i--){
					if ((i <= this.head_marker) || (i == 0)) 	
						this.list[i] = null;
					else						
						this.list[i] = this.list[i-1];
				}
				this.tail_marker -= 1;
			}
		}
		catch (Exception e){
			System.out.println("Error while removing! Probably the k = " + k + " is invalid.");
		}
	}

	private void remoteAll(int value){
		Integer i	= 0;
		while(i != this.size){
			if (this.at(i) == value){
				remove(i);
				i -= 1;
			i += 1;
			}
		}
	}

	public void print(){
		Integer listIni = this.head_marker + 1;
		Integer listEnd = this.tail_marker;
		for(Integer i = listIni; i < listEnd; i++){
			System.out.print(this.list[i]);
			if (i != listEnd - 1) System.out.print(" ");
		}
	}

	public void printReverse(){
		Integer listIni = this.head_marker;
		Integer listEnd = this.tail_marker - 1;
		for(Integer i = listEnd; i > listIni; i--){
			System.out.print(this.list[i]);
			if (i != listIni + 1) System.out.print(" ");
		}
	}

	public void concat(DoubleVector lst){
		for(Integer i = 0; i < lst.size(); i++){
			Integer iterationValue = lst.at(i);
			this.push_back(iterationValue);
		}
	}

	public boolean equal(DoubleVector lst){
		if (this.size != lst.size()) return false;
		for(Integer i = 0; i < this.size; i++){ 
			if (this.at(i) != lst.at(i)) return false;
		}
		return true;
	}
}
