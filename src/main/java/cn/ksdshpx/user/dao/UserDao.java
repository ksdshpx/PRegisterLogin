package cn.ksdshpx.user.dao;

import cn.ksdshpx.user.domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/31
 * Time: 10:18
 * Description:数据访问类UserDao
 */
public class UserDao {
    private String path = "D:\\users.xml";

    /**
     * 按用户名查询
     * @param username
     * @return
     */
    public User findByUsername(String username){
        //1.得到Document
        //创建解析器
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(path);
            //2.通过xpath查询得到Element
            Element element = (Element) document.selectSingleNode("//user[@username='"+username+"']");
            //3.校验element是否为null,如果为null,返回null
            if (element == null) {
                return null;
            }
            //4.把element的数据封装到User对象中
            User user = new User();
            String attrUsername = element.attributeValue("username");
            String attrPassword = element.attributeValue("password");
            user.setUsername(attrUsername);
            user.setPassword(attrPassword);
            return user;
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 添加用户
     * @param user
     */
    public void add(User user){
        //1.得到Document
        //创建解析器
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(path);
            //2.得到根元素
            Element root = document.getRootElement();
            //3.通过根元素创建新元素
            Element userEle = root.addElement("user");
            //4.为userEle设置属性
            userEle.addAttribute("username",user.getUsername());
            userEle.addAttribute("password",user.getPassword());
            //保存文档
            //创建输出格式化器
            OutputFormat outputFormat = new OutputFormat("\t",true);//缩进使用\t,还要换行
            outputFormat.setTrimText(true);//清空原有的缩进与换行
            XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"),outputFormat);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
