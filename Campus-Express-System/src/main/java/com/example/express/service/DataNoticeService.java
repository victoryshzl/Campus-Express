package com.example.express.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.express.domain.bean.DataCompany;
import com.example.express.domain.bean.DataNotice;
import com.example.express.domain.vo.BootstrapTableVO;

import java.util.List;

public interface DataNoticeService extends IService<DataNotice> {

    List<DataNotice> listAll();

    BootstrapTableVO<DataNotice> pageDataNoticeVO(Page<DataNotice> dataNoticePage);
}
