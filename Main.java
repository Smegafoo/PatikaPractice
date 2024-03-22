public class Main {
    public static void main(String[] args) {
        MyList <Integer>a=new MyList<>();
        a.add(10);
        a.add(20);
        a.add(30);
        a.add(67);
        a.add(43);
        System.out.println(a.Size());
        System.out.println(a.toString());
        a.clear();
        System.out.println(a.toString());
        a.add(20);
        a.add(30);
        System.out.println(a.toString());



    }
}