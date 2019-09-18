package com.amazon.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class RetryAnalyzer implements IRetryAnalyzer, IAnnotationTransformer{
	
	int counter=0;
	int retrylimit=2;
	
	public boolean retry(ITestResult result) {
		
		 if(counter<retrylimit) {
			 counter++;
			 return true;
		 }
		 return false;
	}
	
	public void transform(ITestAnnotation annotation, Class testcases, Constructor testconstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
	

	
}
