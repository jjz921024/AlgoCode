package question.string;

public class Different {
    public boolean checkDifferent(String iniString) {
        char c = iniString.charAt(0);
        for (int i=1; i<iniString.length(); i++){
            if (c == iniString.charAt(i))
                return false;
        }
        return true;
    }

    public String reverseString(String iniString) {
        char[] chars = iniString.toCharArray();
        int len = iniString.length();
        char c;
        for (int i = 0; i < len/2; i++) {
            c = chars[i];
            chars[i] = chars[len-i-1];
            chars[len-i-1] = c;
        }
        return new String(chars);


    }
}
