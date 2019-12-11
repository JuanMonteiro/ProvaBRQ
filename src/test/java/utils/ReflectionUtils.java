package utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.runner.Description;

import utils.annotations.Build;
import utils.annotations.Ct;
import utils.annotations.Project;
import utils.annotations.TestPlan;

public class ReflectionUtils {
	
	/**
	 * Este método coleta o meta-dado da annotation @Project e retorna o valor em string
	 * @author Fábio Vaz
	 * @since 15/10/2018
	 */
	public static String getProject(Description description) {
		
		String project = null;
		Method[] methods = description.getTestClass().getMethods();
		
		for(Method method : methods) {
			for(Annotation annotation : method.getAnnotations()) {
				if(annotation instanceof Project) {
					project = ((Project) annotation).value();
					break;
				}
			}
		}
		
		return project;
	}
	
	/**
	 * Este método coleta o meta-dado da annotation @Build e retorna o valor em string
	 * @author Fábio Vaz
	 * @since 15/10/2018
	 */
	public static String getBuild(Description description) {
		
		String build = null;
		Method[] methods = description.getTestClass().getMethods();
		
		for(Method method : methods) {
			for(Annotation annotation : method.getAnnotations()) {
				if(annotation instanceof Build) {
					build = ((Build) annotation).value();
					break;
				}
			}
		}
		
		return build;
	}
	
	/**
	 * Este método coleta o meta-dado da annotation @Ct e retorna o valor em string
	 * @author Fábio Vaz
	 * @since 15/10/2018
	 */
	public static String getCt(Description description) {
		
		String ct = null;
		Method[] methods = description.getTestClass().getMethods();
		
		for(Method method : methods) {
			for(Annotation annotation : method.getAnnotations()) {
				if(annotation instanceof Ct) {
					ct = ((Ct) annotation).value();
					break;
				}
			}
		}
		
		return ct;
	}
	
	/**
	 * Este método coleta o meta-dado da annotation @TestPlan e retorna o valor em string
	 * @author Fábio Vaz
	 * @since 15/10/2018
	 */
	public static String getTestPlan(Description description) {
		
		String testPlan = null;
		Method[] methods = description.getTestClass().getMethods();
		
		for(Method method : methods) {
			for(Annotation annotation : method.getAnnotations()) {
				if(annotation instanceof TestPlan) {
					testPlan = ((TestPlan) annotation).value();
					break;
				}
			}
		}
		
		return testPlan;
	}
	
}
