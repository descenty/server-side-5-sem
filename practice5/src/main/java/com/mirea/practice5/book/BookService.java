package com.mirea.practice5.book;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.mirea.practice5.book.schema.BookCreate;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public Optional<Long> create(BookCreate BookCreate) {
        return Optional.of(bookMapper.toEntity(BookCreate)).map(bookRepository::save).map(Book::id);
    }

    @Transactional
    public Optional<Book> partialUpdate(Long id, BookCreate BookCreate) {
        return bookRepository.findById(id).map(Book -> bookMapper.update(Book, BookCreate)).map(bookRepository::save);
    }

    @Transactional
    public boolean delete(Long id) {
        return bookRepository.findById(id).map(Book -> {
            bookRepository.delete(Book);
            return true;
        }).orElse(false);
    }

}