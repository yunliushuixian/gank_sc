1.启动报错：Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
om.mysql.cj.jdbc.Driver

com.mysql.jdbc.Driver'已经被弃用了、应当使用新的驱动com.mysql.cj.jdbc.Driver

2.The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more than one time zone
根据报错我们知道这是时间报错，没有指定明确的时区，是因为新版的mysql会询问是否SSL连接，返回一个Boolean值，我们需要手动指定true或者false。所以再次更改配置文件中的 url 满足其要求即可，如下
?characterEncoding=utf-8&amp;serverTimezone=GMT+8&amp;useSSL=false