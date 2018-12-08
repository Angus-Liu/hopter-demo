package org.hopter.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.hopter.framework.annotation.Action;
import org.hopter.framework.annotation.Controller;
import org.hopter.framework.bean.Data;
import org.hopter.framework.bean.FileParam;
import org.hopter.framework.bean.Param;
import org.hopter.framework.enums.RequestMethod;
import org.hopter.framework.helper.UploadHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Angus
 * @date 2018/12/6
 */
@Slf4j
@Controller
public class FileController {

    @Action(method = RequestMethod.POST, path = "/file")
    public Data uploadFile(Param param) {
        log.debug("param: {}", param);
        Map<String, Object> fieldMap = param.getFieldMap();
        FileParam fileParam = param.getFile("file");
        UploadHelper.uploadFile("D:/Temp/", fileParam);
        Map<String, String> res = new HashMap<>();
        res.put("res", "OK");
        return new Data(res);
    }
}
