/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;
import java.io.*;
/**
 *
 * @author bryan
 */
public class Blogs {
    public static void save(BlogPost[] blogs){
        try(
                FileOutputStream fos = new FileOutputStream("blogs.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ){
            oos.writeObject(blogs);
        } catch(IOException ioe){
            System.out.println("Blogs can not be saved");
            ioe.printStackTrace();
        }
    }
    
    public static BlogPost[] load(){
        BlogPost[] blogs = new BlogPost[0];
        try(
            FileInputStream fis = new FileInputStream("blogs.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
        ){
           blogs = (BlogPost[]) ois.readObject();
        } catch (IOException ioe){
            System.out.println("Error reading file");
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            System.out.println("Error loading file");
            cnfe.printStackTrace();
        }
        return blogs;
    }
}
