package algo.string;

/**
 * Created by Jun on 2017/7/31.
 */
public class Zipper {
    public String zipString(String iniString) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        boolean zip = false;

        for (int i = 0; i < iniString.length(); i++) {
            if ((i+1) < iniString.length() && iniString.charAt(i) == iniString.charAt(i + 1)) {
                count++;
                zip = true;
            } else {
                sb.append(iniString.charAt(i) + String.valueOf(count));
                count = 1;
            }
        }


        return zip ? sb.toString() : iniString;
    }
}
