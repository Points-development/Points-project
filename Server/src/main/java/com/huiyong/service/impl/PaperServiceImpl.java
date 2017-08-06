/**
 * 
 */
package com.huiyong.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huiyong.dao.PaperMapper;
import com.huiyong.model.PaperTest;
import com.huiyong.service.PaperService;

/**
 * @author gangpu
 *
 */
@Service
public class PaperServiceImpl implements PaperService {
	@Autowired
	private PaperMapper paperDao;

	/* (non-Javadoc)
	 * @see com.huiyong.service.PaperService#getPaperById(int)
	 */
	@Override
	public PaperTest getPaperById(int id) {
		return paperDao.getPaperById(id);
	}

}
