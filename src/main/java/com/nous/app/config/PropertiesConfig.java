/**
 * 
 */
package com.nous.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * @author mohanavelp
 *
 */
@PropertySources({
    @PropertySource("classpath:secondary.properties")
})
@Component
public class PropertiesConfig {

	@Value("${file.path}")
	private String secondaryFilePath;

	/**
	 * @return the secondaryFilePath
	 */
	public String getSecondaryFilePath() {
		return secondaryFilePath;
	}

	/**
	 * @param secondaryFilePath the secondaryFilePath to set
	 */
	public void setSecondaryFilePath(String secondaryFilePath) {
		this.secondaryFilePath = secondaryFilePath;
	}
	
}
