import java.util.*;  
public class AuthorTest{  
    public static void main(String args[]){  
        ArrayList<Author> author=new ArrayList<Author>();  
        author.add(new Author("Karmel","Yacoub","How to cry"));  
        author.add(new Author("Mahmoud","Anbousi","How to die"));  
        author.add(new Author("Saeed","Hroub","How to pass"));  
            
        Collections.sort(author);  
        for(Author a:author){  
        System.out.println(a.firstName+" "+a.lastName+" "+a.bookName);  
        }  
    }  
}  