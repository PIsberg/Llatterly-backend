package com.google.devrel.training.conference.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class VideoData {
	@Id String videoId;
	String youtubeId;
	long startTime;
	long pauseTime;
	long stopTime;
	
	int correctAnswer;
	
	String question, answer1, answer2, answer3, answer4; //TODO: use array[4]
	
	private VideoData() {}
	    
    public VideoData(String videoId, String youtubeId, long startTime, long pauseTime, long stopTime,
			int correctAnswer, String question, String answer1, String answer2,
			String answer3, String answer4) {
		
		this.videoId = videoId;
		this.youtubeId = youtubeId;
		this.startTime = startTime;
		this.pauseTime = pauseTime;
		this.stopTime = stopTime;
		this.correctAnswer = correctAnswer;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
	}


	public String getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}

	public String getVideoId() {
		return videoId;
	}


	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}


	public long getStartTime() {
		return startTime;
	}


	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}


	public long getPauseTime() {
		return pauseTime;
	}


	public void setPauseTime(long pauseTime) {
		this.pauseTime = pauseTime;
	}


	public long getStopTime() {
		return stopTime;
	}


	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
	}


	public int getCorrectAnswer() {
		return correctAnswer;
	}


	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer1() {
		return answer1;
	}


	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}


	public String getAnswer2() {
		return answer2;
	}


	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}


	public String getAnswer3() {
		return answer3;
	}


	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}


	public String getAnswer4() {
		return answer4;
	}


	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}


    

}
