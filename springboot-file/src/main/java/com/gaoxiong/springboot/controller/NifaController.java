package com.gaoxiong.springboot.controller;

import com.gaoxiong.springboot.util.NifaUtil;
import freemarker.template.utility.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author gaoxiong
 * @ClassName NifaController
 * @Description TODO
 * @date 2018/9/23 15:20
 */
@Controller
@RequestMapping("/nifa")
public class NifaController {
    private static final String ROOT_DICTIONARY = File.separator+"opt"+File.separator+"datafile"+File.separator ;
    private static final String ZIP_FOLDER = "zip";
    private static final String DEBT_FOLDERNAME = "debt";
    private static final String DEBT_PROJECT_INFO_FILENAME = "24EXPORTBUSINESSZHAIQ.txt";
    private static final String DEBT_BOR_INFO_FILENAME = "24EXPORTBUSINESSZHAIQ_BOR.txt";
    private static final String DEBT_INV_INFO_FILENAME = "24EXPORTBUSINESSZHAIQ_INV.txt";

    private static final String TRANS_FOLDERNAME = "trans";
    private static final String TRANS_PROJECT_INFO_FILENAME = "26EXPORTBUSINESSJINR.txt";
    private static final String TRANS_INV_INFO_FILENAME = "26EXPORTBUSINESSJINR_INV.txt" ;

    @RequestMapping(value = "/generate",method = RequestMethod.POST)
    @ResponseBody
    public Date generatetFile( String reportDate) {
        DateUtil.TrivialCalendarFieldsToDateConverter dateConverter = new DateUtil.TrivialCalendarFieldsToDateConverter();
        Date date = null;
        try {
            date = DateUtil.parseISO8601Date(reportDate, TimeZone.getTimeZone("GMT+8"), dateConverter);
        } catch (DateUtil.DateParseException e) {
            e.printStackTrace();
        }

//        String dataDate = DateUtil.getStringDate(date, "yyyyMMdd");
        String dateFolderName = reportDate;
//        DebtFinancingProjectInfoExample projectInfoExample = new DebtFinancingProjectInfoExample();
//        projectInfoExample.or().andDataDateEqualTo(dataDate);
//        List<DebtFinancingProjectInfo> projectInfos = debtFinancingProjectInfoMapper.selectByExample(projectInfoExample);
        //获得文件路径
        String debtProjectInfoPath = getFilePath(dateFolderName, DEBT_FOLDERNAME, DEBT_PROJECT_INFO_FILENAME);
        //创建文件
        NifaUtil.createFile(debtProjectInfoPath);

        return date;
    }

    private String getFilePath ( String dateFolderName , String fileType, String fileName) {
        return ROOT_DICTIONARY +dateFolderName+File.separator+fileType +File.separator+fileName;
    }
}
