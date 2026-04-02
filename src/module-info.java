/**
 * 
 */
/**
 * @author paul
 *
 */
module PhDThesisCode {
	exports thesis;
	requires org.eclipse.core.resources;
//	requires lpg.runtime.java;
////	requires org.eclipse.ocl.xtext.base;
////	requires org.eclipse.ocl.xtext.oclstdlib;
//	requires org.eclipse.ocl.xtext.oclinecore;
//	requires org.eclipse.ocl;
//	requires org.eclipse.ocl.ecore;
//	requires org.eclipse.ocl.common;
//	requires org.eclipse.ocl.pivot;
	requires org.eclipse.emf.henshin.interpreter;
	requires org.eclipse.emf.henshin.model;
	requires org.eclipse.emf.henshin.statespace;
	requires org.eclipse.emf.ecore;
	requires org.eclipse.emf.ecore.xmi;
	requires org.eclipse.emf.common;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.annotation;
	requires org.openjdk.nashorn;
	requires org.objectweb.asm.util;
	requires org.objectweb.asm.tree;
	requires org.objectweb.asm.commons;
	requires org.objectweb.asm;
	requires org.objectweb.asm.tree.analysis;
	requires owlapi.distribution;
	requires org.slf4j;
	requires org.slf4j.simple;
//	requires org.apache.logging.log4j;
//	requires org.apache.logging.log4j.core;
	requires org.semanticweb.hermit;
	requires org.apache.commons.rdf.api;
	requires lombok;
	requires org.apache.commons.lang3;
	requires com.google.common;
	requires org.apache.commons.io;
	requires jcommander;
	requires commons.math3;
}