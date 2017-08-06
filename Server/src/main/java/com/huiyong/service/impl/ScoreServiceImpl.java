/**
 * 
 */
package com.huiyong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huiyong.dao.ScoreItemResultMapper;
import com.huiyong.dao.ScoreMapper;
import com.huiyong.model.Score;
import com.huiyong.model.ScoreItemResult;
import com.huiyong.service.ScoreService;

/**
 * @author gangpu
 *
 */
@Service
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	private ScoreMapper scoreDao;
	
	@Autowired
	private ScoreItemResultMapper scoreItemResultDao;

	/* (non-Javadoc)
	 * @see com.huiyong.service.ScoreService#getScoreByUser(java.lang.String, boolean)
	 */
	@Override
	public List<Score> getScoreByUser(String username, boolean recent) {
		return scoreDao.getScoreByUser(username, recent);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.ScoreService#getScoreByScorer(java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public List<Score> getScoreByScorer(String username, String socrername, boolean recent) {
		return scoreDao.getScoreByScorer(username, socrername, recent);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.ScoreService#getScoreByOther(java.lang.String, boolean)
	 */
	@Override
	public List<Score> getScoreByOther(String username, boolean recent) {
		return scoreDao.getScoreByOther(username, recent);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.ScoreService#addScore(com.huiyong.model.Score)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void addScore(Score score) {	
		scoreDao.addScore(score);
		int scoreId=score.getId();
		for(ScoreItemResult sir : score.getScores()){
			sir.setScoreId(scoreId);
		}
		scoreItemResultDao.addBatchItemResult(score.getScores());
	}

}
