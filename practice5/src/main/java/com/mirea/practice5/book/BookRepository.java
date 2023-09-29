package com.mirea.practice5.book;

import com.mirea.practice5.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}