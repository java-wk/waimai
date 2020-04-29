package com.runoob.testSystem;

public class TestSystem {
    public static void main(String[] args) {

        System.out.println("java.home                      =" + System.getProperty("java.home")); //     装目录
        System.out.println("java.vm.specification.version  =" + System.getProperty("java.vm.specification.version")); //                         虚拟机规范版本
        System.out.println("java.vm.specification.vendor   =" + System.getProperty("java.vm.specification.vendor")); //                         虚拟机规范供应商
        System.out.println("java.vm.specification.name     =" + System.getProperty("java.vm.specification.name")); //                      虚拟机规范名称
        System.out.println("java.vm.version                =" + System.getProperty("java.vm.version")); //           拟机实现版本
        System.out.println("java.vm.vendor                 =" + System.getProperty("java.vm.vendor")); //          虚拟机实现供应商
        System.out.println("java.vm.name                   =" + System.getProperty("java.vm.name")); //        拟机实现名称
        System.out.println("java.specification.version     =" + System.getProperty("java.specification.version")); //                      运行时环境规范版本
        System.out.println("java.specification.vendor      =" + System.getProperty("java.specification.vendor")); //                      运行时环境规范供应商
        System.out.println("java.specification.name        =" + System.getProperty("java.specification.name")); //                   运行时环境规范名称
        System.out.println("java.class.version             =" + System.getProperty("java.class.version")); //              格式版本号
        System.out.println("java.class.path                =" + System.getProperty("java.class.path")); //           路径
        System.out.println("java.library.path              =" + System.getProperty("java.library.path")); //             索的路径列表
        System.out.println("java.io.tmpdir                 =" + System.getProperty("java.io.tmpdir")); //          文件路径
        System.out.println("java.compiler                  =" + System.getProperty("java.compiler")); //          JIT 编译器的名称
        System.out.println("java.ext.dirs                  =" + System.getProperty("java.ext.dirs")); //         个扩展目录的路径
        System.out.println("os.name                        =" + System.getProperty("os.name")); //   的名称
        System.out.println("os.arch                        =" + System.getProperty("os.arch")); //   的架构
        System.out.println("os.version                     =" + System.getProperty("os.version")); //      的版本
        System.out.println("file.separator                 =" + System.getProperty("file.separator")); //          （在 UNIX 系统中是“/”）
        System.out.println("path.separator                 =" + System.getProperty("path.separator")); //          （在 UNIX 系统中是“:”）
        System.out.println("line.separator                 =" + System.getProperty("line.separator")); //          在 UNIX 系统中是“/n”）
        System.out.println("user.name                      =" + System.getProperty("user.name")); //     称
        System.out.println("user.home                      =" + System.getProperty("user.home")); //
        System.out.println("user.dir                       =" + System.getProperty("user.dir")); //    工作目录

    }

   //键	相关值的描述
   //java.version	Java 运行时环境版本
   //java.vendor	Java运行时环境供应商
   //java.vendor.url	Java 供应商的 URL
   //java.home	Java 安装目录
   //java.vm.specification.version	Java 虚拟机规范版本
   //java.vm.specification.vendor	Java 虚拟机规范供应商
   //java.vm.specification.name	Java 虚拟机规范名称
   //java.vm.version	Java 虚拟机实现版本
   //java.vm.vendor	Java 虚拟机实现供应商
   //java.vm.name	Java 虚拟机实现名称
   //java.specification.version	Java 运行时环境规范版本
   //java.specification.vendor	Java 运行时环境规范供应商
   //java.specification.name	Java 运行时环境规范名称
   //java.class.version	Java 类格式版本号
   //java.class.path	Java 类路径
   //java.library.path	加载库时搜索的路径列表
   //java.io.tmpdir	默认的临时文件路径
   //java.compiler	要使用的 JIT 编译器的名称
   //java.ext.dirs	一个或多个扩展目录的路径
   //os.name	操作系统的名称
   //os.arch	操作系统的架构
   //os.version	操作系统的版本
   //file.separator	文件分隔符（在 UNIX 系统中是“/”）
   //path.separator	路径分隔符（在 UNIX 系统中是“:”）
   //line.separator	行分隔符（在 UNIX 系统中是“/n”）
   //user.name	用户的账户名称
   //user.home	用户的主目录
   //user.dir	用户的当前工作目录



