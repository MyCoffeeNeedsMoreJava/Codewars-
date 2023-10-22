public class CamelCaseTranslator {
    public static void main(String[] args) {
        String res = toUnderScore("ThisIsAUnitTest");
        System.out.println(res);
    }

    public static String toUnderScore(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(name.charAt(0));
    
        for(int i = 1; i <= name.length()-1; i++) {
            if(name.charAt(i-1) != '_') {
                if(Character.isUpperCase(name.charAt(i))) {
                    sb.append("_");
                }
                if(Character.isDigit(name.charAt(i)) && !Character.isDigit(name.charAt(i-1))) {
                    sb.append("_");
                } 
            }
        sb.append(name.charAt(i));
        }
        return sb.toString();
    }
}