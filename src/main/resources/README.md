使用端 我们在使用 mybatis 的时候是不是需要使用 SqlMapConfig.xml 配置文件，用来存放数据库的连接信息，以及 mapper.xml 的指向信息。mapper.xml 配置文件用来存放 sql 信息。
所以我们在使用端来创建两个文件 SqlMapConfig.xml 和 mapper.xml。 框架端 框架端要做哪些事情呢？ 如下：

1、获取配置文件。也就是获取到使用端的 SqlMapConfig.xml 以及 mapper.xml 的文件 2、解析配置文件。对获取到的文件进行解析，获取到连接信息，sql，参数，返回类型等等。这些信息都会保存在
configuration 这个对象中。 3、创建 SqlSessionFactory，目的是创建 SqlSession 的一个实例。 4、创建 SqlSession ,用来完成上面原始 JDBC 的那些操作。

那在 SqlSession 中 进行了哪些操作呢？

1、获取数据库连接 2、获取 sql ,并对 sql 进行解析 3、通过内省，将参数注入到 preparedStatement 中 4、执行 sql 5、通过反射将结果集封装成对象