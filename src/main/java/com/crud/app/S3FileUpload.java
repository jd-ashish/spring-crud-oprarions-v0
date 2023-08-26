package com.crud.app;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;


@Configuration
public class S3FileUpload {
    @Bean
    public AmazonS3 amazonS3Client() {

        AWSCredentials awsCredentials =
                new BasicAWSCredentials("AKIA2P6LSRY7N6FIVHTD", "qgdTeCp8JkEfqK8ZrIqWiZORzyn0ni2SP5LXvwkb");
        return AmazonS3ClientBuilder
                .standard()
                .withRegion("ap-south-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
//        return AmazonS3ClientBuilder
//                .standard()
//                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
//                        "s3.amazonaws.com",  // or specify your desired endpoint
//                        "ap-south-1"  // replace with your desired region
//                ))
//                .withCredentials(new DefaultAWSCredentialsProviderChain())
//                .build();
    }
}
