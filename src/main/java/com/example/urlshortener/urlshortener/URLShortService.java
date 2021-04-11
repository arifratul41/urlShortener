package com.example.urlshortener.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class URLShortService {

    private String baseurl;
    private String mapurl;
    private String newurl;
    private final URLShortRepository urlShortRepository;

    @Autowired
    public URLShortService(URLShortRepository urlShortRepository) {
        this.urlShortRepository = urlShortRepository;
    }

    private String randomStringGenerator(int len){
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String alphaNumeric =   lowerAlphabet + numbers;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = len;

        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphaNumeric.length());
            char randomChar = alphaNumeric.charAt(index);
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        return randomString;
    }
    public boolean isValidCustomUrl(String mapurl){
        if(Pattern.matches("[a-z0-9._.-]+", mapurl)) return true;
        return false;
    }


    public void saveapi(URLMap urlMap){
        baseurl = urlMap.getBaseurl();
        mapurl = urlMap.getMapurl();
        if(mapurl != null){
            mapurl = mapurl.toLowerCase();
            if (isValidCustomUrl(mapurl) && mapurl.length() < 15)
                newurl = mapurl;
            else {
                throw new IllegalStateException("Invalid Custom URL");
            }
        }
        else {
            newurl = randomStringGenerator(7);
        }
        URLMap saveEntity = new URLMap(baseurl, newurl);
        urlShortRepository.save(saveEntity);

    }

    public List<URLMap> getURL(String mapurl) {
        return urlShortRepository.findByMapurl(mapurl);
    }

    public URLMap getApi(String mapurl) {
        List<URLMap> urlMap = getURL(mapurl);
        if (urlMap.size() > 0){
            return urlMap.get(0);
        }
        throw new IllegalStateException("URL Not found");
    }
}
