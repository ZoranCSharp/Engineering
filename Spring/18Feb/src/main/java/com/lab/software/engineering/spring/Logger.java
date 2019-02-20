package com.lab.software.engineering.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Logger {
	
	
	private ConsoleWriter consoleWriter;
	
	
	private FileWriter fileWriter;
	
//	@Autowired
//	private ConsoleWriter consoleWriter;
//	
//	@Autowired
//	private FileWriter fileWriter;
	
//	@Autowired
//	public Logger (ConsoleWriter consoleWriter, FileWriter fileWriter) {
//		
//		this.consoleWriter = consoleWriter;
//		this.fileWriter = fileWriter;
//	}
	
	
	
//	@Autowired
//	public void setFileWriter(FileWriter fileWriter) {
//		this.fileWriter = fileWriter;
//	}
//	
//	
//	@Autowired
//	public void setConsoleWriter(ConsoleWriter consoleWriter) {
//		this.consoleWriter = consoleWriter;
//	}
	

//	@Autowired
//	@Qualifier("writetoconsole")
//	public void setConsoleWriter(LogWriter consoleWriter) {
//		this.consoleWriter = consoleWriter;
//	}
//	@Autowired
//	@Qualifier("writetofile")
//	public void setFileWriter(LogWriter fileWriter) {
//		this.fileWriter = fileWriter;
//	}
	
	
	@Autowired
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	@Autowired
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}


	public void writeConsole(String text) {
		consoleWriter.write(text);
	}
	

	public void writeFile(String text) {
		
		fileWriter.write(text);
	}
	

}
