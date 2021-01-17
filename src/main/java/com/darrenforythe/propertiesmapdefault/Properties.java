package com.darrenforythe.propertiesmapdefault;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;
import java.util.Map;

/** @author Darren.Forsythe@Liberty-IT.co.uk */
@ConfigurationProperties("test")
@ConstructorBinding
public class Properties {

    public Properties(@DefaultValue final Nested nested) {
        this.nested = nested;
    }

    private final Nested nested;

    static class Nested {

        private final Map<String, String> shouldNotBeNull;
        private final List<String> stringList;

        public Nested(
                 final Map<String, String> shouldNotBeNull,
                @DefaultValue final List<String> stringList) {
            this.shouldNotBeNull = shouldNotBeNull;
            this.stringList = stringList;
        }

        public Map<String, String> getShouldNotBeNull() {
            return shouldNotBeNull;
        }

        public List<String> getStringList() {
            return stringList;
        }
    }

    public Nested getNested() {
        return nested;
    }
}
