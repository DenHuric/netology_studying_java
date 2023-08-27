package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// Stub
public class PostRepository {

  private final ConcurrentHashMap<Long, Post> repositoryCollection = new ConcurrentHashMap<>();
  private final AtomicLong atomicLong = new AtomicLong();


  public List<Post> all() {
    return Collections.emptyList();
  }

  public Optional<Post> getById(long id) {
    return Optional.empty();
  }

  public Post save(Post post) {
    if (post.getId() == 0) {
      long id = atomicLong.incrementAndGet();
      post.setId(id);
      repositoryCollection.put(id, post);
    } else if (post.getId() != 0) {
      repositoryCollection.replace(post.getId(), post);
      if (!repositoryCollection.contains(post)) {
        throw new NotFoundException("Нельзя добавить элемент с номером != 0");
      }
    }
    return post;
  }

  public void removeById(long id) {
    repositoryCollection.remove(id);
  }
}
