# 简单的注解结合spring管理Demo

---

## 关键的类：

* [SpringContextUtil](src/main/java/me/shuang/annodemo001/util/SpringContextUtil.java) 继承`ApplicationContextAware`
  以获得`applicationContext`
* [DemoUtil](src/main/java/me/shuang/annodemo001/util/DemoUtil.java) 初始化Map及提供获取实例的接口
* [BeanCollectUtil](src/main/java/me/shuang/annodemo001/util/BeanCollectUtil.java)
  从Spring容器中获取被标记的类，可配置要被管理的类是否继承了某接口

---

## 测试入口:

本地运行项目，[点击此处](http:////localhost:8080/swagger-ui/)进入swagger进行测试