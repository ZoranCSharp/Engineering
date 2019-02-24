package com.fakultet.software.spring;

import java.util.List;


public class Professor {
	private String name;
	private Faculty faculty;
	private List<String> subjectsProfessor;
	
	public Professor() {
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	

	public List<String> getSubjectsProfessor() {
		return subjectsProfessor;
	}

	public void setSubjectsProfessor(List<String> subjectsProfessor) {
		this.subjectsProfessor = subjectsProfessor;
	}

	
	public void addSubject(String subject)throws Exception{
		if((faculty.getSubjectsFaculty().contains(subject))&&(!subjectsProfessor.contains(subject))){
			subjectsProfessor.add(subject);
		}else if(subjectsProfessor.contains(subject))
			throw new Exception("Subject is already in the list");
		else
			throw new Exception("Subject doesn't exist on faculty");
			
		
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" from "+faculty.getName() + " on address " + faculty.getAddress());
		sb.append(" containing:\n");
		for (String s: subjectsProfessor){
			sb.append(s);
			sb.append("\n");
		}
		return sb.toString();
	}	
	

}
