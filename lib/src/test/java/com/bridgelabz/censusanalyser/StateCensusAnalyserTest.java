package com.bridgelabz.censusanalyser;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.bridgelabz.censusanalyser.StateCensusAnalyser;
public class StateCensusAnalyserTest {
	private static final String CORRECT_CSV_FILE_PATH = "resources/IndianStateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH = "resources/test/IndianStateCensusData.csv";
	private static final String INCORRECT_FILE_FORMAT = "resources/IncorrectFileFormat.txt";
	private static final String CSV_WITH_WRONG_DELIMITER = "./src/test/resources/CensusDataWithWrongDelimiter.csv";
	private static final String CSV_WITH_INCORRECT_HEADER = "./src/test/resources/CensusDataIncorrectHeader.csv";
	@Test
	public void givenIndianCensusCSVFile_WhenCorrect_ReturnsNumberOfRows() {
		try {	
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			int rows = stateCensusAnalyser.loadIndianCensusData(CORRECT_CSV_FILE_PATH);
			Assert.assertEquals(29,rows);
		}
		catch(CensusAnalyserException e) {
			
		}
	}
	
	@Test
	public void givenIndianCensusCSVFile_WhenWrongPath_ReturnsException() {
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			int rows = stateCensusAnalyser.loadIndianCensusData(WRONG_CSV_FILE_PATH);
		}
		catch( CensusAnalyserException e) {
			e.getMessage();
		}
	}
	
	@Test
	public void givenIndianCensusCSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException() {	
		try {
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			int rows = stateCensusAnalyser.loadIndianCensusData(INCORRECT_FILE_FORMAT);
		} 
		catch (CensusAnalyserException e) {
			e.getMessage();
			assertEquals(e.type, CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
		}
	}
	
	@Test
	public void givenWrongDelimiter_InIndiaCensusData_ShouldReturnCustomExceptionType() {
	    try {
	    	StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			int rows = stateCensusAnalyser.loadIndianCensusData(CSV_WITH_WRONG_DELIMITER);
	    } catch (CensusAnalyserException e) {
	    	assertEquals(e.type, CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
	    }
	}
	
}
