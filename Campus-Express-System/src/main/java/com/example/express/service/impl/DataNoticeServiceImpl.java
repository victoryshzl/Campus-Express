package com.example.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.express.domain.bean.DataNotice;
import com.example.express.domain.vo.BootstrapTableVO;
import com.example.express.mapper.DataNoticeMapper;
import com.example.express.service.DataNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class DataNoticeServiceImpl extends ServiceImpl<DataNoticeMapper, DataNotice> implements DataNoticeService {
    @Resource
    private DataNoticeMapper dataNoticeMapper;

    @Override
    public List<DataNotice> listAll() {
        QueryWrapper<DataNotice> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        return dataNoticeMapper.selectList(wrapper);
    }

    @Override
    public BootstrapTableVO<DataNotice> pageDataNoticeVO(Page<DataNotice> dataNoticePage) {
        IPage<DataNotice> selectPage = dataNoticeMapper.selectPage(dataNoticePage, new QueryWrapper<>());
        BootstrapTableVO<DataNotice> result = new BootstrapTableVO<>();
        result.setTotal(selectPage.getTotal());
        result.setRows(selectPage.getRecords());
        return result;
    }

}
