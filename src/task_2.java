public static int sum (int a,  int[] n){
    if (a<1){
        return(0);
    }
    else{
        a= a-1;
        return (n[a]+sum(a,n) );
    }
}
public static void main (String[] args)
{ Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int[] n = new int[a];
    for (int i = 0; i < a; i++) {
        n[i] = sc.nextInt();
    }
    double average = (double) sum(a, n) /a;
    System.out.println(average);
}