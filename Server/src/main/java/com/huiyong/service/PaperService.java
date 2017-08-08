/**
 * 
 */
package com.huiyong.service;

import com.huiyong.model.PaperTest;

/**
 * @author gangpu
 *
 */
public interface PaperService {
	public PaperTest getPaperById(int id);

	/**
	 * @param id
	 * @param property
	 * @return
	 */
	public PaperTest getPaperByIdAndUserProperty(int id, String property);
}
