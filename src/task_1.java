public static void printDigits(int n){
    if (n<10){
        System.out.println(n);
    }
    else{
        printDigits(n/10);
        int a=n%10;
        System.out.println(a);}
}

public static void main (String[] args)
{ Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    printDigits(n);}
