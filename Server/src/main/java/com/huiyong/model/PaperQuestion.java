/**
 * 
 */
package com.huiyong.model;

import java.util.List;

/**
 * @author gangpu
 *
 */
public class PaperQuestion {
	private String id;
	private String description;
	private List<PaperOption> options;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<PaperOption> getOptions() {
		return options;
	}
	public void setOptions(List<PaperOption> options) {
		this.options = options;
	}
}
