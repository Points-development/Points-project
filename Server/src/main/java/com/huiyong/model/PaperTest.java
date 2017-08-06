/**
 * 
 */
package com.huiyong.model;

import java.util.List;

/**
 * @author gangpu
 *
 */
public class PaperTest {
	private Integer id;
	private String name;
	private List<PaperQuestion> questions;
	private List<PaperOption> options;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PaperQuestion> getQuestions() {
		return questions;
	}
	public void setSections(List<PaperQuestion> questions) {
		this.questions = questions;
	}
	public List<PaperOption> getOptions() {
		return options;
	}
	public void setOptions(List<PaperOption> options) {
		this.options = options;
	}
	public void setQuestions(List<PaperQuestion> questions) {
		this.questions = questions;
	} 
}
