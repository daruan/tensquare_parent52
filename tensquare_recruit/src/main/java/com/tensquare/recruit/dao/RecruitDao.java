package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by daruan on 2019/5/30.
 */
public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {

    public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);//where state=? order by createtime
    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);//where state != ? order by createtime

}
