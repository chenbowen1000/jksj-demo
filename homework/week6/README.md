6.（必做）基于电商交易场景（用户、商品、订单），设计一套简单的表结构，提交 DDL 的 SQL 文件到 Github（后面 2 周的作业依然要是用到这个表结构）。
    
    作业文件放在sql文件目录下
    
    1.项目ddl脚本应该基于类似flyway做数据库版本控制，
    假如有分库分表 DDL目录分  shard-dll 分库脚本,sql 非分库脚本两个，这边就省事建一个目录

    
    2.订单表设计
        * t_trade_order_header 订单核心信息
        * t_trade_order_item 订单商品明细行

        t_trade_order_payment 单支付信息
        t_trade_order_item_promotion 订单商品优惠明细
        t_trade_order_delivery 订单物流信息
        t_trade_order_coupon 订单优惠券信息
        t_trade_order_point 订单积分扣点信息

    3.商品
        t_sku 商品详细信息

    4.会员

    