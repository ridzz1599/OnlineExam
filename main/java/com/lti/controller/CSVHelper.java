package com.lti.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.lti.pojo.Questions;

public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "QuestionNo","Question","Option1","Option2","Option3","Option4","Answer" };

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<Questions> csvToQuestions(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Questions> questions = new ArrayList<Questions>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
    	  Questions question = new Questions(
              csvRecord.get("Question"),
              csvRecord.get("Option1"),
              csvRecord.get("Option2"),
              csvRecord.get("Option3"),
              csvRecord.get("Option4"),
              csvRecord.get("Answer"),
              csvRecord.get("Level")
            );
    	  questions.add(question);
      }
      return questions;
      
    } catch (IOException e) {
      throw new RuntimeException("Fail to parse CSV file: " + e.getMessage());
    }
  }

}