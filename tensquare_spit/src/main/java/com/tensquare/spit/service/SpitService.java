package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

/**
 * Created with IDEA
 * author:ruanlinyu
 * Date:2019/6/3
 * Time:22:28
 */
@Service
@Transactional
public class SpitService {
    @Autowired
    private SpitDao spitDao;
    @Autowired
    private IdWorker idWorker;

    public List<Spit> findAll(){
        return spitDao.findAll();
    }

    public Spit findById(String id){
        return spitDao.findById(id).get();
    }

    public void save(Spit spit){
        spit.set_id(idWorker.nextId() + "");
        spitDao.save(spit);
    }

    public void update(Spit spit){
        spitDao.save(spit);
    }

    public void deleteById(String id){
        spitDao.deleteById(id);
    }

    public Page<Spit> findByParentId(String parentId,int page, int size){
        Pageable pageable = PageRequest.of(page-1, size);
        return spitDao.findByParentId(parentId, pageable);
    }
}
