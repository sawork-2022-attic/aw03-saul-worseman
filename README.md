# WebPOS

The demo shows a simple POS system in MVC architecture, which replaces the shell interface in aw02 with a pos web ui (https://github.com/bshbsh404/simple-pos-ui
).

![](screenshot.png)

To run

```shell
mvn clean spring-boot:run
```

Currently, it just lists the products for sale with a cart with one item (just for demonstration). 

Please read the tutorial at  https://www.baeldung.com/spring-boot-crud-thymeleaf and make the POS system robust and fully functional. You can also refer to other articles, for instance https://www.baeldung.com/tag/thymeleaf/ .



And please elaborate your understanding in MVC architecture via this homework in your README.md.

## 对WebPos的完善
+ 现在Cancel，Add等按钮能够正确响应了
+ 现在每个商品的名字价格等能够正确显示了
+ 现在可以正确计算总价了

## 亟待完善的地方
+ 引入了一些bug，+-以及trash的图标不能正确显示，不能排除是css还是html问题
+ 商品种类没有分类
+ search功能没有实现

## 我对MVC的理解
感觉MVC也是分层思想的一种体现，M和V是从两个视角看数据的体现，我们精心挑选展示给用户的View部分，然后根据暴露出来的接口设计Controller提供对Model有限的操作，这样可以大大降低设计时的心智负担，不必担心用户有一些奇怪的操作，就像为了防止sql注入把生日设置成轮盘选择一样。