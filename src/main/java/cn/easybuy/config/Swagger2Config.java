package cn.easybuy.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

//    定义接口说明和参数说明
//    定义在类上：@Api
//    定义在方法上：@ApiOperation
//    定义在参数上：@ApiParam
//    @ApiModelProperty(value = "入驻时间", example = "2010-01-01")  属性上的说明
    @Bean
    public Docket webApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Api")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error.*")))// 错误路径不监控
                .paths(PathSelectors.regex("/.*"))// 对根下所有路径进行监控
                .build();

    }
    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("easybuy系统-API文档")
                .description("本文档描述了系统接口")
                .version("1.0")
                .contact(new Contact("luoyang", "http://luoyang.com", "326013481@qq.com"))
                .build();
    }

}
