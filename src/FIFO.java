import java.util.NoSuchElementException;
import java.util.Vector;

public class FIFO implements Queue{
	private Vector<Object> v = new Vector<Object>();
	private static int vectorMaxSizeEver = 0;
	
	public void add(Object arg0){
		this.v.addElement(arg0);	//Adds the specified component to the end of this vector, increasing its size by one.
		if(vectorMaxSizeEver<v.size()){
			vectorMaxSizeEver++; //Increment this variable in the case when it is smaller than the queue has ever been.
		}
	}

	public Object first() throws NoSuchElementException{	//Can throw this exception.
		if(v.isEmpty()){
			throw new NoSuchElementException();
		}else{
			return this.v.firstElement();
		}
	}

	public boolean isEmpty(){
		return this.v.isEmpty();	//isEmpty() returns true if empty.
	}

	public int maxSize(){ //Returns the variable that keeps track of the maximum size the Queue has ever had.
		return vectorMaxSizeEver;
	}

	public void removeFirst() throws NoSuchElementException {
		if(this.v.size()==0){
			throw new NoSuchElementException();	//In case the Queue is empty.
		}else{
			this.v.removeElementAt(0); //Remove the element at specific index. The rest of the elements get their indices shifted down.
		}
	}

	public int size(){	//Returns the size of the Queue.
		return this.v.size();
	}
	public boolean equals(Object f){	//FIFOmain validate this code by calling this method with it's own set of FIFO Objects.
		
		//System.out.println(this.v +"this size:"+this.size());
		//System.out.println(((FIFO) f).v +"f size:"+((FIFO)f).v.size());
		if(f instanceof FIFO){
			if(this.v.size()==(((FIFO) f).v.size())){
				
				for(int i=0;i<this.v.size();i++){
					if(this.v.get(i)==null){
						if((((FIFO) f).v.get(i)==null)){
							continue;
						}else{
							return false;
						}
					}else if(this.v.get(i).equals(((FIFO) f).v.get(i))){
						continue;
					}else{return false;}
				}
				return true;
				
			}
		}return false;
	}
	
	public String toString(){
		String printObjects="";
		for(int i=0;i<v.size();i++){
			printObjects += "(" + String.valueOf(this.v.elementAt(i)) + ") ";
		}
		return "Queue: "+ printObjects;
	}
}
