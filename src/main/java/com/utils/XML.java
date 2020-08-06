package com.utils;

import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

public class XML {


    public static void main(String[] args) throws Exception {


        String content = "<userinfo>\n" +
                "    <err_msg></err_msg>\n" +
                "    <retcode>1</retcode>\n" +
                "\t\t\t<userId>A200611014</userId>\n" +
                "\t\t\t<totalBalance>466.58</totalBalance>\n" +
                "\t\t\t<oufeiBalance>466.58</oufeiBalance>\n" +
                "\t\t\t<feihanBalance>0</feihanBalance>\n" +
                "</userinfo>";
        JSONObject jsonObject = toJSONObject(content, Charset.defaultCharset());
        assert jsonObject != null;
        System.out.println(jsonObject.toJSONString());

    }


    /**
     * 解析xml并转化为Json值
     *
     * @param content json字符串
     * @param charset 字符编码
     * @return Json值
     */
    public static JSONObject toJSONObject(String content, Charset charset) throws Exception {

        if (StringUtils.isEmpty(content)) {
            return null;
        }
        return toJSONObject(content.getBytes(charset));
    }

    /**
     * 解析xml并转化为Json值
     *
     * @param content json字符串
     * @return Json值
     */
    public static JSONObject toJSONObject(byte[] content) throws Exception {

        if (null == content) {
            return null;
        }
        try (InputStream in = new ByteArrayInputStream(content)) {
            return (JSONObject) inputStream2Map(in, null);
        } catch (IOException e) {
            throw new IOException("IOException");
        }

    }

    /**
     * @param in xml输入流
     * @param m  参数集
     * @return 整理完成的参数集
     * @throws IOException xml io转化异常
     */
    public static Map<String, Object> inputStream2Map(InputStream in, Map<String, Object> m) throws Exception {
        if (null == m) {
            m = new JSONObject();
        }
        try {
            DocumentBuilder documentBuilder = newDocumentBuilder();
            Document doc = documentBuilder.parse(in);
            doc.getDocumentElement().normalize();
            NodeList children = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < children.getLength(); ++idx) {
                Node node = children.item(idx);
                NodeList nodeList = node.getChildNodes();
                if (node.getNodeType() == Node.ELEMENT_NODE && nodeList.getLength() <= 1) {
                    m.put(node.getNodeName(), node.getTextContent());
                } else if (node.getNodeType() == Node.ELEMENT_NODE && nodeList.getLength() > 1) {
                    m.put(node.getNodeName(), getChildren(nodeList));
                }
            }
        } catch (Exception e) {
//            e.printStackTrace();
            throw new Exception("XML failure");
        } finally {
            in.close();
        }
        return m;
    }

    public static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        documentBuilderFactory.setXIncludeAware(false);
        documentBuilderFactory.setExpandEntityReferences(false);

        return documentBuilderFactory.newDocumentBuilder();
    }

    /**
     * 获取子结点的xml
     *
     * @param children 集合
     * @return String 子结点的xml
     */
    public static JSON getChildren(NodeList children) {
        JSON json = null;
        for (int idx = 0; idx < children.getLength(); ++idx) {
            Node node = children.item(idx);
            NodeList nodeList = node.getChildNodes();
            if (node.getNodeType() == Node.ELEMENT_NODE && nodeList.getLength() <= 1) {
                if (null == json) {
                    json = new JSONObject();
                }
                assert json instanceof JSONObject;
                ((JSONObject) json).put(node.getNodeName(), node.getTextContent());
            } else if (node.getNodeType() == Node.ELEMENT_NODE && nodeList.getLength() > 1) {
                if (null == json) {
                    json = new JSONObject();
                }
                if (json instanceof JSONObject) {
                    JSONObject j = ((JSONObject) json);
                    if (j.containsKey(node.getNodeName())) {
                        JSONArray array = new JSONArray();
                        array.add(json);
                        json = array;
                    } else {
                        j.put(node.getNodeName(), getChildren(nodeList));
                    }
                }

                if (json instanceof JSONArray) {
                    JSONObject c = new JSONObject();
                    c.put(node.getNodeName(), getChildren(nodeList));
                    ((JSONArray) json).add(c);
                }
            }
        }

        return json;
    }

}
