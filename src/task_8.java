public static String String(String s){
    if (s.isEmpty()){
        return "Yes";
    }
    else if(Character.isDigit(s.charAt(0))){
           return String (s.substring((1)));
        }
        else{
            return"No";
        }
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    System.out.println(String(s));
}