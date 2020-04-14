package com.example.express.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.express.domain.bean.VCompanyOrder;
import com.example.express.domain.bean.VUserOrder;
import com.example.express.domain.bean.VUserPayment;
import com.example.express.domain.vo.BootstrapTableVO;

public interface ExcelReportService  {
    BootstrapTableVO<VUserOrder> pageVUserOrderVO(Page<VUserOrder> vUserOrderPage);
    BootstrapTableVO<VUserPayment> pageVUserPaymentVO(Page<VUserPayment> vUserPaymentPage);
    BootstrapTableVO<VCompanyOrder> pageVCompanyOrderVO(Page<VCompanyOrder> vCompanyOrderPage);
}
