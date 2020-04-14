package com.example.express.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.express.domain.bean.DataCompany;
import com.example.express.domain.vo.BootstrapTableVO;

import java.util.List;

public interface DataCompanyService extends IService<DataCompany> {
    List<DataCompany> listAll();

    List<DataCompany> listAllByCache();

    List<DataCompany> listAllByNameOrCode(String name, String code);

    DataCompany getByCache(Integer id);

    BootstrapTableVO<DataCompany> pageDataCompanyVO(Page<DataCompany> dataCompanyPage);
}
