public static void prime (int n, int i)
{
    if (i==n)
    {
        System.out.println("Prime");
    }
    else
    {
        if (n%i!=0){
        prime (n,i+1);}
        else{
        System.out.print("Composite");}
    }
}
public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
prime(n,2);
}