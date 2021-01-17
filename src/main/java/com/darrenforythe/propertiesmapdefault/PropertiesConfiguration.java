package com.darrenforythe.propertiesmapdefault;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/** @author Darren.Forsythe@Liberty-IT.co.uk */
@Configuration
@EnableConfigurationProperties(Properties.class)
public class PropertiesConfiguration {}
