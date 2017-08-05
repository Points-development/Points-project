/**
 * 
 */
package com.huiyong.model;

import java.util.Set;

/**
 * @author gangpu
 *
 */
public class PaperTest {
	private String id;
	private String name;
	private Set<PaperQuestion> questions;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<PaperQuestion> getQuestions() {
		return questions;
	}
	public void setSections(Set<PaperQuestion> questions) {
		this.questions = questions;
	} 
}
