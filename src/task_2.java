public static int sum (int a,  ArrayList<Integer> n){
    if (a<1){
        return(0);
    }
    else{
        a= a-1;
        return (n.get(a) +sum(a,n) );
    }
}
public static ArrayList<Integer> input (Scanner sc, int a, ArrayList<Integer> n){
    if (a==0){
        return n;}
    n.add(sc.nextInt());
    return input(sc, a-1, n);

}
public static void main (String[] args)
{ Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    ArrayList<Integer> n = input(sc,a,new ArrayList<>());
    double average = (double) sum(a, n) /a;
    System.out.println(average);
}