package com.example.express.controller.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.express.domain.ResponseResult;
import com.example.express.domain.bean.DataCompany;
import com.example.express.domain.enums.ResponseErrorCodeEnum;
import com.example.express.domain.vo.BootstrapTableVO;
import com.example.express.service.DataCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyApiController {

    @Autowired
    private DataCompanyService dataCompanyService;
    /**
     * 获取快递公司列表
     */
    @GetMapping("/company-list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public BootstrapTableVO<DataCompany> listCompany(@RequestParam(required = false, defaultValue = "1") Integer current,
                                                     @RequestParam(required = false, defaultValue = "10") Integer size) {
        return dataCompanyService.pageDataCompanyVO(new Page<>(current, size));
    }

    /**
     * 删除公司
     */
    @PostMapping("/{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseResult deleteCompany(@PathVariable String id) {
        DataCompany dataCompany = dataCompanyService.getById(id);
        if(dataCompanyService.removeById(dataCompany)) {
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResponseErrorCodeEnum.OPERATION_ERROR);
        }
    }

    /**
     * 新增公司
     */
    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseResult addCompany(String name, String code) {
        List<DataCompany> dataCompanyList = dataCompanyService.listAllByNameOrCode(name, code);
        if (dataCompanyList.isEmpty()) {
            DataCompany dataCompany = DataCompany.builder().code(code).name(name).build();
            dataCompanyService.save(dataCompany);
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResponseErrorCodeEnum.OPERATION_ERROR);
        }
    }
}
