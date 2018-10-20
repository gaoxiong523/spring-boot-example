package com.gaoxiong.elaticsearch;

import com.gaoxiong.elaticsearch.bean.Book;
import com.gaoxiong.elaticsearch.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElaticsearchApplicationTests {

    @Autowired
    private BookRepository bookRepository;
    @Test
    public void contextLoads () {
    }

    @Test
    public void test(){
        Book book = new Book();
        book.setId(1);
        book.setBookName("斗破苍穹");
        book.setAuthor("唐家三少");
        bookRepository.index(book);
    }

}
