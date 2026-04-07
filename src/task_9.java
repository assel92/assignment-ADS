public static int CountCharacters(String n){
if (n.isEmpty()){
    return 0;}
else{
    return 1 +CountCharacters(n.substring(1));
}
}
public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    String n = sc.nextLine();
    System.out.println(CountCharacters(n));}