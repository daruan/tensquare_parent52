package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IDEA
 * author:ruanlinyu
 * Date:2019/6/3
 * Time:22:32
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {
    @Autowired
    private SpitService spitService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功", spitService.findAll());
    }

    @RequestMapping(value = "/{spitId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("spitId") String spitId){
        return new Result(true, StatusCode.OK, "查询成功", spitService.findById(spitId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Spit spit){
        spitService.save(spit);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.PUT)
    public Result update(@PathVariable("spitId") String spitId, @RequestBody Spit spit){
        spit.set_id(spitId);
        spitService.update(spit);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    @RequestMapping(value = "/{spitId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("spitId") String spitId){
        spitService.deleteById(spitId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/common/{parentId}/{page}/{size}",method = RequestMethod.GET)
    public Result findByParentId(@PathVariable String parentId, @PathVariable int page, @PathVariable int size){
        Page<Spit> spitPage = spitService.findByParentId(parentId,page,size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult(spitPage.getTotalElements(),spitPage.getContent()));
    }

}
