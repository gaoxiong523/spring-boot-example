package com.gaoxiong.elaticsearch.repository;

import com.gaoxiong.elaticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author gaoxiong
 * @ClassName BookRepository
 * @Description TODO
 * @date 2018/10/18 22:25
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
