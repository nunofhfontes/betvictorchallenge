package com.challenge.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="summary")
public class Summary implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonIgnore
	@Column(name="id")
	@SequenceGenerator(name = "summary_id_seq", sequenceName = "summary_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "summary_id_seq")
	private Integer id;
	
	@JsonIgnore
	@Transient
	private int totalNrOfParagraphs;
	
	@JsonIgnore
	@Column(name="insertiondate")
	private Timestamp insertionDate;
	
	@JsonIgnore
	@Transient
	private ConcurrentMap<String, Integer> wordsMap = new ConcurrentHashMap<>();
	
	@JsonIgnore
	@Transient
	private ConcurrentMap<String, Double> totalDurationInSeconds = new ConcurrentHashMap<>();
	
	@JsonProperty("freq_word")
	@Column(name="freqword")
	private String freqWord;
	
	@JsonProperty("avg_paragraph_size")
	@Column(name="avgparagrize")
	private Double avgParagrize;
	
	@JsonProperty("avg_paragraph_processing_time")
	@Column(name="avgparagproctime")
	private Double avgParagProcTime;

	@JsonProperty("total_processing_time")
	@Column(name="totalprocessingtime")
	private Double totalProcessingTime;
	
	
	@Override
	public String toString() {
		//return ToStringBuilder.reflectionToString(this);
		
		return "\n " + "id -> "+this.id + " \n " +
			   "insertionDate -> "+this.insertionDate.toString() + " \n " +
			   "avgParagrize -> "+this.avgParagrize + " \n " +
			   "avgParagProcTime -> "+this.avgParagProcTime + " \n " +
			   "avgParagProcTime -> "+this.avgParagProcTime + " \n " +
			   "totalProcessingTime -> "+this.totalProcessingTime + " \n ";
	}
	
	//getters & setters
	public int getTotalNrOfParagraphs() {
		return totalNrOfParagraphs;
	}

	public Integer getId() {
		return id;
	}

	public void setTotalNrOfParagraphs(int totalNrOfParagraphs) {
		this.totalNrOfParagraphs = totalNrOfParagraphs;
	}

	public Timestamp getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Timestamp insertionDate) {
		this.insertionDate = insertionDate;
	}

	public String getFreqWord() {
		return freqWord;
	}

	public void setFreqWord(String freqWord) {
		this.freqWord = freqWord;
	}

	public Double getAvgParagrize() {
		return avgParagrize;
	}

	public void setAvgParagrize(Double avgParagrize) {
		this.avgParagrize = avgParagrize;
	}

	public Double getAvgParagProcTime() {
		return avgParagProcTime;
	}

	public void setAvgParagProcTime(Double avgParagProcTime) {
		this.avgParagProcTime = avgParagProcTime;
	}

	public Double getTotalProcessingTime() {
		return totalProcessingTime;
	}

	public void setTotalProcessingTime(Double totalProcessingTime) {
		this.totalProcessingTime = totalProcessingTime;
	}

	public ConcurrentMap<String, Integer> getWordsMap() {
		return wordsMap;
	}

	public void setWordsMap(ConcurrentMap<String, Integer> wordsMap) {
		this.wordsMap = wordsMap;
	}

	public ConcurrentMap<String, Double> getTotalDurationInSeconds() {
		return totalDurationInSeconds;
	}

	public void setTotalDurationInSeconds(ConcurrentMap<String, Double> totalDurationInSeconds) {
		this.totalDurationInSeconds = totalDurationInSeconds;
	}

}
