package org.hopen.core;

import java.util.Properties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class SysPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	@Override 
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) 
                    throws BeansException {
            super.processProperties(beanFactory, props); 
    } 
}