   //输出
   //
   // java.home                      =C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\jbr
   //java.vm.specification.version  =11
   //java.vm.specification.vendor   =Oracle Corporation
   //java.vm.specification.name     =Java Virtual Machine Specification
   //java.vm.version                =11.0.4+10-b304.77
   //java.vm.vendor                 =JetBrains s.r.o
   //java.vm.name                   =OpenJDK 64-Bit Server VM
   //java.specification.version     =11
   //java.specification.vendor      =Oracle Corporation
   //java.specification.name        =Java Platform API Specification
   //java.class.version             =55.0
   //java.class.path                =C:\Users\putao-1\IdeaProjects\waimai\target\classes;C:\Users\putao-1\.m2\repository\org\springframework\boot\spring-boot-starter-web\2.0.6.RELEASE\spring-boot-starter-web-2.0.6.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\springframework\boot\spring-boot-starter\2.0.6.RELEASE\spring-boot-starter-2.0.6.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\springframework\boot\spring-boot-starter-logging\2.0.6.RELEASE\spring-boot-starter-logging-2.0.6.RELEASE.jar;C:\Users\putao-1\.m2\repository\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;C:\Users\putao-1\.m2\repository\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;C:\Users\putao-1\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.10.0\log4j-to-slf4j-2.10.0.jar;C:\Users\putao-1\.m2\repository\org\apache\logging\log4j\log4j-api\2.10.0\log4j-api-2.10.0.jar;C:\Users\putao-1\.m2\repository\org\slf4j\jul-to-slf4j\1.7.25\jul-to-slf4j-1.7.25.jar;C:\Users\putao-1\.m2\repository\javax\annotation\javax.annotation-api\1.3.2\javax.annotation-api-1.3.2.jar;C:\Users\putao-1\.m2\repository\org\yaml\snakeyaml\1.19\snakeyaml-1.19.jar;C:\Users\putao-1\.m2\repository\org\springframework\boot\spring-boot-starter-json\2.0.6.RELEASE\spring-boot-starter-json-2.0.6.RELEASE.jar;C:\Users\putao-1\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.9.7\jackson-databind-2.9.7.jar;C:\Users\putao-1\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.9.0\jackson-annotations-2.9.0.jar;C:\Users\putao-1\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.9.7\jackson-core-2.9.7.jar;C:\Users\putao-1\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.9.7\jackson-datatype-jdk8-2.9.7.jar;C:\Users\putao-1\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.9.7\jackson-datatype-jsr310-2.9.7.jar;C:\Users\putao-1\.m2\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.9.7\jackson-module-parameter-names-2.9.7.jar;C:\Users\putao-1\.m2\repository\org\springframework\boot\spring-boot-starter-tomcat\2.0.6.RELEASE\spring-boot-starter-tomcat-2.0.6.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\apache\tomcat\embed\tomcat-embed-core\8.5.34\tomcat-embed-core-8.5.34.jar;C:\Users\putao-1\.m2\repository\org\apache\tomcat\embed\tomcat-embed-el\8.5.34\tomcat-embed-el-8.5.34.jar;C:\Users\putao-1\.m2\repository\org\apache\tomcat\embed\tomcat-embed-websocket\8.5.34\tomcat-embed-websocket-8.5.34.jar;C:\Users\putao-1\.m2\repository\org\hibernate\validator\hibernate-validator\6.0.13.Final\hibernate-validator-6.0.13.Final.jar;C:\Users\putao-1\.m2\repository\javax\validation\validation-api\2.0.1.Final\validation-api-2.0.1.Final.jar;C:\Users\putao-1\.m2\repository\org\jboss\logging\jboss-logging\3.3.2.Final\jboss-logging-3.3.2.Final.jar;C:\Users\putao-1\.m2\repository\com\fasterxml\classmate\1.3.4\classmate-1.3.4.jar;C:\Users\putao-1\.m2\repository\org\springframework\spring-web\5.0.10.RELEASE\spring-web-5.0.10.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\springframework\spring-beans\5.0.10.RELEASE\spring-beans-5.0.10.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\springframework\spring-webmvc\5.0.10.RELEASE\spring-webmvc-5.0.10.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\springframework\spring-aop\5.0.10.RELEASE\spring-aop-5.0.10.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\springframework\spring-context\5.0.10.RELEASE\spring-context-5.0.10.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\springframework\spring-expression\5.0.10.RELEASE\spring-expression-5.0.10.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\slf4j\slf4j-api\1.7.25\slf4j-api-1.7.25.jar;C:\Users\putao-1\.m2\repository\org\springframework\spring-core\5.0.10.RELEASE\spring-core-5.0.10.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\springframework\spring-jcl\5.0.10.RELEASE\spring-jcl-5.0.10.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\2.0.6.RELEASE\spring-boot-autoconfigure-2.0.6.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\springframework\boot\spring-boot\2.0.6.RELEASE\spring-boot-2.0.6.RELEASE.jar;C:\Users\putao-1\.m2\repository\org\apache\httpcomponents\httpclient\4.5.2\httpclient-4.5.2.jar;C:\Users\putao-1\.m2\repository\org\apache\httpcomponents\httpcore\4.4.10\httpcore-4.4.10.jar;C:\Users\putao-1\.m2\repository\commons-codec\commons-codec\1.11\commons-codec-1.11.jar;C:\Users\putao-1\.m2\repository\com\alibaba\easyexcel\1.1.2-beta4\easyexcel-1.1.2-beta4.jar;C:\Users\putao-1\.m2\repository\org\apache\poi\poi\3.17\poi-3.17.jar;C:\Users\putao-1\.m2\repository\org\apache\commons\commons-collections4\4.1\commons-collections4-4.1.jar;C:\Users\putao-1\.m2\repository\org\apache\poi\poi-ooxml\3.17\poi-ooxml-3.17.jar;C:\Users\putao-1\.m2\repository\org\apache\poi\poi-ooxml-schemas\3.17\poi-ooxml-schemas-3.17.jar;C:\Users\putao-1\.m2\repository\org\apache\xmlbeans\xmlbeans\2.6.0\xmlbeans-2.6.0.jar;C:\Users\putao-1\.m2\repository\stax\stax-api\1.0.1\stax-api-1.0.1.jar;C:\Users\putao-1\.m2\repository\com\github\virtuald\curvesapi\1.04\curvesapi-1.04.jar;C:\Users\putao-1\.m2\repository\cglib\cglib\3.1\cglib-3.1.jar;C:\Users\putao-1\.m2\repository\org\ow2\asm\asm\4.2\asm-4.2.jar;C:\Users\putao-1\.m2\repository\com\alibaba\fastjson\1.2.55\fastjson-1.2.55.jar;C:\Users\putao-1\.m2\repository\org\apache\commons\commons-lang3\3.7\commons-lang3-3.7.jar
   //java.library.path              =C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\jbr\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;C:\Program Files (x86)\NetSarang\Xshell 6\;C:\Program Files\VanDyke Software\Clients\;C:\Program Files (x86)\Common Files\Oracle\Java\javapath;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\iCLS\;C:\Program Files\Intel\Intel(R) Management Engine Components\iCLS\;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;C:\Program Files\Git\cmd;C:\Program Files\Java\jdk1.8.0_231\bin;C:\Program Files\Java\jdk1.8.0_231\jre\bin;C:\Users\putao-1\apache-maven-3.6.2\bin;C:\Program Files (x86)\HP\IdrsOCR_15.2.10.1114\;C:\Program Files (x86)\GitExtensions\;D:\Program Files\nodejs\;C:\Users\putao-1\AppData\Local\Microsoft\WindowsApps;;C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\bin;;C:\Users\putao-1\AppData\Roaming\npm;.
   //java.io.tmpdir                 =C:\Users\putao-1\AppData\Local\Temp\
   //java.compiler                  =null
   //java.ext.dirs                  =null
   //os.name                        =Windows 10
   //os.arch                        =amd64
   //os.version                     =10.0
   //file.separator                 =\
   //path.separator                 =;
   //line.separator                 =
   //user.name                      =putao-1
   //user.home                      =C:\Users\putao-1
   //user.dir                       =C:\Users\putao-1\IdeaProjects\waimai

}



