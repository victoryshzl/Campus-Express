package com.example.express.controller.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.express.domain.bean.VCompanyOrder;
import com.example.express.domain.bean.VUserOrder;
import com.example.express.domain.bean.VUserPayment;
import com.example.express.domain.vo.BootstrapTableVO;
import com.example.express.service.ExcelReportService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/report")
public class ExcelReportApiController {

    @Resource
    private ExcelReportService excelReportService;

    /**
     * 获取派送员绩效列表
     */
    @GetMapping("/VUserPayment-list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public BootstrapTableVO<VUserPayment> listVUserPayment(@RequestParam(required = false, defaultValue = "1") Integer current,
                                                      @RequestParam(required = false, defaultValue = "10") Integer size) {
        return excelReportService.pageVUserPaymentVO(new Page<>(current, size));
    }

    /**
     * 获取派送员订单列表
     */
    @GetMapping("/VUserOrder-list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public BootstrapTableVO<VUserOrder> listVUserOrder(@RequestParam(required = false, defaultValue = "1") Integer current,
                                                         @RequestParam(required = false, defaultValue = "10") Integer size) {
        return excelReportService.pageVUserOrderVO(new Page<>(current, size));
    }

    /**
     * 获取公司订单列表
     */
    @GetMapping("/VCompanyOrder-list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public BootstrapTableVO<VCompanyOrder> listVCompanyOrder(@RequestParam(required = false, defaultValue = "1") Integer current,
                                                            @RequestParam(required = false, defaultValue = "10") Integer size) {
        return excelReportService.pageVCompanyOrderVO(new Page<>(current, size));
    }
}
