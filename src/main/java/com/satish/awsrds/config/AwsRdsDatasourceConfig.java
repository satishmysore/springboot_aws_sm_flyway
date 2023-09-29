package com.satish.awsrds.config;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import javax.sql.DataSource;

/*
 * @author - Satish R
 */

@Configuration
@Profile("aws-direct-sm")
public class AwsRdsDatasourceConfig {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
    @Value("${cloud.aws.credentials.secret-key}")
    private String secretkey;

    @Value("${satish.aws.secret-manager.key}")
    private String secretManagerKey;

    @Value("${satish.aws.secret-manager.region}")
    private String secretManagerRegion;

    private Gson gson = new Gson();

    /**
     * Data source data source.
     *
     * @return the data source
     */
    @Bean
    public DataSource dataSource(){

        AwsSecrets secrets = getSecret();
        return DataSourceBuilder
                .create()
                .url("jdbc:"
                        .concat(secrets.getEngine())
                        .concat("://")
                        .concat(secrets.getHost())
                        .concat(":")
                        .concat(secrets.getPort())
                        .concat("/postgres"))
                .username(secrets.getUsername())
                .password(secrets.getPassword())
                .build();
    }

    private AwsSecrets getSecret() {

        GetSecretValueResponse getSecretValueResponse;

        AwsCredentials awsCredentials = AwsBasicCredentials.create(this.accessKey, this.secretkey);

        StaticCredentialsProvider staticCredentialsProvider = StaticCredentialsProvider.create(awsCredentials);

        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(Region.of(secretManagerRegion))
                .credentialsProvider(staticCredentialsProvider)
                .build();

        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretManagerKey)
                .build();

        try {
            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            // For a list of exceptions thrown, see
            // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
            throw e;
        }

        return gson.fromJson(getSecretValueResponse.secretString(), AwsSecrets.class);
    }
}


/**
 * The type Aws secrets.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class AwsSecrets {

    private String username;
    private String password;
    private String host;
    private String engine;
    private String port;
    private String dbInstanceIdentifier;

}
