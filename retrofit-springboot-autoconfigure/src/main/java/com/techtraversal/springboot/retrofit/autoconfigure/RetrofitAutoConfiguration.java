package com.techtraversal.springboot.retrofit.autoconfigure;

import okhttp3.Call;
import okhttp3.OkHttpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import com.techtraversal.springboot.retrofit.autoconfigure.configuration.RetrofitConfigProperties;


@Configuration
@ConditionalOnClass(Retrofit.class)
@EnableConfigurationProperties(RetrofitConfigProperties.class)
public class RetrofitAutoConfiguration
{
    @Autowired
    private OkHttpClient client;

    @Autowired
    private RetrofitConfigProperties properties;

    /**
     * Configuring retrofit bean with converter factory, client and
     * base URL
     * @return Retrofit bean
     */
    @Bean
    public Retrofit retrofit() {
        JacksonConverterFactory converterFactory =
                JacksonConverterFactory.create();

        return new Retrofit.Builder()
                .client(client)
                .baseUrl(properties.baseURL())
                .addConverterFactory(converterFactory)
                .build();
    }
}

@Qualifier
@Configuration
@ConditionalOnClass(OkHttpClient.class)
class OkHttpCallFactoryConfiguration {

    @Bean
    @ConditionalOnMissingBean
    Call.Factory okHttpCallFactory() {
        return new OkHttpClient.Builder().build();
    }
}
