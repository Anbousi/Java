public class StringManipulator{

    public String trimAndConcat(String A, String B) {
        String one = A.trim();
        String two = B.trim();
        String three = one.concat(two);
        return three;
    }

    public Integer getIndexOrNull(String str1, char str2) {
        int r = str1.indexOf(str2);
        if (r == -1){
            return null;
        }
        return r;
    }

    public Integer getIndexOrNull(String str1, String str2) {
        int r = str1.indexOf(str2);
        if (r == -1){
            return null;
        }
        return r;
    }
    
    public String concatSubstring(String str1, int x, int y, String str2){
        String str = str1.substring(x, y);
        String str3 = str.concat(str2);
        return str3;
    }
}