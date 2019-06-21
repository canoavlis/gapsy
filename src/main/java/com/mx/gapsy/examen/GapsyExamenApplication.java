package com.mx.gapsy.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by atech on 1/21/18.
 */
@SpringBootApplication
@EnableSwagger2
public class GapsyExamenApplication extends SpringBootServletInitializer {

   public static void main(String[] args) {
      SpringApplication.run(GapsyExamenApplication.class, args);
   }

   public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2)
            .select().apis(RequestHandlerSelectors.basePackage("com.mx.gapsy.examen.rest"))
            .paths(PathSelectors.any())
            .build()
            .enable(true);
   }

}
