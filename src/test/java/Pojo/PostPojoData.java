package Pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostPojoData {


    private String name ;
    private String job;

    public PostPojoData(){

    }


    public PostPojoData(String name, String job) {
        this.name = name;
        this.job = job;

    }
        @Override
        public String toString() {
            return "PostPojoData{" +
                    "name='" + name + '\'' +
                    ", job='" + job + '\'' +
                    '}';

    }
}

