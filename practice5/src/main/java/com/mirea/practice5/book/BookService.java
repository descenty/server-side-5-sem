package com.mirea.practice5.book;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.mirea.practice5.book.schema.BookCreate;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(UUID id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public Optional<UUID> create(BookCreate BookCreate) {
        return Optional.of(bookMapper.toEntity(BookCreate)).map(bookRepository::save).map(Book::getId);
    }

    @Transactional
    public Optional<Book> partialUpdate(UUID id, BookCreate BookCreate) {
        return bookRepository.findById(id).map(Book -> bookMapper.update(Book, BookCreate)).map(bookRepository::save);
    }

    @Transactional
    public boolean delete(UUID id) {
        return bookRepository.findById(id).map(Book -> {
            bookRepository.delete(Book);
            return true;
        }).orElse(false);
    }
}