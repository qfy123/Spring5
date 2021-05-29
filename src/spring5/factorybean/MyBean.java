package spring5.factorybean;

import org.springframework.beans.factory.FactoryBean;
import spring5.Book;

public class MyBean implements FactoryBean<Book> {
    //定义返回的bean
    @Override
    public Book getObject() throws Exception {
        Book book = new Book();
        book.setName("起飞");
        return book;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
