package net.pazz.base.entity;

import lombok.Data;

@Data
public class Example {

    private String name;
    private String code;
    private String extends1;

    public Example (){}

    public Example (String name){
        this.name = name;
    }

    public static class Builder{

        private static Example example = new Example();

        public Builder validateName(String name){
            if(null == name || "" == name){
               throw new RuntimeException("name exception!");
            }
            example.setName(name);
            return this;
        }

        public Builder validateCode(String code){
            if(null == code || "" == code){
                throw new RuntimeException("code exception!");
            }
            example.setCode(code);
            return this;
        }

        public static Example build(){
            return example;
        }

    }

    public static void main(String[] args) {
        Example example = new Example.Builder().validateCode("code").validateName("code").build();
        System.out.println(example);
    }

}
