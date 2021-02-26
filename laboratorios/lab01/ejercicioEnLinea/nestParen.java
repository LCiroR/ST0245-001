/**
* Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))"
*/
public class nestParen{
  
    public boolean nestParen(String str) {

        if(str.length() <= 1) return true;

        if(str.length()%2 == 0){
            if(str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')')
                return nestParen(str.substring(1,str.length()-1));
            return false;
        }
        return false;
    }

}
