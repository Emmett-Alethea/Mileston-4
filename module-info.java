/**
 * 
 */
/**
 * 
 */
module Milestone {
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.annotation;
	exports app;
	opens app to com.fasterxml.jackson.databind;
}