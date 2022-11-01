package jjfactory.movieaward.biz.review.repository;

import jjfactory.movieaward.biz.review.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
