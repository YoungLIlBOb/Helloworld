package com.czxy.score.service.impl;

import com.czxy.score.dao.LogMapper;
import com.czxy.score.domain.Log;
import com.czxy.score.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logMapper;

    @Override
    public void add(Log log) {
        logMapper.insert(log);
    }
}
