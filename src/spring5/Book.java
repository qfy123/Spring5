package spring5;

/**
 * @author QFY
 * @Description
 * @create 2021-05-28 17:58
 */
public class Book {
    private String name;
    private String author;
    //set方法注入
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void sout(){
        System.out.println(name+"::"+author);
    }
}
