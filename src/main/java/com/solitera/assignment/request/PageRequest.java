package com.solitera.assignment.request;

import com.solitera.assignment.constant.CommonConstant;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class PageRequest {
    private String name;
    private String username;
    private CommonConstant.Role  role;
    private String category;
    public PageRequest(@RequestParam(name = CommonConstant.QUERY_PARAM_NAME, required = false) String name,
                       @RequestParam(name = CommonConstant.QUERY_PARAM_USERNAME, required = false) String username,
                       @RequestParam(name = CommonConstant.QUERY_PARAM_CATEGORY, required = false) String category,
                       @RequestParam(name = CommonConstant.QUERY_PARAM_ROLE, required = false) CommonConstant.Role role) {
        this.name = name;
        this.username = username;
        this.category = category;
        this.role = role;
    }


}
