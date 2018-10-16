# spring-boot-example
###关于创建仓库
###关于bug
```
$ git push -u origin master 
To git@github.com:fansining/vueBox.git 
! [rejected] master -> master (fetch first) 
error: failed to push some refs to 'git@github.com:fansining/vueBox.git' 
hint: Updates were rejected because the remote contains work that you do 
hint: not have locally. This is usually caused by another repository pushing 
hint: to the same ref. You may want to first integrate the remote changes 
hint: (e.g., 'git pull ...') before pushing again. 
hint: See the 'Note about fast-forwards' in 'git push --help' for details.
```
看见这个输入命令 $ git push origin master -f

---------------------

本文来自 microcosm1994 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/qq_39081974/article/details/78590907?utm_source=copy 

###使用webjars 加载静态资源
```
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link th:href="@{/webjars/bootstrap/4.1.3/css/bootstrap.css}" rel="stylesheet">
 ```      
###国际化配置文件
* 1.编写国际化配置文件,抽取页面需要显示的国际化消息
* 2.spring自动配置好了国际化的资源管理组件
```java
@Bean
	public MessageSource messageSource() {
		MessageSourceProperties properties = messageSourceProperties();
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		if (StringUtils.hasText(properties.getBasename())) {
			messageSource.setBasenames(StringUtils.commaDelimitedListToStringArray(
					StringUtils.trimAllWhitespace(properties.getBasename())));
		}
		if (properties.getEncoding() != null) {
			messageSource.setDefaultEncoding(properties.getEncoding().name());
		}
		messageSource.setFallbackToSystemLocale(properties.isFallbackToSystemLocale());
		Duration cacheDuration = properties.getCacheDuration();
		if (cacheDuration != null) {
			messageSource.setCacheMillis(cacheDuration.toMillis());
		}
		messageSource.setAlwaysUseMessageFormat(properties.isAlwaysUseMessageFormat());
		messageSource.setUseCodeAsDefaultMessage(properties.isUseCodeAsDefaultMessage());
		return messageSource;
	}
```
* 3.在页面获取国际化的值
```html
<input type="checkbox" value="remember-me"/> [[#{Remember me}]]//行内表达式
//th:text 取值
<label class="sr-only" th:text="#{login.username}">Username</label>
<input type="text" name="username" class="form-control" th:placeholder="#{login.username}" required="" autofocus="">

```
####乱码问题
设置编辑器的编码格式为UTF-8

原理:
    根据请求头中 
    安装ssh
    yum install openssh-server
    开启ssh服务：
    
    终端界面键入：sudo /etc/init.d/sshd restart
    (或sudo /etc/init.d/ssh start)
    
    ---------------------
springboot 2.0以上不再支持1.7    
thymeleaf,引用公共模板的时候, 会使用thymeleaf的前后缀配置规则进行解析
```html
th:insert // 将公共片段整个插入到声明引入的元素中
th:replace// 将声明引入的元素替换为公共片段
th:include // 将被引入的片段的内容包含进这个标签中

```
更改表单的提交方式
```html
<!--发送put请求修改员工数据-->
<!--
1、SpringMVC中配置HiddenHttpMethodFilter;（SpringBoot自动配置好的）
2、页面创建一个post表单
3、创建一个input项，name="_method";值就是我们指定的请求方式
-->
<input type="hidden" name="_method" value="put" th:if="${emp!=null}"/>
```
springboot 错误处理机制
出现错误以后,会来到/error请求,然后被BasicErrorController处理,

**定制ErrorAttributes加入我们需要额外显示的错误信息**
```java
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class BasicErrorController extends AbstractErrorController {

```

1.如何定制和修改Servlet容器的相关配置
通用容器设置
server.xxx
tomcat
server.tomcat.xxx
2.切换其他的servlet容器
默认是tomcat
先排除默认的tomcat
再引入其他容器的starter,即可切换 


@Cacheable 查询并缓存,只缓存一次
@CacheEvict 清空缓存
@CachePut 查询并更新缓存,总是更新缓存
序列化的时候出错解决hibernate的 懒加载
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})//这个地方还有问题没解决,不加这个注解序列化的时候会出错
也可以使用
@Proxy(false)解决

切换,redis默认的序列化器,自定义配置redis
```java
defaultSerializer = new JdkSerializationRedisSerializer(
					classLoader != null ? classLoader : this.getClass().getClassLoader());
```
默认的序列化器 ,修改序列化器的时候,可能会出的问题
```java
 Could not write JSON: could not initialize proxy - no Session (through reference chain: com.spring.example.entities.Users
```
解决方法,去掉懒加载,实体类上加上这个注解
```java
@Proxy(lazy = false)
```
```html
Sat Oct 13 23:38:08 CST 2018
There was an unexpected error (type=Internal Server Error, status=500).
java.util.LinkedHashMap cannot be cast to com.gaoxiong.cache.entity.Department
```
具体错误在这个网址
```html
https://stackoverflow.com/questions/43220964/spring-data-redis-cacheable-java-lang-classcastexception-java-util-hashmap-can/49000379#comment73517832_43222354
```
还是外国的网站厉害,国内的网站只会抄来抄去 ,解决不了问题.
```java
You need to set setObjectMapper

Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new 
Jackson2JsonRedisSerializer<Object>(Object.class);
ObjectMapper om = new ObjectMapper();
om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
jackson2JsonRedisSerializer.setObjectMapper(om);
```
****消息队列****
RabbitMQ的几种类型
direct Exchange
消息中的路由键(routing_key)如果和Binding中的binding_key一致,交换器就将消息发到对应的队列中.
路由键与队列名完全匹配,如果一个队列绑定到交换机要求路由键为"dog",则值转发routing_key标记为"dog"的消息.
是为单播模式
Fanout Exchange
每个发到fanout类型交换器的消息都会分到所有绑定的队列上去.fanout交换器不处理路由键,
只是简单的将队列绑定到交换器上,每个发送到交换器的消息都会被转发到与该交换器绑定的所有队列上.
是为广播模式,每台子网内的主机都获得了一份复制的消息.fanout类型转发消息是最快的.
Topic Exchange
topic 交换器通过模式匹配分配消息的路由键属性,将路由键和某个模式进行匹配,此事队列需要绑定到一个模式上.它将路由键和绑定键的字符串切分成单词,这些单词
之间用点隔开.
她同样也会识别两个通配符:"#"匹配0个或多个单词,*匹配一个单词
