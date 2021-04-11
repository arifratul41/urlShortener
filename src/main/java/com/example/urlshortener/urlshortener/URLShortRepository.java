package com.example.urlshortener.urlshortener;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  URLShortRepository extends JpaRepository <URLMap, Long>{
    List<URLMap> findByMapurl(String mapurl);
}
