/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import example.BlogPost;
import example.Blogs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author bryan
 */
public class Display {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        BlogPost blogpost = new BlogPost(
//                "Author's Name",
//                "Author Title",
//                "constructor - methods that are invoked to create objects from the class blueprint. A class can have many constructors, and every class has a default constructor that takes no parameters.\n" +
//                "deprecated - term used to mark a class or method that you should no longer use, since it has been superseded and may cease to exist in the future.",
//                "Category section",
//                "Tag",
//                new Date()
//        );
////        
//        BlogPost blogpost2 = new BlogPost(
//                "Author's Name",
//                "Author Title",
//                "deprecated - term used to mark a class or method that you should no longer use, since it has been superseded and may cease to exist in the future.",
//                "Category section",
//                "Tag",
//                new Date()
//        );
//       
//        
//        BlogPost[] posts = {blogpost2,blogpost};
//            // Blogpost object is now a comparable class because of the implementation of comparable and compareTo method
//        Arrays.sort(posts);
//        
//        for(BlogPost post: posts){
//            System.out.printf("Blog Alert -> %s %n", post);
//        }
//        
//        Blogs.save(posts);
        
        // Function: this will load saved post entry
        BlogPost[] receives = Blogs.load();
        for(BlogPost received: receives){
            System.out.print(received);
        }
        
        List<String> bpBody = new ArrayList<String>();
        for(BlogPost receiveBody : receives){
            bpBody.add(receiveBody.getBody());
        }
        
        System.out.println("\n\nExample of getting all the body content in the datafile:\n" + bpBody);
        
        List<String> getLetterC = new ArrayList<String>();
        
        for(BlogPost c : receives){
            String[] getC = c.getBody().split("[^\\w']");
            for(String mC : getC)
            if(mC.startsWith("c")){
            getLetterC.add(mC);
            }
        };
        
        System.out.println("\n\nExample of Getting all blog body content and Selecting only the words that begins with the letter C: \n"+getLetterC);
        
        
        
        //There is a fault in this example. Need to get 1 body content and convert into array list 
        SortedSet<String> letterA = new TreeSet<String>();
        for(BlogPost a: receives){
            letterA.add(a.getBody()); 
        };
        
        System.out.println("\nThese are the words with A in them: " + letterA.subSet("A", "A" + Character.MAX_VALUE));
    }
    
}
