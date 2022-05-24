package com.liujie.service;

import com.liujie.model.SmbmsBill;

import java.util.List;

public interface SmbmsBillService {
    List<SmbmsBill> queryByName(String pname);

}

