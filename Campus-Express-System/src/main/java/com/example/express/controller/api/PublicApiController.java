package com.example.express.controller.api;

import com.example.express.common.util.StringUtils;
import com.example.express.domain.ResponseResult;
import com.example.express.domain.bean.DataCompany;
import com.example.express.domain.bean.DataNotice;
import com.example.express.domain.bean.DataSchool;
import com.example.express.domain.dto.UserLoginDto;
import com.example.express.domain.enums.ResponseErrorCodeEnum;
import com.example.express.domain.vo.DataAreaVO;
import com.example.express.domain.vo.OrderDescVO;
import com.example.express.service.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API公开信息
 */
@RestController
@RequestMapping("/api/v1/public")
public class PublicApiController {
    @Autowired
    private DataAreaService dataAreaService;
    @Autowired
    private DataSchoolService dataSchoolService;
    @Autowired
    private DataCompanyService dataCompanyService;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private DataNoticeService dataNoticeService;
    @Autowired
    private AipService aipService;

    /**
     * 根据父ID查询行政区划
     * @param id 父ID
     */
    @GetMapping("/area/{id}/child")
    public ResponseResult getAreaDataByParentId(@PathVariable String id) {
        Integer parentId = StringUtils.toInteger(id);
        if(parentId == -1) {
            return ResponseResult.failure(ResponseErrorCodeEnum.PARAMETER_ERROR);
        }

        List<DataAreaVO> areas = dataAreaService.listByParentIdByCache(parentId);

        return ResponseResult.success(areas);
    }

    /**
     * 根据省份ID查询学校
     * @param id 省份ID
     */
    @GetMapping("/school/province/{id}")
    public ResponseResult getSchoolByProvinceId(@PathVariable String id) {
        Integer provinceId = StringUtils.toInteger(id);
        if(provinceId == -1) {
            return ResponseResult.failure(ResponseErrorCodeEnum.PARAMETER_ERROR);
        }

        List<DataSchool> schools = dataSchoolService.listByProvinceIdByCache(provinceId);

        return ResponseResult.success(schools);
    }

    /**
     * 读取快递公司数据
     */
    @GetMapping("/company")
    public ResponseResult listCompany() {
        List<DataCompany> list = dataCompanyService.listAllByCache();
        return ResponseResult.success(list);
    }

    /**
     * 读取公告数据
     */
    @GetMapping("/notice")
    public ResponseResult listNotice() {
        List<DataNotice> list = dataNoticeService.listAll();
        return ResponseResult.success(list);
    }
    /**
     * 获取订单信息
     * - 管理员：任何订单
     * - 派送员：已接的单
     * - 用户：个人订单
     */
    @GetMapping("/order/info/{id}")
    public ResponseResult getOrderDesc(@PathVariable String id) {
        OrderDescVO descVO = orderInfoService.getDescVO(id);
        if(descVO == null) {
            return ResponseResult.failure(ResponseErrorCodeEnum.ORDER_NOT_EXIST);
        }
        return ResponseResult.success(descVO);
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseResult phoneLogin(@RequestBody UserLoginDto userLoginDto){
        if (userLoginDto.getUsername().isEmpty() || userLoginDto.getPassword().isEmpty()) {
            return ResponseResult.failure(ResponseErrorCodeEnum.PARAMETER_ERROR);
        }
        return ResponseResult.success();
    }
}
