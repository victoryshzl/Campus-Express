package com.example.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.express.domain.bean.VCompanyOrder;
import com.example.express.domain.bean.VUserOrder;
import com.example.express.domain.bean.VUserPayment;
import com.example.express.domain.vo.BootstrapTableVO;
import com.example.express.mapper.VCompanyOrderMapper;
import com.example.express.mapper.VUserOrderMapper;
import com.example.express.mapper.VUserPaymentMapper;
import com.example.express.service.ExcelReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class ExcelReportServiceImpl implements ExcelReportService {

    @Resource
    private VUserOrderMapper vUserOrderMapper;
    @Resource
    private VCompanyOrderMapper vCompanyOrderMapper;
    @Resource
    private VUserPaymentMapper vUserPaymentMapper;

    @Override
    public BootstrapTableVO<VUserOrder> pageVUserOrderVO(Page<VUserOrder> vUserOrderPage) {
        IPage<VUserOrder> selectPage = vUserOrderMapper.selectPage(vUserOrderPage, new QueryWrapper<>());
        BootstrapTableVO<VUserOrder> result = new BootstrapTableVO<>();
        result.setTotal(selectPage.getTotal());
        result.setRows(selectPage.getRecords());
        return result;
    }

    @Override
    public BootstrapTableVO<VUserPayment> pageVUserPaymentVO(Page<VUserPayment> vUserPaymentPage) {
        IPage<VUserPayment> selectPage = vUserPaymentMapper.selectPage(vUserPaymentPage, new QueryWrapper<>());
        BootstrapTableVO<VUserPayment> result = new BootstrapTableVO<>();
        result.setTotal(selectPage.getTotal());
        result.setRows(selectPage.getRecords());
        return result;
    }

    @Override
    public BootstrapTableVO<VCompanyOrder> pageVCompanyOrderVO(Page<VCompanyOrder> vCompanyOrderPage) {
        IPage<VCompanyOrder> selectPage = vCompanyOrderMapper.selectPage(vCompanyOrderPage, new QueryWrapper<>());
        BootstrapTableVO<VCompanyOrder> result = new BootstrapTableVO<>();
        result.setTotal(selectPage.getTotal());
        result.setRows(selectPage.getRecords());
        return result;
    }
}
