package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created with IDEA
 * author:ruanlinyu
 * Date:2019/6/3
 * Time:22:27
 */
public interface SpitDao extends MongoRepository<Spit,String> {

    public Page<Spit> findByParentId(String parentId, Pageable pageable);
}
