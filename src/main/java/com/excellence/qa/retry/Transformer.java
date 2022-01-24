package com.excellence.qa.retry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

//Implementing IAnnotationTransformer interface to user its method
public class Transformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		//Setting the Retry Analyzer
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
	
	

}
