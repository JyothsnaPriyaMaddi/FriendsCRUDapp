package com.jyothsna.repositories;

import com.jyothsna.entity.MyFriends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyFriendsRepository extends JpaRepository<MyFriends, Integer> {
}
