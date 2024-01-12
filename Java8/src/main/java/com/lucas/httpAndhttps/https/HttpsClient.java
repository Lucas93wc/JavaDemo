package com.lucas.httpAndhttps.https;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucas.httpAndhttps.https.entity.APIReturn;
import com.lucas.httpAndhttps.https.entity.FileInfo;
import com.lucas.httpAndhttps.https.entity.ProjectFile;
import com.lucas.httpAndhttps.https.entity.ProjectInfo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URI;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-06-12 14:05
 */

public class HttpsClient {
  private static ObjectMapper objectMapper = new ObjectMapper();

  public static void main(String[] args) {
    try {
      // 调用授权认证接口
      String accessToken = HttpsClient.AuthLogin();
      System.out.println(accessToken);

      // 获取项目信息和单体信息接口
      String handoverCode = "202306083310001001"; // 202306083310001001
      ProjectInfo projectInfo = HttpsClient.ProjectInfo(accessToken, handoverCode);

      // 获取所有已归档文件接口
      ProjectFile fileInfo = HttpsClient.FileInfo(accessToken, handoverCode);

      List<FileInfo> records = fileInfo.getRecords();
//      String fileGuid = records.get(0).getFileGuid();
//      String fileName = records.get(0).getFileName();
//      String fileMetaUrl = records.get(0).getFileMetaUrl();
//      boolean downloadFile = downloadFile(accessToken, fileGuid, fileName);
//      if (! downloadFile)
//        System.out.println("第0份文件下载失败 ; fileGuid: "+ fileGuid);
//      if (! StringUtils.isEmpty(fileMetaUrl) ) {
//        boolean fileMetaInfo = getFileMetaInfo(accessToken, fileGuid, fileMetaUrl);
//        if (! fileMetaInfo) {
//          System.out.println("第0份文件获取元数据失败 ; fileGuid: "+ fileGuid);
//        }
//      }

      for (int i = 0; i < records.size(); i++) {
        System.out.println("正在下载第"+ (i+1) +"份文件...");
        String fileGuid = records.get(i).getFileGuid();
        String fileName = records.get(i).getFileName();
        String fileUrl = records.get(i).getFileUrl();
        String fileMetaUrl = records.get(i).getFileMetaUrl();

        boolean downloadFile = downloadFile(accessToken, fileGuid, fileUrl, fileName);
        if (! downloadFile)
          System.out.println("第"+ (i+1) +"份文件 ; fileGuid: "+ fileGuid);
        if (! StringUtils.isEmpty(fileMetaUrl) ) {
          boolean fileMetaInfo = getFileMetaInfo(accessToken, fileGuid, fileMetaUrl);
          if (! fileMetaInfo) {
            System.out.println("第0份文件获取元数据失败 ; fileGuid: "+ fileGuid);
          }
        }
      }

      System.out.println("DONE");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static boolean getFileMetaInfo(String token, String fileGuid, String fileMetaUrl) {
    boolean result = false;
    CloseableHttpClient httpClient = null;
    CloseableHttpResponse response = null;
    try {
      httpClient = SSLClient.build();

      URI uri = new URIBuilder(fileMetaUrl)
          .setParameter("access_token", token)
          .build();
      HttpGet httpGet = new HttpGet(uri);
      httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");

      response = httpClient.execute(httpGet);
      HttpEntity entity = response.getEntity();
      StatusLine statusLine = response.getStatusLine();
      if (statusLine.getStatusCode() != HttpStatus.SC_OK) {
        String errorResult = EntityUtils.toString(entity, "UTF-8");
        throw new Exception("获取文件元数据接口调用失败: "+ errorResult);
      }

      // 设置xml保存文件
      File file = new File("C:\\Users\\lucas\\Desktop\\办公\\丽水-省级平台数据对接\\downlaodFile"+
          File.separator + fileGuid + File.separator + "fileMeta.xml");
      File folder = file.getParentFile();
      folder.mkdirs();

      String xmlResult = EntityUtils.toString(entity, "UTF-8");
      Document doc = DocumentHelper.parseText(xmlResult);

      OutputFormat outputFormat = OutputFormat.createPrettyPrint();
      outputFormat.setEncoding("UTF-8");
      FileWriter fileWriter = new FileWriter(file);

      XMLWriter xmlWriter = null;
      try {
        xmlWriter = new XMLWriter(fileWriter, outputFormat);
        // 设置是否转义，默认使用转义字符
        xmlWriter.setEscapeText(false);
        xmlWriter.write(doc);
      } catch (Exception e) {
        throw new Exception("获取文件元数据接口失败: "+ e.getMessage());
      } finally {
        if (xmlWriter != null) {
          try {
            xmlWriter.close();
          } catch (IOException e) {
            System.out.println("获取文件元数据接口关闭xmlWriter异常: " + e.getMessage());
            e.printStackTrace();
          }
        }
      }

      result = true;

      // 关闭响应流资源
      EntityUtils.consume(entity);
    } catch (Exception e) {
      System.out.println("获取文件元数据异常: " + e.getMessage());
      e.printStackTrace();
    }
    finally {
      if (response != null) {
        try {
          response.close();
        } catch (IOException e) {
          System.out.println("获取文件元数据接口关闭response异常: " + e.getMessage());
          e.printStackTrace();
        }
      }

      if (httpClient != null) {
        try {
          httpClient.close();
        } catch (IOException e) {
          System.out.println("获取文件元数据接口关闭httpClient异常: " + e.getMessage());
          e.printStackTrace();
        }
      }
    }
    return result;
  }

  public static boolean downloadFile(String token, String fileGuid, String fileUrl, String fileName) {
    boolean result = false;
    CloseableHttpClient httpClient = null;
    CloseableHttpResponse response = null;
    try {
      httpClient = SSLClient.build();

      URI uri = new URIBuilder(fileUrl)
          .setParameter("access_token", token)
          .build();
      HttpGet httpGet = new HttpGet(uri);
      httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");

      response = httpClient.execute(httpGet);
      HttpEntity entity = response.getEntity();
      StatusLine statusLine = response.getStatusLine();
      if (statusLine.getStatusCode() != HttpStatus.SC_OK) {
        String jsonResult = EntityUtils.toString(entity, "UTF-8");
        APIReturn apiReturn = ParseAPIReturn("下载文件接口调用", jsonResult, APIReturn.class);
        throw new Exception("下载文件接口调用失败: "+ apiReturn.getMsg());
      }


      File file = new File("C:\\Users\\lucas\\Desktop\\办公\\丽水-省级平台数据对接\\downlaodFile"+
          File.separator + fileGuid + File.separator + fileName);
      File folder = file.getParentFile();
      folder.mkdirs();
      InputStream inputStream = null;
      OutputStream os = null;
      try {
        inputStream = entity.getContent();
        os = new FileOutputStream(file);
        StreamUtils.copy(inputStream, os);
      } catch (Exception e) {
        throw new Exception("文件下载失败: "+ e.getMessage());
      } finally {
        if (os != null) {
          try {
            os.close();
          } catch (IOException e) {
            System.out.println("下载文件接口关闭outputStream异常: " + e.getMessage());
            e.printStackTrace();
          }
        }

        if (inputStream != null) {
          try {
            inputStream.close();
          } catch (IOException e) {
            System.out.println("下载文件接口关闭inputStream异常: " + e.getMessage());
            e.printStackTrace();
          }
        }
      }

      result = true;

      // 关闭响应流资源
      EntityUtils.consume(entity);
    } catch (Exception e) {
      System.out.println("下载文件异常: " + e.getMessage());
      e.printStackTrace();
    }
    finally {
      if (response != null) {
        try {
          response.close();
        } catch (IOException e) {
          System.out.println("下载文件接口关闭response异常: " + e.getMessage());
          e.printStackTrace();
        }
      }

      if (httpClient != null) {
        try {
          httpClient.close();
        } catch (IOException e) {
          System.out.println("下载接口关闭httpClient异常: " + e.getMessage());
          e.printStackTrace();
        }
      }
    }
    return result;
  }

  public static boolean downloadFile(String token, String fileGuid, String fileName) {
    boolean result = false;
    CloseableHttpClient httpClient = null;
    CloseableHttpResponse response = null;
    try {
      httpClient = SSLClient.build();

      URI uri = new URIBuilder("https://server-test.ecasoft.cn/oss/file/download")
          .setParameter("access_token", token)
          .setParameter("rowGuid", fileGuid)
          .build();
      HttpGet httpGet = new HttpGet(uri);
      httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");

      response = httpClient.execute(httpGet);
      HttpEntity entity = response.getEntity();
      StatusLine statusLine = response.getStatusLine();
      if (statusLine.getStatusCode() != HttpStatus.SC_OK) {
        String jsonResult = EntityUtils.toString(entity, "UTF-8");
        APIReturn apiReturn = ParseAPIReturn("下载文件接口调用", jsonResult, APIReturn.class);
        throw new Exception("下载文件接口调用失败: "+ apiReturn.getMsg());
      }


      File file = new File("C:\\Users\\lucas\\Desktop\\办公\\丽水-省级平台数据对接\\downlaodFile"+
          File.separator + fileGuid + File.separator + fileName);
      File folder = file.getParentFile();
      folder.mkdirs();
      InputStream inputStream = null;
      OutputStream os = null;
      try {
        inputStream = entity.getContent();
        os = new FileOutputStream(file);
        StreamUtils.copy(inputStream, os);
      } catch (Exception e) {
        throw new Exception("文件下载失败: "+ e.getMessage());
      } finally {
        if (os != null) {
          try {
            os.close();
          } catch (IOException e) {
            System.out.println("下载文件接口关闭outputStream异常: " + e.getMessage());
            e.printStackTrace();
          }
        }

        if (inputStream != null) {
          try {
            inputStream.close();
          } catch (IOException e) {
            System.out.println("下载文件接口关闭inputStream异常: " + e.getMessage());
            e.printStackTrace();
          }
        }
      }

      result = true;

      // 关闭响应流资源
      EntityUtils.consume(entity);
    } catch (Exception e) {
      System.out.println("下载文件异常: " + e.getMessage());
      e.printStackTrace();
    }
    finally {
      if (response != null) {
        try {
          response.close();
        } catch (IOException e) {
          System.out.println("下载文件接口关闭response异常: " + e.getMessage());
          e.printStackTrace();
        }
      }

      if (httpClient != null) {
        try {
          httpClient.close();
        } catch (IOException e) {
          System.out.println("下载接口关闭httpClient异常: " + e.getMessage());
          e.printStackTrace();
        }
      }
    }
    return result;
  }

  public static ProjectFile FileInfo(String token, String handoverCode) throws Exception {
    final String PAGE_SIZE = "50";

    CloseableHttpClient httpClient = null;
    CloseableHttpResponse response = null;
    ProjectFile projectFile = new ProjectFile();
    try {
      httpClient = SSLClient.build();
      // String url = "https://server-test.ecasoft.cn/filing/api/file/shareProjectFile?access_token="+ token+"&handoverCode="+handoverCode+"&current=1&size=50";
      String url = "https://server-test.ecasoft.cn/filing/api/file/shareProjectFile";

      boolean getMoreData = false;
      int pageNo = 1;
      do {
        URI uri = new URIBuilder(url)
            .setParameter("access_token", token)
            .setParameter("handoverCode", handoverCode)
            .setParameter("current", String.valueOf(pageNo))
            .setParameter("size", PAGE_SIZE)
            .build();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");

        response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String jsonResult = EntityUtils.toString(entity, "UTF-8");
        StatusLine statusLine = response.getStatusLine();
        if (statusLine.getStatusCode() != HttpStatus.SC_OK) {
          System.out.println("获取所有已归档文件接口返回值: " + jsonResult);
          throw new Exception("获取所有已归档文件接口调用失败!");
        }
        // 关闭响应流资源
        EntityUtils.consume(entity);
        // 判断接口调用是否成功
        ProjectFile tempProjectFile = ParseAPIReturn("获取所有已归档文件接口", jsonResult, ProjectFile.class);
        // 将数据复制到返回结果中
        projectFile.clone(tempProjectFile);

        // 页码加1
        pageNo++;

        // 根据当前页是否小于总页数判断是否获取到所有数据
        int currentPageNo = tempProjectFile.getCurrent();
        int pagesCount = tempProjectFile.getPages();
        getMoreData = ( currentPageNo < pagesCount );
      } while ( getMoreData ) ;

      return projectFile;
    } finally {
      if (response != null) {
        try {
          response.close();
        } catch (IOException e) {
          System.out.println("获取所有已归档文件接口关闭response异常: " + e.getMessage());
          e.printStackTrace();
        }
      }

      if (httpClient != null) {
        try {
          httpClient.close();
        } catch (IOException e) {
          System.out.println("获取所有已归档文件接口关闭httpClient异常: " + e.getMessage());
          e.printStackTrace();
        }
      }
    }
  }

  public static ProjectInfo ProjectInfo(String token, String handoverCode) throws Exception {
    CloseableHttpClient httpClient = null;
    CloseableHttpResponse response = null;
    try {
      httpClient = SSLClient.build();
      String url = "https://server-test.ecasoft.cn/filing/api/file/getDataItemByHandoverCode";

      HttpPost httpPost = new HttpPost(url);
      httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
      LinkedList<NameValuePair> pairs = new LinkedList<>();
      BasicNameValuePair access_token = new BasicNameValuePair("access_token", token);
      BasicNameValuePair code = new BasicNameValuePair("handoverCode", handoverCode);
      pairs.add(access_token);
      pairs.add(code);
      UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(pairs, "UTF-8");
      httpPost.setEntity(urlEncodedFormEntity);

      response = httpClient.execute(httpPost);
      HttpEntity entity = response.getEntity();
      String jsonResult = EntityUtils.toString(entity, "UTF-8");
      StatusLine statusLine = response.getStatusLine();
      if (statusLine.getStatusCode() != HttpStatus.SC_OK) {
        System.out.println("获取项目信息和单体信息接口返回值: " + jsonResult);
        throw new Exception("获取项目信息和单体信息接口调用失败!");
      }
      // 关闭响应流资源
      EntityUtils.consume(entity);
      // 判断接口调用是否成功
      ProjectInfo dataNode = ParseAPIReturn("获取项目信息和单体信息接口", jsonResult, ProjectInfo.class);
      System.out.println("data: " + dataNode);

      return dataNode;
    } finally {
      if (response != null) {
        try {
          response.close();
        } catch (IOException e) {
          System.out.println("获取项目信息和单体信息接口关闭response异常: " + e.getMessage());
          e.printStackTrace();
        }
      }

      if (httpClient != null) {
        try {
          httpClient.close();
        } catch (IOException e) {
          System.out.println("获取项目信息和单体信息接口关闭httpClient异常: " + e.getMessage());
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * 调用授权认证接口
   *
   * @return 认证授权成功，返回access_token；
   * @throws Exception 认证授权失败，抛出异常；
   */
  public static String AuthLogin() throws Exception {
    CloseableHttpClient httpClient = null;
    CloseableHttpResponse response = null;
    try {
      httpClient = SSLClient.build();
      String url = "https://server-test.ecasoft.cn/auth/oauth/token?grant_type=client_credentials&scope=server";
      String username = "7e6b5677ee833e1d659748fe0abb1251";
      String password = "95095b56-1203-39d8-1d34-d80023f21640";
      String token = username + ":" + password;
      final Base64.Encoder encoder = Base64.getEncoder();
      byte[] encode = encoder.encode(token.getBytes());
      final String encodeToken = new String(encode);

      HttpPost httpPost = new HttpPost(url);
      httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
      httpPost.addHeader("isToken", "false");
      httpPost.addHeader("Authorization", "Basic "+ encodeToken);

      response = httpClient.execute(httpPost);
      HttpEntity entity = response.getEntity();
      String jsonResult = EntityUtils.toString(entity, "UTF-8");
      StatusLine statusLine = response.getStatusLine();
      if (statusLine.getStatusCode() != HttpStatus.SC_OK) {
        System.out.println("授权认证接口返回值: " + jsonResult);
        throw new Exception("授权认证接口调用失败!");
      }
      // 关闭响应流资源
      EntityUtils.consume(entity);

      if ( StringUtils.isEmpty(jsonResult) ) {
        System.out.println("授权认证接口返回值为空!");
        throw new Exception("授权认证接口返回值为空!");
      }

      // 将JSON转换成Map对象
      Map<String, Object> map = json2Map(jsonResult, Object.class);
      // 判断接口返回值是否有access_token属性确定是否
      String accessToken = (String)map.get("access_token");
      if ( StringUtils.isEmpty(token) ) {
        System.out.println("授权认证接口返回值: " + jsonResult);
        throw new Exception("授权认证信息获取失败!");
      }

      return accessToken;
    } finally {
      if (response != null) {
        try {
          response.close();
        } catch (IOException e) {
          System.out.println("授权认证接口关闭response异常: " + e.getMessage());
          e.printStackTrace();
        }
      }

      if (httpClient != null) {
        try {
          httpClient.close();
        } catch (IOException e) {
          System.out.println("授权认证接口关闭httpClient异常: " + e.getMessage());
          e.printStackTrace();
        }
      }
    }

  }

  public static <T> T ParseAPIReturn(String apiName, String apiJson, Class<T> clz) throws Exception {
    if ( StringUtils.isEmpty(apiJson) ) {
      throw new Exception(apiName + "返回值为空!");
    }
    System.out.println("API Return: " + apiJson);

    APIReturn apiReturn = objectMapper.readValue(apiJson, APIReturn.class);
    String code = apiReturn.getCode();
    Boolean status = apiReturn.getStatus();
    if ( (! status ) || ("B0001".equalsIgnoreCase(code)) ) {
      String msg = apiReturn.getMsg();
      throw new Exception(apiName+ "出错: " +msg);
    }

    Object data = apiReturn.getData();
    String dataString = objectMapper.writeValueAsString(data);
    T targetObj = objectMapper.readValue(dataString, clz);

    return targetObj;
  }

  public static String ParseAPIReturn111(String apiName, String apiJson) throws Exception {
    if ( StringUtils.isEmpty(apiJson) ) {
      throw new Exception(apiName + "返回值为空!");
    }

    System.out.println("API Return: " + apiJson);

    Map<String, Object> map = HttpsClient.json2Map(apiJson, Object.class);
    String code = (String) map.get("code");
    Boolean status = (Boolean) map.get("status");
    if ( (! status ) || ("B0001".equalsIgnoreCase(code)) ) {
      String msg = (String) map.get("msg");
      throw new Exception(apiName+ "出错: " +msg);
    }

    String data = (String) map.get("data");
    return data;
  }

  private static JavaType collectionType(Class<?> collectionClz, Class<?> ...elementClz) {
    return objectMapper.getTypeFactory().constructParametricType(collectionClz, elementClz);
  }

  public static <T> List<T> json2List(String json, Class<T> elementClz) throws JsonProcessingException {
    return objectMapper.readValue(json, collectionType(List.class, elementClz));
  }

  public static <T> Map<String, T> json2Map(String json, Class<T> valueClz) throws JsonProcessingException {
    return objectMapper.readValue(json, collectionType(Map.class, String.class, valueClz));
  }
}
