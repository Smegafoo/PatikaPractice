public class MyList <T>{
    private T[] array;
    private int list_size;
    private int default_capacity=10;


    //Our constructor methods.

    public MyList(){
        this.array = (T[]) new Object[default_capacity];
        this.list_size = 0;
    }

    public MyList(int capacity){
        if(capacity<=0){
            throw new IllegalArgumentException("The capacity must be greater than 0");
        }
        this.array = (T[]) new Object[capacity];
        this.list_size = 0;
    }
    //---------------------------------------
    //The method that makes array capacity double.

    public void IncreaseCapacity(){
        int newCapacity = array.length * 2;
        T[] newArray = (T[])new Object[newCapacity];
        System.arraycopy(array,0, newArray,0,list_size);
        array=newArray;

    }

    //----------------------------------
    //The method that add element!!

    public void add(T data){
        if(list_size>=getCapacity()) {
            IncreaseCapacity();
        }
            array[list_size++]=data;
    }
    //-------------------------------
    //This methods print the list size.
    public int Size(){
        return list_size;
    }

    //---------------------------





    //This methods are arrays operations.

    public T get(int index){
        if(index<0 || index>list_size){
            return null;
        }else {
            System.out.print("\n"+(index+1)+".index number: ");
            return array[index];
        }

    }
    public T remove(int index){
        if(index<0 || index>list_size){
            return null;
        }else{
            T removed_elements=array[index];
            for(int i=index;i<list_size;i++){
                array[i]=array[i+1];
            }
            list_size--;
            System.out.print("\n"+(index+1)+".index has been deleted :");
            return removed_elements;
        }
    }
    public T set(int index,T data){
        if(index<0 || index>list_size){
            return null;
        }else{
            System.out.println("\nDeleted index :"+get(index));
            array[index]=data;
            System.out.print("\nNew index that added :");
            return data;
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < list_size; i++) {
            result.append(array[i]);
            if (i != list_size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    public int indexOf(T data){
        for(int i=0;i<list_size;i++){
            if(array[i]==data){
                return i+1;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for(int i=list_size-1;i>=0;i--){
            if(array[i]==data){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        if(array[0]==null){
            return true;
        }else{
            return false;
        }
    }
    public void clear(){
        for(int i=0;i<list_size;i++){
            list_size=0;
        }
    }
    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || start >= list_size || finish < 0 || finish >= list_size || start > finish) {
            throw new IllegalArgumentException("Invalid start or finish index");
        }

        MyList<T> subList = new MyList<>();
        for (int i = start; i <= finish; i++) {
            subList.add(array[i]);
        }
        return subList;
    }

    public boolean contains(T data) {
        for (int i = 0; i < list_size; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }
    //------------------------



    //Getter Setter methods!!

    public int getCapacity(){
        return array.length;
    }

    public int getDefault_capacity() {
        return default_capacity;
    }

    public void setDefault_capacity(int default_capacity) {
        this.default_capacity = default_capacity;
    }
}
