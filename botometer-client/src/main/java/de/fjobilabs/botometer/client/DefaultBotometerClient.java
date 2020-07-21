/*
 * Copyright 2019 FJOBI Labs Softwareentwicklung - Felix Jordan
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.fjobilabs.botometer.client;

import java.io.IOException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.fjobilabs.botometer.BotometerException;
import de.fjobilabs.botometer.ClassificationResult;
import de.fjobilabs.botometer.api.ApiError;
import de.fjobilabs.botometer.api.BotometerApiException;
import de.fjobilabs.botometer.dto.ClassificationResultDTO;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class DefaultBotometerClient extends AbstractBotometerClient {
    
    private static final String BOTOMETER_CHECK_ACCOUNT_URL = "https://botometer-pro.p.rapidapi.com/2/check_account";
    private static final MediaType JSON_MEDIA_TYPE = MediaType.get("application/json; charset=utf-8");
    
    private static final Logger logger = LoggerFactory.getLogger(DefaultBotometerClient.class);
    
    private String apiKey;
    private OkHttpClient httpClient;
    
    public DefaultBotometerClient(String apiKey) {
        Objects.requireNonNull(apiKey, "apikey must not be null");
        this.apiKey = apiKey;
        this.httpClient = new OkHttpClient();
    }
    
    @Override
    public ClassificationResult checkAccount(byte[] accountDataJson) throws BotometerException, IOException {
        RequestBody body = RequestBody.create(JSON_MEDIA_TYPE, accountDataJson);
        Request request = new Request.Builder().url(BOTOMETER_CHECK_ACCOUNT_URL).header("X-RapidAPI-Key", this.apiKey)
            .post(body).build();
        
        try (Response response = this.httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return readClassifcationResult(response.body());
            } else {
                throw createApiErrorException(response);
            }
        }
    }
    
    private BotometerApiException createApiErrorException(Response response) {
        int statusCode = response.code();
        if (response.body().contentLength() > 0) {
            ApiError apiError;
            try {
                apiError = this.objectMapper.readValue(response.body().byteStream(), ApiError.class);
            } catch (IOException e) {
                logger.warn("Failed to read error response body");
                logger.debug("Exception in error response deserialisation:", e);
                // Cannot parse body, so just create general exception
                return BotometerApiException.create(statusCode);
            }
            return BotometerApiException.create(statusCode, apiError);
        }
        return BotometerApiException.create(statusCode);
    }
    
    private ClassificationResult readClassifcationResult(ResponseBody body) throws IOException {
        try {
            return this.objectMapper.readValue(body.byteStream(), ClassificationResultDTO.class);
        } catch (JsonParseException e) {
            throw new BotometerClientException("Failed to parse response body", e);
        } catch (JsonMappingException e) {
            throw new BotometerClientException("Failed to read response body", e);
        } catch (IOException e) {
            throw new IOException("IOException while reading response body", e);
        }
    }
}
