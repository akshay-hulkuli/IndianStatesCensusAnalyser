package com.bridgelabz.censusanalyser;
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
	
}
