# student-management-system

## 主要模块


* **student-management-system-commons** 公共类
* **student-management-system-domin** 数据库对应实体类
* **student-management-system-class** 班级模块
* **student-management-system-grades** 成绩模块
* **student-management-system-permission** 权限模块
* **student-management-system-student** 学生模块
* **student-management-system-user** 用户模块
* **student-management-system-web** web层


#### 项目规范
1. 基础规范
    - 类名使用UpperCamelCase风格，DO / BO / DTO / VO / AO / PO / UID除外
    - 方法名、参数名、成员变量、局部变量都统一使用 lowerCamelCase 风格，必须遵从驼峰形式
    - 常量命名全部大写，单词间用下划线隔开
    - 抽象类命名使用 Abstract 或 Base 开头;异常类命名使用 Exception 结尾；测试类，以 Test 结尾
    - 包名统一使用小写
    - 枚举类名建议带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开
    
2. Service/DAO 层方法命名规约
    - 获取单个对象的方法用 get 做前缀
    - 获取多个对象的方法用 list 做前缀
    - 获取统计值的方法用 count 做前缀
    - 插入的方法用 insert 做前缀
    - 删除的方法用 delete 做前缀
    - 修改的方法用 update 做前缀
    - 分页查询 page 做前缀
    
3. 领域模型命名规约
    - 数据对象 xxx,xxx 即为数据表名
    - 数据传输对象：xxxDTO，xxx 为业务领域相关的名称
    - 展示对象：xxxVO，xxx 一般为网页名称
    
4. 代码格式
    - 如果是大括号内为空，则简洁地写成{}即可，不需要换行
        - 左大括号前不换行
        - 左大括号后换行
        - 右大括号前换行
        - 右大括号后还有 else 等代码则不换行；表示终止的右大括号后必须换行
    - if/for/while/switch/do 等保留字与括号之间都必须加空格
    - 采用 4 个空格缩进
    ```
    public static void main(String[] args) { 
        // 缩进 4 个空格
        String say = "hello"; 
        // 运算符的左右必须有一个空格
        int flag = 0; 
        // 关键词 if 与括号之间必须有一个空格，括号内的 f 与左括号，0 与右括号不需要空格
        if (flag == 0) { 
            System.out.println(say); 
        } 
        // 左大括号前加空格且不换行；左大括号后换行
        if (flag == 1) { 
            System.out.println("world"); 
        // 右大括号前换行，右大括号后有 else，不用换行
        } else { 
            System.out.println("ok"); 
        // 在右大括号后直接结束，则必须换行
        } 
    }
    ```
    - 单行字符数限制不超过 120 个，超出需要换行
    ```
    StringBuffer sb = new StringBuffer(); 
    // 超过 120 个字符的情况下，换行缩进 4 个空格，点号和方法名称一起换行
    sb.append("zi").append("xin")...
        .append("huang")... 
        .append("huang")... 
        .append("huang");
    ```
4. RESTful请求命名
```
GET /zoos：列出所有动物园
POST /zoos：新建一个动物园
GET /zoos/ID：获取某个指定动物园的信息
PUT /zoos/ID：更新某个指定动物园的信息（提供该动物园的全部信息）
PATCH /zoos/ID：更新某个指定动物园的信息（提供该动物园的部分信息）
DELETE /zoos/ID：删除某个动物园
GET /zoos/ID/animals：列出某个指定动物园的所有动物
DELETE /zoos/ID/animals/ID：删除某个指定动物园的指定动物
    
