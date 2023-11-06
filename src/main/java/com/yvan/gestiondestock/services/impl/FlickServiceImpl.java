package com.yvan.gestiondestock.services.impl;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.yvan.gestiondestock.services.FlickService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@Slf4j
public class FlickServiceImpl implements FlickService {

  @Value("${flickr.apiKey}")
  private String  apiKey;

  @Value("${flickr.apiSecret}")
  private String  apiSecret;

  @Value("${flickr.appSecret}")
  private String  appSecret;

  @Value("${flickr.appKey}")
  private String  appKey;

  private Flickr flickr;


  @Override
  @SneakyThrows
  public String savePhoto(InputStream photo, String title) {
    connect();

    UploadMetaData uploadMetaData = new UploadMetaData();
    uploadMetaData.setTitle(title);

    String photoId = flickr.getUploader().upload(photo,uploadMetaData);

    return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
  }

  private void connect(){
    flickr = new Flickr(apiKey, apiSecret, new REST());

    Auth auth = new Auth();
    auth.setPermission(Permission.DELETE);

    auth.setToken(apiKey);
    auth.setTokenSecret(appSecret);

    RequestContext requestContext = RequestContext.getRequestContext();
    requestContext.setAuth(auth);

    flickr.setAuth(auth);

  }
}
