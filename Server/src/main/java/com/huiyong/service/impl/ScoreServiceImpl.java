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
import com.huiyong.model.score.Score;
import com.huiyong.model.score.ScoreItemResult;
import com.huiyong.model.score.ScorePoint;
import com.huiyong.service.ScoreService;
//import com.huiyong.util.DateUtil;

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
	public boolean addScore(Score score) {	
		List<Score> aScoreList = scoreDao.getScoreByScorer(score.getScoree(), score.getScorer(), true);
		if(null != aScoreList && aScoreList.size() > 0){
			Score aScore = aScoreList.get(0);
			int scoreId = aScore.getId();
			score.setId(scoreId);
			//if(aScore.getLastModifiedTime().after(DateUtil.getLastMonthDate(score.getLastModifiedTime()))){
			scoreDao.updateScore(score);
			scoreItemResultDao.deleteScoreItemResult(scoreId);
			for (ScoreItemResult sir : score.getScores()) {
				sir.setScoreId(scoreId);
			}
			scoreItemResultDao.addBatchItemResult(score.getScores());
			return true;
		}
		scoreDao.addScore(score);
		int scoreId=score.getId();
		for(ScoreItemResult sir : score.getScores()){
			sir.setScoreId(scoreId);
		}
		scoreItemResultDao.addBatchItemResult(score.getScores());
		return true;
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.ScoreService#getSelfScorePoint(java.lang.String)
	 */
	@Override
	public Integer getSelfScorePoint(String username) {
		return scoreDao.getSelfScorePoint(username);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.ScoreService#getOtherScorePoint(java.lang.String)
	 */
	@Override
	public Integer getOtherScorePoint(String username) {
		return scoreDao.getOtherScorePoint(username);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.ScoreService#getScorePointByBranch(java.lang.String)
	 */
	@Override
	public List<ScorePoint> getScorePointByBranch(String branch) {
		return scoreDao.getScorePointByBranch(branch);
	}

	/* (non-Javadoc)
	 * @see com.huiyong.service.ScoreService#getScorePointByBranchAndScorer(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ScorePoint> getScorePointByBranchAndScorer(String branch, String scorer) {
		return scoreDao.getScorePointByBranchAndScorer(branch, scorer);
	}

}
