public class StringManipulatorTesting{
    public static void main(String[] args) {
        StringManipulator str1 = new StringManipulator();
        char letter='o';
        String word = "llo";
    
        System.out.println(str1.trimAndConcat("  Hello  ", "   World   "));
        Integer a = str1.getIndexOrNull("Coding", letter);
        Integer b = str1.getIndexOrNull("Hello World", letter);
        Integer c = str1.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null

        ////////////////////////////////////////////////
        String word1 = "Hello";
        String subString = "llo";
        String notSubString = "world";

        Integer d = str1.getIndexOrNull(word1, word1);
        Integer e = str1.getIndexOrNull(word1, subString);
        Integer f = str1.getIndexOrNull(word1, notSubString);
        System.out.println(d); 
        System.out.println(e);// 2
        System.out.println(f);  // null

        String word2 = str1.concatSubstring("Hello", 1, 2, "world");
        System.out.println(word2); // eworld 
    }
    
}