package com.codegym.services;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Iterable<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByTitleContaining(String tittle, Pageable pageable);

    Page<Blog> findAllByCategory_Id(Long id,Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
