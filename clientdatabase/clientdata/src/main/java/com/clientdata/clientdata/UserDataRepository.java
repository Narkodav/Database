package com.clientdata.clientdata;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Long> {
    List<UserData> findByUserId(Long userId);
}
