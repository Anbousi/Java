public class Author implements Comparable<Author>{
    String firstName;
    String lastName;
    String bookName;

    // public Author(){
    // }


    public Author(String firstName, String lastName, String bookName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookName = bookName;
    }

public int compareTo(Author au){  
    if(firstName==au.firstName)  
        return 0;  
    else if(firstName.compareTo(au.firstName)>0)  
        return 1;  
    else  
        return -1;  
}  
}
