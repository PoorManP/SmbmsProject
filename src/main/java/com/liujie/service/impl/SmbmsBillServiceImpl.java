package com.liujie.service.impl;

import com.liujie.dao.SmbmsBillMapper;
import com.liujie.model.SmbmsBill;
import com.liujie.service.SmbmsBillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("smbmsBillService")
public class SmbmsBillServiceImpl implements SmbmsBillService {

    @Resource
    SmbmsBillMapper billMapper;

    @Override
    public List<SmbmsBill> queryByName(String pname) {
        List<SmbmsBill> list = billMapper.queryByName(pname);

        if (list != null) {
            return list;
        }

        return null;
    }
}
