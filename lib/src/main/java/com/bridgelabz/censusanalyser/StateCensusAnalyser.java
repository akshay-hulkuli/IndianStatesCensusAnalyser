package com.bridgelabz.censusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {
	
	private static List<CSVStateCensus>csvFileList = new ArrayList<>();
	
	
	public int loadIndianCensusData(String csvFilePath) {
		int numberOfEntries = 0;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusCSVIterator=csvToBean.iterator();

    		while(censusCSVIterator.hasNext()) {
    			numberOfEntries++;
    			censusCSVIterator.next();
    		}
		}
		catch (IOException e) {
		}
		return numberOfEntries;
	}
}