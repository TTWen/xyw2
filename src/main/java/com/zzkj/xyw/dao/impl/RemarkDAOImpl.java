package com.zzkj.xyw.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzkj.xyw.dao.IRemarkDAO;
import com.zzkj.xyw.model.Remark;

@Repository("remarkDao")
public class RemarkDAOImpl extends BaseDAOImpl<Remark, String> implements
		IRemarkDAO {

}
