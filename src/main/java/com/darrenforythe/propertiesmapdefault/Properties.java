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

        private final Map<String, String> map;
        private final List<String> list;

        public Nested(final Map<String, String> map, final List<String> list) {
            this.map = map;
            this.list = list;
        }

        public Map<String, String> getMap() {
            return map;
        }

        public List<String> getList() {
            return list;
        }
    }

    public Nested getNested() {
        return nested;
    }
}
