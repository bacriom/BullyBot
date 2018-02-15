package com.bullybot.bullybot.repository;

import com.bullybot.bullybot.models.Chanel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChanelRepository extends JpaRepository<Chanel,String> {
    List<Chanel> findBySlackIdChanel (String victim);
}
