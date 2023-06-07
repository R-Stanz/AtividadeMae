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

		if (this.list.length == this.size)	System.out.println("Sorry! This array is already full.");
		else{
			try{
				this.tail_marker += 1;
				this.list[this.tail_marker] = value;
				this.size += 1;
			}
			catch (Exception e){
				this.tail_marker -= 1;
				this.shiftToLeft(value);
			}
		}
	}
	private void shiftToLeft(Integer value){

		try{
			Integer freeSpace 	= (this.list.length - (this.size + 1));
			Integer freeEnd 	= freeSpace / 2;
			Integer freeIni 	= freeSpace - freeEnd;

			for(Integer i = this.head_marker; i < this.list.length; i++){
				if (i > (freeIni + this.size)) 	this.list[i] = null;
				else 				this.list[i-freeIni] = this.list[i];
			}
			this.head_marker = freeIni;
			this.tail_marker = freeIni + this.size;
			this.size += 1;
		}
		catch (Exception e){
			System.out.println("Error while shifting the list\n");
		}
	}	
	public int pop_back(){

		try{
			Integer save 			= this.list[this.tail_marker];
			this.list[this.tail_marker] 	= null;
			this.tail_marker		+= 1;
			this.size 			-= 1;
			return save;
		}
		catch (Exception e){
			System.out.println("Something went wrong with the position of the tail.");
		}
	}
	public void push_front(){
		if (this.list.length == this.size)	System.out.println("Sorry! This array is already full.");
		else{
			try{
				this.head_marker -= 1;
				this.list[this.head_marker] = value;
				this.size += 1;
			}
			catch (Exception e){
				this.head_marker += 1;
				this.shiftToRight(value);
			}
		}
	}
	private void shiftToRight(Integer value){
		try{
			Integer freeSpace 	= (this.list.length - (this.size + 1));
			Integer freeEnd 	= freeSpace / 2;
			Integer freeIni 	= freeSpace - freeEnd;

			for(Integer i = this.head_marker; i < this.list.length; i++){
				if (i > (freeIni + this.size)) 	this.list[i] = null;
				else 				this.list[i-freeIni] = this.list[i];
			}
			this.head_marker = freeIni;
			this.tail_marker = freeIni + this.size;
			this.size += 1;
		}
		catch (Exception e){
			System.out.println("Error while shifting the list\n");
		}
	}
