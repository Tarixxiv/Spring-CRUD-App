package com.example.auiplanet.star.repository;

import com.example.auiplanet.star.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface StarRepository extends JpaRepository<Star, UUID> {

}
