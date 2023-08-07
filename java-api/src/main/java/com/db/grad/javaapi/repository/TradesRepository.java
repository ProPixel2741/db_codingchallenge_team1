package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import com.db.grad.javaapi.model.Trade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradesRepository extends JpaRepository<Trade, Integer> {
    // Intentionally blank
    @Query(
            nativeQuery = true,
            value = "select * from trade t, book b, book_user bu, users u " +
                    "where username=:uname and u.id = bu.user_id and bu.book_id = b.id and t.book_id = b.id"
    )
    List<Trade> findTradesByUsername(String uname);

}
