package example;
import java.lang.Object;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 *
 * @author bryan
 */
public class BlogPost implements Comparable<BlogPost>, Serializable {
    private static final long serialVersionUID = 1L;
    private String mAuthor,mTitle,mBody,mCategory,mTag;
    private Date   mDate;
     
    public BlogPost(String author,String title,String body,String category,String tag,Date date){
        mAuthor = author;
        mTitle = title;
        mBody = body;
        mCategory = category;
        mTag = tag;
        mDate = date;
    }
     
    public String getAuthor(){ return mAuthor; }
    public String getTitle(){ return mTitle; }
    public String getBody(){ return mBody; }
    public String getCategory(){ return mCategory; }
    public String getTag(){ return mTag; }
    public Date getDate(){ return mDate; }
    
    public List<String> getWords() { 
        String [] words = mBody.split("[^\\w#@']+");
        return Arrays.asList(words);
    }
    
   
    private List<String> getPrefix(String prefix){
        List<String> tags = new ArrayList<String>();
        for(String tag: getWords()){
            if(tag.startsWith(prefix)){
                tags.add(tag);
            }
        }
        return tags;
    }
    
    public List<String> getTags(){
        return getPrefix("#");
    }
    
    @Override
    public String toString(){
        return String.format("Blog Alert -> New Post: %s by %s : %n%s%n%s", getTitle(),getAuthor(),getBody(),getDate()); 
    }
    
    //Function: Overriding compareto to this class comparable to other object class of its kind
    @Override
    public int compareTo(BlogPost otherPost){        
        if(equals(otherPost)){
            return 0;
        }
        int dateCom =  mDate.compareTo(otherPost.mDate);
        if(dateCom == 0){
            return mBody.compareTo(otherPost.mBody);
        }
        return dateCom;
    }
}
