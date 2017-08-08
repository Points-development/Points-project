/**
 * 
 */
package com.huiyong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huiyong.dao.PaperMapper;
import com.huiyong.model.PaperQuestion;
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

	/* (non-Javadoc)
	 * @see com.huiyong.service.PaperService#getPaperByIdAndUserProperty(int, java.lang.String)
	 */
	@Override
	public PaperTest getPaperByIdAndUserProperty(int id, String property) {
		PaperTest pt = null;
		pt = paperDao.getPaperByIdAndUserProperty(id);
		if(null != pt){
			List<PaperQuestion> qList = paperDao.getQuestionsByIdAndProperty(id, property);
			pt.setQuestions(qList);			
		}
		return pt;
	}

}
